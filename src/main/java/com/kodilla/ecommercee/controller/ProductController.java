package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/products")
@RequiredArgsConstructor
public class ProductController {

    private ProductDbService productDbService;
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> GetProducts(){
        return ResponseEntity.ok(productMapper.mapToProductDtoList(productDbService.getAllProducts()));
    }

    @GetMapping(value = "{productsId}")
    public ResponseEntity<ProductDto> getProducts(@PathVariable Long productsId) throws  ProductNotFoundException{
        return ResponseEntity.ok(productMapper.mapToProductDto(productDbService.getProduct(productsId).orElseThrow(ProductNotFoundException::new)));
    }


    @PostMapping()
    public ResponseEntity<Void> createProducts(@RequestBody ProductDto productsDto) throws GroupNotFoundException {
        productDbService.saveProduct(productMapper.mapToProduct(productsDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<ProductDto> updateProducts(@RequestBody ProductDto productsDto) throws GroupNotFoundException{
        Product product = productMapper.mapToProduct(productsDto);
        Product savedProduct = productDbService.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
    }

    @DeleteMapping(value = "{productsId}")
    public ResponseEntity<Void> deleteProducts(@PathVariable Long productsId){
        productDbService.deleteProduct(productsId);
        return ResponseEntity.ok().build();
    }
}
