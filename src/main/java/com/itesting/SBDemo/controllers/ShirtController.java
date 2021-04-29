package com.itesting.SBDemo.controllers;

import com.itesting.SBDemo.models.Shirt;
import com.itesting.SBDemo.respositories.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ShirtController {

    @Autowired
    ShirtRepository shirtRepository;

    //    Create
    @PostMapping(value="/shirts")
    public ResponseEntity<Shirt> createShirt(@RequestBody Shirt shirt){
        Shirt newShirt = shirtRepository.save(shirt);
        return new ResponseEntity<>(newShirt, HttpStatus.CREATED);
    }

    //    Read
    @GetMapping(value="/shirts")
    public ResponseEntity<List<Shirt>> getAllShirts() {
        return new ResponseEntity<>(shirtRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/shirts/{id}")
    public ResponseEntity<Optional<Shirt>> getShirts(@PathVariable Long id){
        return new ResponseEntity<>(shirtRepository.findById(id), HttpStatus.OK);
    }

    //    Update
    @PutMapping(value ="/shirts/{id}")
    public ResponseEntity<Shirt> putShirt(@RequestBody Shirt shirt, @PathVariable Long id){
        Shirt shirtToUpdate = shirtRepository.findById(id).get();
        shirtToUpdate.setCollarSize(shirt.getCollarSize());
        shirtToUpdate.setColour(shirt.getColour());
        shirtToUpdate.setPerson(shirt.getPerson());
        shirtRepository.save(shirtToUpdate);

        return new ResponseEntity<>(shirtToUpdate, HttpStatus.OK);
    }

    //    Delete

    @DeleteMapping(value="/shirts/{id}")
    public  ResponseEntity<Long> deleteShirt(@PathVariable Long id){
        shirtRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
