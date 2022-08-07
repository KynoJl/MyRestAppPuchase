package ru.popov.purchaserest.dto;

import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Product;

public class PurchaseDto {
    private Long id;
    private String name;
    private int count;
    private String dataPurchase;

    private Person person;

    private Product product;

    public PurchaseDto() {
    }

    public PurchaseDto(Long id, String name, int count, String dataPurchase, Person person, Product product) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.dataPurchase = dataPurchase;
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

    public String getDataPurchase() {
        return dataPurchase;
    }

    public void setDataPurchase(String dataPurchase) {
        this.dataPurchase = dataPurchase;
    }
}