package com.id3.springboot.crudapi.service;

import com.id3.springboot.crudapi.dao.PersonDAO;
import com.id3.springboot.crudapi.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO thePersonDAO){
        personDAO = thePersonDAO;
    }

    @Override
    @Transactional
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    @Transactional
    public Person findById(int id) {
        return personDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        personDAO.deleteById(id);
    }
}
