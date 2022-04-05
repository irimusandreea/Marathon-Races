package service;

import model.Race;
import model.Registration;
import repository.RaceRepository;
import repository.RegistrationRepository;

import java.util.ArrayList;
import java.util.List;


public class Service {

    private RaceRepository c1Repo;
    private RegistrationRepository c2Repo;

    public Service(RaceRepository c1Repo, RegistrationRepository c2Repo) {

        this.c1Repo = c1Repo;
        this.c2Repo = c2Repo;

    }

    public Race add1(Race c) {
        return c1Repo.add(c);
    }

    public List<Race> getAll1(){
        List<Race> lc=new ArrayList<>();
        for(Race c:c1Repo.findAll()){
            lc.add(c);
        }
        return lc;
    }

    public Registration add2(Registration c){return c2Repo.add(c);}

    public List<Registration> getAll2(){
        List<Registration> lc=new ArrayList<>();
        for(Registration c:c2Repo.findAll()){
            lc.add(c);
        }
        return lc;
    }

    public Race getInfo(String value) {

        for (Race p: c1Repo.findAll()){
            if (p.getDate().equals(value))
                return p;
        }
        return null;

    }

    public List<Race> getByParameter(String parameter) {
        return c1Repo.findByParameter(parameter);
    }

    public List<Registration> getReport1(String value){
        return c2Repo.filterByRace(value);
    }

}
