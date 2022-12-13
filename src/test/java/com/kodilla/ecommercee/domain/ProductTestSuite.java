package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    private ProductRepository productRepository;

    private final Product product = new Product();

    @BeforeEach
    public  void prepareTests() {
        product.setProductName("testName");
        product.setPrice(3.31);
        product.setAvailability(true);
    }


    public Product setProduct(Product product){
        product.setProductName("testName2");
        product.setPrice(5.34);
        product.setAvailability(false);

        return product;
    }


    @Test
    void saveProduct(){

        //Given
        //When
        productRepository.save(product);

        //Then
        Assertions.assertEquals(1, productRepository.findAll().size());
        //Clean
        productRepository.deleteAll();
    }

    @Test
    public void testFindProductById() {
        //Given

        //When
        productRepository.save(product);
        Long productId = product.getId();
        Optional<Product> testId = productRepository.findById(productId);
        //Then
        assertEquals(productId, testId.get().getId());

        //clean
        productRepository.deleteAll();
    }

    @Test
    void findAllProduct(){
        //Given
        Product product2 = setProduct(new Product());
        //When
        productRepository.save(product);
        productRepository.save(product2);

        List<Product> productsList = productRepository.findAll();
        //Then
        for (Product product : productRepository.findAll()){
            System.out.println("ID: " + product.getId());
        }
        Assertions.assertEquals(2, productsList.size());
        //Clean
        productRepository.deleteAll();
    }

    @Test
    void deleteByIdProduct(){
        //Given
        Product product2 = setProduct(new Product());
        productRepository.save(product);
        productRepository.save(product2);
        boolean productExistBefore = productRepository.existsById(2L);
        //When
        productRepository.deleteById(2L);
        //Then
        boolean productExistAfter = productRepository.existsById(2L);

        Assertions.assertTrue(productExistBefore);
        Assertions.assertFalse(productExistAfter);
        //Clean
        productRepository.deleteAll();

    }
}
