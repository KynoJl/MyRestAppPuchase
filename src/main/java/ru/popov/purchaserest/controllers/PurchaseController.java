package ru.popov.purchaserest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.popov.purchaserest.dto.ProductDto;
import ru.popov.purchaserest.dto.PurchaseDto;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Product;
import ru.popov.purchaserest.models.Purchase;
import ru.popov.purchaserest.service.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final  PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @GetMapping("/")
    public List<Purchase> getPurchase(){
        return purchaseService.fundAll();
    }

    @GetMapping("/{id}")
    public Purchase getPurchase(@PathVariable Long id){

        return purchaseService.findOne(id);
    }

    @PostMapping
    ResponseEntity <HttpStatus> create(@RequestBody PurchaseDto purchaseDto){
        purchaseService.saves(convertToPurchase(purchaseDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        purchaseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody PurchaseDto purchaseDto){
        purchaseService.update(id,convertToPurchase(purchaseDto));
    }

    public Purchase convertToPurchase(PurchaseDto purchaseDto){
        Purchase purchase = new Purchase();
        purchase.setName(purchaseDto.getName());
        purchase.setCount(purchaseDto.getCount());
        purchase.setPerson(purchaseDto.getPerson());
        purchase.setProduct(purchaseDto.getProduct());
        return purchase;
    }


}
