package com.id3.springboot.crudapi.service;

import com.id3.springboot.crudapi.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();

    public Person findById(int id);

    public void save(Person person);

    public void deleteById(int id);
}
