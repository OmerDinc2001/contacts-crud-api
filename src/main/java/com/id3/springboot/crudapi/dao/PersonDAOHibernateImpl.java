package com.id3.springboot.crudapi.dao;

import java.util.List;

import com.id3.springboot.crudapi.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class PersonDAOHibernateImpl implements PersonDAO {

    private EntityManager entityManager;

    @Autowired
    public PersonDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Person> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Person> theQuery = currentSession.createQuery("from Person", Person.class);
        List<Person> people = theQuery.getResultList();
        return people;
    }

    @Override
    public Person findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Person thePerson = currentSession.get(Person.class, id);
        return thePerson;
    }

    @Override
    public void save(Person person) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(person);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Person where id=:personId");
        theQuery.setParameter("personId", id);
        theQuery.executeUpdate();
    }
}