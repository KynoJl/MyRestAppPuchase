package ru.popov.purchaserest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.popov.purchaserest.dto.PurchaseDto;
import ru.popov.purchaserest.mapper.PurchaseMapper;
import ru.popov.purchaserest.models.Purchase;
import ru.popov.purchaserest.service.PurchaseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final  PurchaseService purchaseService;
    private final PurchaseMapper purchaseMapper;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, PurchaseMapper purchaseMapper) {
        this.purchaseService = purchaseService;
        this.purchaseMapper = purchaseMapper;
    }


    @GetMapping("/")
    public ResponseEntity <List<Purchase>> getPurchase(){
        return  ResponseEntity.ok(purchaseService.fundAll()) ;
    }

    @GetMapping("/{id}")
    public Purchase getPurchase(@PathVariable Long id){

        return purchaseService.findOne(id);
    }

    @PostMapping
    ResponseEntity  create(@RequestBody PurchaseDto purchaseDto){
       Purchase item = purchaseService.save(purchaseMapper.convertToPurchase(purchaseDto));
        return ResponseEntity.ok("Purchase "+ item.getName() + " CREATE, " + "id " + item.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        purchaseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody PurchaseDto purchaseDto){
        purchaseService.update(id,purchaseMapper.convertToPurchase(purchaseDto));
    }


}
