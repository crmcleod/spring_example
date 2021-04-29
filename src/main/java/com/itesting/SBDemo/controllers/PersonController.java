package com.itesting.SBDemo.controllers;

import com.itesting.SBDemo.models.Person;
import com.itesting.SBDemo.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    //    Create
    @PostMapping(value="/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person newPerson = personRepository.save(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    //    Read
    @GetMapping(value="/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/persons/{id}")
    public ResponseEntity<Optional<Person>> getPersons(@PathVariable Long id){
        return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
    }

    //    Update
    @PutMapping(value ="/persons/{id}")
    public ResponseEntity<Person> putPerson(@RequestBody Person person, @PathVariable Long id){
        Person personToUpdate = personRepository.findById(id).get();
        personToUpdate.setBanks(person.getBanks());
        personToUpdate.setIncome(person.getIncome());
        personToUpdate.setName(person.getName());
        personToUpdate.setShirts(person.getShirts());
        personRepository.save(personToUpdate);

        return new ResponseEntity<>(personToUpdate, HttpStatus.OK);
    }

    //    Delete

    @DeleteMapping(value="/persons/{id}")
    public  ResponseEntity<Long> deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
