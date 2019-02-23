package com.sevcikondrej.DAO;

import com.sevcikondrej.entity.Astronaut;

import java.util.List;

public interface AstronautDAO {

    public List<Astronaut> getAstronauts();

    void saveAstronaut(Astronaut theAstronaut);

    Astronaut getAstronaut(int theId);

    void deleteAstronaut(int theId);

    List<Astronaut> searchAstronauts(String theSearchName);
}
