package com.sevcikondrej.DAO;

import com.sevcikondrej.DAO.AstronautDAO;
import com.sevcikondrej.entity.Astronaut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class AstronautDAOImpl implements AstronautDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Astronaut> getAstronauts() {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query and order by last name
        Query<Astronaut> theQuery = currentSession.createQuery("from Astronaut order by lastName", Astronaut.class);
        //execute query and get result list
        List<Astronaut> astronauts = theQuery.getResultList();

        //return the results
        return astronauts;
    }

    @Override
    public void saveAstronaut(Astronaut theAstronaut) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //fixing date - date that is entered was writtten in the database one day behind
        LocalDate correctDate= theAstronaut.getDateOfBirth().plusDays(1);
        theAstronaut.setDateOfBirth(correctDate);
        //save/update the astronaut
        currentSession.saveOrUpdate(theAstronaut);

    }

    @Override
    public Astronaut getAstronaut(int theId) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //get astronaut
        Astronaut theAstronaut = currentSession.get(Astronaut.class,theId);

        //send astronaut to the service
        return theAstronaut;
    }

    @Override
    public void deleteAstronaut(int theId) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //delete astronaut
        Query theQuery = currentSession.createQuery("delete from Astronaut where id=:astronautId");
        theQuery.setParameter("astronautId",theId);
        //executing the update
        theQuery.executeUpdate();
    }

    @Override
    public List<Astronaut> searchAstronauts(String theSearchName) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create null query
        Query theQuery = null;
        //query list of astronauts using name
        if (theSearchName!= null && theSearchName.trim().length()>0){
            theQuery = currentSession.createQuery("from Astronaut where lower(firstName) LIKE :searchName " +
                    "OR lower(lastName) LIKE :searchName", Astronaut.class );

        theQuery.setParameter("searchName","%"+theSearchName.toLowerCase()+"%");
        }
        else{
            //the search name is empty so just get all the astronauts
            theQuery = currentSession.createQuery("from Astronaut", Astronaut.class);
        }
        //get list of astronauts LIKE name
        List<Astronaut> astronauts = theQuery.getResultList();

        //returning astronauts to service
        return astronauts;
    }

}


