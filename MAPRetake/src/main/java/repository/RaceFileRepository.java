package repository;

import model.Race;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RaceFileRepository extends RaceInMemoryRepo {

    private String filename;
    private static int idGenerator=0;

    public RaceFileRepository(String filename) {

        this.filename = filename;
        readFromFile();

    }

    private void readFromFile() {
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            String line=br.readLine();
            try{
                idGenerator=Integer.parseInt(line);
            }catch (NumberFormatException ex){
                System.err.println("Invalid Value for idGenerator, starting from 0");
            }
            while((line=br.readLine())!=null){
                String[] elems=line.split(";");
                if (elems.length!=5){
                    System.err.println("Invalid line ..."+line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(elems[0]);
                    Race o=new Race(id,elems[1],elems[2],elems[3],elems[4]);
                    super.add(o);

                }catch(NumberFormatException ex){
                    System.err.println("Invalid data "+ex);
                }catch (RepositoryException ex){
                    System.err.println("Repository Error "+ex);
                }
            }
        }catch (IOException ex){
            throw new RepositoryException("Error reading "+ex);
        }

    }

    private void writeToFile(){
        try(PrintWriter pw=new PrintWriter(filename)){
            pw.println(idGenerator);
            for(Race o:findAll()){
                pw.println(o.getID()+";"+o.getName()+";"+o.getType()+";"+o.getDistance()+";"+o.getDate());
            }
        }catch(IOException ex){
            throw new RepositoryException("Error writing "+ex);
        }

    }

    @Override
    public Race add(Race el) {

        el.setID(getNextId());
        super.add(el);
        writeToFile();
        return el;

    }

    @Override
    public void delete(Race el) {

        super.delete(el);
        writeToFile();

    }

    @Override
    public void update(Race el, Integer integer) {

        super.update(el, integer);
        writeToFile();

    }

    private static int getNextId(){
        return idGenerator++;
    }

}
