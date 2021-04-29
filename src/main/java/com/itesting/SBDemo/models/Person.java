package com.itesting.SBDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.tools.javah.Gen;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="persons")
public class Person {

    @Column(name = "name")
    private String name;

    @Column(name = "income")
    private int income;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"person"})
    private List<Shirt> shirts;

    @ManyToMany
    @JsonIgnoreProperties(value = {"persons"})
    @JoinTable(
            name = "banks_persons",
            joinColumns = { @JoinColumn(
                    name = "person_id",
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "bank_id",
                    updatable = false)
            }
    )
    private List<Bank> banks;

    public Person(String name, int income) {
        this.name = name;
        this.income = income;
        this.id = id;
        this.shirts = new ArrayList<Shirt>();
        this.banks = new ArrayList<Bank>();
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addShirt(Shirt shirt){this.shirts.add(shirt);}

    public List<Shirt> getShirts() {
        return shirts;
    }

    public void setShirts(List<Shirt> shirts) {
        this.shirts = shirts;
    }

    public void addBank(Bank bank){this.banks.add(bank);}

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
}
