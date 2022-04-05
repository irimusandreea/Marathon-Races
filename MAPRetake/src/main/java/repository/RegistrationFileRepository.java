package repository;

import model.Registration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationFileRepository extends RegistrationInMemoryRepo {

    private String filename;
    private RaceRepository raceRepository;
    private static int idGenerator = 0;

    public RegistrationFileRepository(String filename, RaceRepository raceRepository) {

        this.filename = filename;
        this.raceRepository = raceRepository;
        readFromFile();

    }

    private void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            try {
                idGenerator = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid Value for idGenerator, starting from 0");
            }
            while ((line = br.readLine()) != null) {
                String[] elems = line.split(";");
                if (elems.length != 6) {
                    System.err.println("Invalid line ..." + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(elems[0]);
                    Registration o = new Registration(id, elems[1], elems[2], elems[3], elems[4], elems[5]);
                    super.add(o);

                } catch (NumberFormatException ex) {
                    System.err.println("Invalid data " + ex);
                } catch (RepositoryException ex) {
                    System.err.println("Repository Error " + ex);
                }
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error reading " + ex);
        }

    }

    @Override
    public Registration add(Registration el) {

        el.setID(getNextId());
        super.add(el);
        writeToFile();
        return el;

    }

    @Override
    public void delete(Registration el) {

        super.delete(el);
        writeToFile();

    }

    @Override
    public void update(Registration el, Integer integer) {

        super.update(el, integer);
        writeToFile();

    }

    private void writeToFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println(idGenerator);
            for (Registration a : findAll()) {
                pw.println(a.getID() + ";" + a.getParticipant()+";"+a.getPhoneNr() + ";" + a.getAddress() + ";" + a.getAge() + ";" + a.getRace());
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error writing " + ex);
        }
    }

    private static int getNextId() {
        return idGenerator++;
    }


}
