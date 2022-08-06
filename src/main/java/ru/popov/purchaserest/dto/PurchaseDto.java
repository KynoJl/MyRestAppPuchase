package ru.popov.purchaserest.dto;

import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Product;

public class PurchaseDto {
    private Long id;
    private String name;
    private int count;
//    private Product product;
    private Person person;

    public PurchaseDto() {
    }

    public PurchaseDto(Long id, String name, int count, Person person) {
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