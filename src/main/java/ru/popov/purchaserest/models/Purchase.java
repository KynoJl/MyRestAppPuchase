package ru.popov.purchaserest.models;

import liquibase.pro.packaged.I;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    @Column(name = "DATA_PURCHASE")
    private LocalDate  datePurchaseLocal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    public Purchase() {
    }

    public Purchase(String name, int count, LocalDate datePurchaseLocal, Person person, Product product) {
        this.name = name;
        this.count = count;
        this.datePurchaseLocal = datePurchaseLocal;
        this.person = person;
        this.product = product;
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

    public LocalDate getDatePurchaseLocal() {
        return datePurchaseLocal;
    }

    public void setDatePurchaseLocal(LocalDate datePurchaseLocal) {
        this.datePurchaseLocal = datePurchaseLocal;

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
