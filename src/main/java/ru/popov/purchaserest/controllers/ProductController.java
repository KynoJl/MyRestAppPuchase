package ru.popov.purchaserest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.popov.purchaserest.dto.ProductDto;
import ru.popov.purchaserest.mapper.ProductMapper;
import ru.popov.purchaserest.models.Product;
import ru.popov.purchaserest.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/")
    public List<Product> getProduct(){
       return productService.fundAll();
    }

    @GetMapping("/{id}")
    public Product getPurchase(@PathVariable Long id){

        return productService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }



    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody ProductDto productDto){
        productService.update(id,productMapper.convertToProduct(productDto));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody ProductDto productDto){
        productService.saves(productMapper.convertToProduct(productDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
