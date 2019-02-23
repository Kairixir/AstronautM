package com.sevcikondrej.service;

import com.sevcikondrej.DAO.AstronautDAO;
import com.sevcikondrej.entity.Astronaut;
import com.sevcikondrej.service.AstronautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AstronautServiceImpl implements AstronautService {

    // need to inject astronaut DAO
    @Autowired
    private AstronautDAO astronautDAO;

    @Override
    @Transactional
    public List<Astronaut> getAstronauts() {
        return astronautDAO.getAstronauts();
    }

    @Override
    @Transactional
    public void addAstronaut(Astronaut theAstronaut) {
        astronautDAO.saveAstronaut(theAstronaut);
    }

    @Override
    @Transactional
    public Astronaut getAstronaut(int theId) {

        return astronautDAO.getAstronaut(theId);
    }

    @Override
    @Transactional
    public void deleteAstronaut(int theId) {
        astronautDAO.deleteAstronaut(theId);
    }

    @Override
    @Transactional
    public List<Astronaut> searchAstronaut(String theSearchName) {
        return astronautDAO.searchAstronauts(theSearchName);
    }
}
