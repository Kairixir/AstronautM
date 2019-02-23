package com.sevcikondrej.service;

import com.sevcikondrej.entity.Astronaut;

import java.util.List;

public interface AstronautService {

    public List<Astronaut> getAstronauts();

    void addAstronaut(Astronaut theAstronaut);

    Astronaut getAstronaut(int theId);

    void deleteAstronaut(int theId);

    List<Astronaut> searchAstronaut(String theSearchName);
}
