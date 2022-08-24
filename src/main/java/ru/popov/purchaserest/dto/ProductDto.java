package ru.popov.purchaserest.dto;

import liquibase.pro.packaged.L;
import ru.popov.purchaserest.models.Product;

public class ProductDto {
    private Long id;
    private String name;
    private double price;


    public ProductDto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDto() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
