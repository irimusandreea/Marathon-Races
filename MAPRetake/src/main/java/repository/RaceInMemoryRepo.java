package repository;

import model.Race;

import java.util.List;
import java.util.stream.Collectors;

public class RaceInMemoryRepo extends AbstractRepository<Integer, Race> implements RaceRepository {

    public RaceInMemoryRepo() {
    }

    @Override
    public List<Race> findByParameter(String parameter) {

        return getAll().stream().filter(x -> x.getDate().toLowerCase().contains(parameter.toLowerCase())).collect(Collectors.toList());

    }
}
