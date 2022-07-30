package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
