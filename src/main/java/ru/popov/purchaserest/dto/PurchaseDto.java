package ru.popov.purchaserest.dto;

public class PurchaseDto {
    private Long id;
    private String name;

    public PurchaseDto(String name) {
        this.name = name;
    }

    public PurchaseDto() {
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
}
