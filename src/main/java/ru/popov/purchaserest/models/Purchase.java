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

    @OneToOne
    @JoinColumn(name = "information_id", referencedColumnName = "id")
    private Information information;



    public Purchase() {
    }

    public Purchase(String name, Information information) {
        this.name = name;
        this.information = information;
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

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "\nPurchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
