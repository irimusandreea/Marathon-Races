package repository;

import model.Race;

import java.util.List;

public interface RaceRepository extends Repository<Integer, Race> {

    List<Race> findByParameter(String parameter);

}
