package ru.popov.purchaserest.models;

import liquibase.pro.packaged.I;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="PURCHASE")
public class Purchase {
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COUNT")
    private int count;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;


    public Purchase() {
    }

    public Purchase(Long id, String name, int count, Person person) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
