package com.itesting.SBDemo.controllers;

import com.itesting.SBDemo.models.Bank;
import com.itesting.SBDemo.respositories.BankRepository;
import org.aspectj.lang.annotation.DeclareError;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class BankController {

    @Autowired
    BankRepository bankRepository;

    //    Create
    @PostMapping(value="/banks")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank){
        Bank newBank = bankRepository.save(bank);
        return new ResponseEntity<>(newBank, HttpStatus.CREATED);
    }

    //    Read
    @GetMapping(value="/banks")
    public ResponseEntity<List<Bank>> getAllBanks() {
        return new ResponseEntity<>(bankRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/banks/{id}")
    public ResponseEntity<Optional<Bank>> getBanks(@PathVariable Long id){
        return new ResponseEntity<>(bankRepository.findById(id), HttpStatus.OK);
    }

    //    Update
    @PutMapping(value ="/banks/{id}")
    public ResponseEntity<Bank> putBank(@RequestBody Bank bank, @PathVariable Long id){
        Bank bankToUpdate = bankRepository.findById(id).get();
        bankToUpdate.setPersons(bank.getPersons());
        bankToUpdate.setInterestRate(bank.getInterestRate());
        bankToUpdate.setName(bank.getName());
        bankRepository.save(bankToUpdate);

        return new ResponseEntity<>(bankToUpdate, HttpStatus.OK);
    }

    //    Delete

    @DeleteMapping(value="/banks/{id}")
    public  ResponseEntity<Long> deleteBank(@PathVariable Long id){
        bankRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
