package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.popov.purchaserest.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
