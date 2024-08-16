package com.mymarket.mvp.products;

import com.mymarket.mvp.shared.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;

    public ProductService(ProductRepository productRepository, ProductRequestMapper productRequestMapper) {
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id));
    }

    public Product insertProduct(ProductRequestDTO productRequestDTO) {
        Product product = productRequestMapper.toProduct(productRequestDTO);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id));
        existingProduct.setName(productRequestDTO.name());
        existingProduct.setDescription(productRequestDTO.description());
        existingProduct.setPrice(productRequestDTO.price());
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
