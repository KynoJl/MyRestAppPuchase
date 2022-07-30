package ru.popov.purchaserest.dto;

import javax.persistence.Column;

public class InformationDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private int count;
    private double amount;
    private String purchase_date;
    private String purchase;

    public InformationDto() {
    }

    public InformationDto(Long id, String name, String lastName, int age, int count, double amount, String purchase_date, String purchase) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.count = count;
        this.amount = amount;
        this.purchase_date = purchase_date;
        this.purchase = purchase;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }
}
