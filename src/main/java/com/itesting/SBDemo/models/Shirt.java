package com.itesting.SBDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "shirts")
public class Shirt {

    @Column(name="colour")
    private String colour;

    @Column(name="collar_size")
    private float collarSize;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("shirts")
    @JoinColumn( name = "person_id", nullable = false)
    private Person person;

    public Shirt(String colour, float collarSize, Person person) {
        this.colour = colour;
        this.collarSize = collarSize;
        this.id = id;
        this.person = person;
    }

    public Shirt() {
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getCollarSize() {
        return collarSize;
    }

    public void setCollarSize(float collarSize) {
        this.collarSize = collarSize;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
