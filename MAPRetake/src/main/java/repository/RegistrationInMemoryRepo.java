package repository;

import model.Registration;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationInMemoryRepo extends AbstractRepository<Integer, Registration> implements RegistrationRepository {

    public RegistrationInMemoryRepo() {
    }

    @Override
    public List filterByRace(String race) {

        return getAll().stream().filter(x -> x.getRace().equals((race))).collect((Collectors.toList()));

    }

}
