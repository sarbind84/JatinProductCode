// src/main/java/com/example/demo/controller/ProductController.java
package com.ecommerce.end.controllers;

import com.ecommerce.end.models.Product;
import com.ecommerce.end.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.findById(id)
                .map(product -> {
                    product.setName(productDetails.getName());
                    product.setBrand(productDetails.getBrand());
                    product.setPrice(productDetails.getPrice());
                    product.setColors(productDetails.getColors());
                    product.setImage(productDetails.getImage());
                    product.setDescription(productDetails.getDescription());
                    product.setCategory(productDetails.getCategory());
                    product.setFeatured(productDetails.isFeatured());
                    product.setSlider(productDetails.isSlider());
                    product.setShipping(productDetails.isShipping());
                    product.setStock(productDetails.getStock());
                    product.setReview(productDetails.getReview());
                    product.setStars(productDetails.getStars());
                    return ResponseEntity.ok(productService.save(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productService.findById(id)
                .map(product -> {
                    productService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
