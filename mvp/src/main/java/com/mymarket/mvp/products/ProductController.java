package com.mymarket.mvp.products;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.insertProduct(productRequestDTO);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(id, productRequestDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}