package repository;

import model.Registration;

import java.util.Collection;
import java.util.List;


public interface RegistrationRepository extends Repository<Integer, Registration> {

    List filterByRace(String race);

}
