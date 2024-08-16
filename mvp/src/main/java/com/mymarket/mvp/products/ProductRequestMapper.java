package com.mymarket.mvp.products;

import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper {

    public Product toProduct(ProductRequestDTO productRequestDTO){
        if(productRequestDTO == null){
            return null;
        }
        Product product = new Product();
        if(productRequestDTO.name() != null){
            product.setName(productRequestDTO.name());
        }
        if(productRequestDTO.description() != null){
            product.setDescription(productRequestDTO.description());
        }
        if(productRequestDTO.price() != null){
            product.setPrice(productRequestDTO.price());
        }
        return product;
    }
}
