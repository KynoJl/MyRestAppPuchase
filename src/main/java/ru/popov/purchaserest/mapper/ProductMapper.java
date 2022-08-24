package ru.popov.purchaserest.mapper;

import org.springframework.stereotype.Component;
import ru.popov.purchaserest.dto.ProductDto;
import ru.popov.purchaserest.models.Product;
@Component
public class ProductMapper {

    public ProductMapper() {
    }

    public Product convertToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
