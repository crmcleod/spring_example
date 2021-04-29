package com.itesting.SBDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="banks")
public class Bank {

    @Column(name="name")
    private String name;

    @Column(name="interest_rates")
    private float interestRate;

    @ManyToMany
    @JsonIgnoreProperties(value = {"banks"})
    @JoinTable(
            name = "banks_persons",
            joinColumns = { @JoinColumn(
                    name = "bank_id",
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "person_id",
                    updatable = false)
            }
    )
    private List<Person> persons;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Bank(String name, float interestRate) {
        this.name = name;
        this.interestRate = interestRate;
        this.persons = new ArrayList<Person>();
        this.id = id;
    }

    public Bank() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }


    public void addPerson(Person person){this.persons.add(person);}
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
