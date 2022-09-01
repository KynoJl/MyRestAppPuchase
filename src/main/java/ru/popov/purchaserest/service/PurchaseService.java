package ru.popov.purchaserest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.popov.purchaserest.models.Purchase;
import ru.popov.purchaserest.repository.PurchaseRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> fundAll() {
        return purchaseRepository.findAll();
    }

    public Purchase findOne(Long id) {
        Optional<Purchase> foundPerson = purchaseRepository.findById(id);
        return foundPerson.orElse(null);
    }


    public Purchase save(Purchase purchase) {
        purchaseRepository.save(purchase);
        return purchase;
    }


    public void delete(Long id) {
        purchaseRepository.deleteById(id);
    }


    public void update(Long id, Purchase purchase) {
        Purchase item = purchaseRepository.findById(id).orElseThrow(RuntimeException::new);
        item.setName(purchase.getName());
        item.setCount(purchase.getCount());
        item.setDatePurchaseLocal(purchase.getDatePurchaseLocal());
        item.setPerson(purchase.getPerson());
        item.setProduct(purchase.getProduct());
        purchaseRepository.save(item);
    }

    public List<Purchase> fundWeek() {
        LocalDate localDateWeek = LocalDate.now().minusDays(7);
        return purchaseRepository.findLastWeek(localDateWeek);
    }

    public List<Purchase> getCount() {
        LocalDate localDateMonths = LocalDate.now().minusMonths(1);
        return  purchaseRepository.maxCount(localDateMonths);
    }


}

