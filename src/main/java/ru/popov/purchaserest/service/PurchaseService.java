package ru.popov.purchaserest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Purchase;
import ru.popov.purchaserest.repository.PersonRepository;
import ru.popov.purchaserest.repository.PurchaseRepository;

import java.util.List;
import java.util.Optional;

@Service

public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, PersonRepository personRepository, PersonRepository personRepository1) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> fundAll(){
        return purchaseRepository.findAll();
    }

    public Purchase findOne(Long id) {
        Optional<Purchase> foundPerson = purchaseRepository.findById(id);
        return foundPerson.orElse(null);
    }


    public void saves(Purchase purchase){
        purchaseRepository.save(purchase);
    }


    public void delete(Long id) {
        purchaseRepository.deleteById(id);
    }


    public void update(Long id, Purchase purchase) {
        Purchase item = purchaseRepository.findById(id).orElseThrow(RuntimeException::new);
        item.setName(purchase.getName());
        item.setCount(purchase.getCount());
        item.setPerson(purchase.getPerson());
        item.setProduct(purchase.getProduct());
        purchaseRepository.save(item);
    }

}

