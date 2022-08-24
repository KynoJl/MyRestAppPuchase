package ru.popov.purchaserest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Product;
import ru.popov.purchaserest.models.Purchase;
import ru.popov.purchaserest.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> fundAll(){
        return productRepository.findAll();
    }

    @Transactional
    public void saves(Product product){
        productRepository.save(product);
    }


    public Product findOne(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElse(null);
    }
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    @Transactional
    public void update(Long id, Product product) {
        Product item = productRepository.findById(id).orElseThrow(RuntimeException::new);
        item.setName(product.getName());
        item.setPrice(product.getPrice());
    }

}
