package com.id3.springboot.crudapi.rest;

import com.id3.springboot.crudapi.entity.Person;
import com.id3.springboot.crudapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService thePersonService){
        personService = thePersonService;
    }

    @GetMapping("/people")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/people/{personId}")
    public Person getPerson(@PathVariable Long personId){ // DIKKAT
        Person thePerson = personService.findById(personId);
        if(thePerson == null){
            throw new RuntimeException("person id not found: " + personId);
        }
        return thePerson;
    }
    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person){
        person.setId(0L);
        personService.save(person);
        return person;
    }

    @PutMapping("/people")
    public Person updatePerson(@RequestBody Person person){
        personService.save(person);
        return person;
    }

    @DeleteMapping("/people/{personId}")
    public String deletePerson(@PathVariable Long personId){
        Person tempPerson = personService.findById(personId);
        if(tempPerson == null){
            throw new RuntimeException("peron id not found: " + personId);
        }
        personService.deleteById(personId);
        return "deleted person id: " + personId;
    }
}
