package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDbService {
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) throws ProductNotFoundException {
        Optional<Product> result = Optional.ofNullable(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
        return result;
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(final Long id) {
        productRepository.deleteById(id);
    }
}
