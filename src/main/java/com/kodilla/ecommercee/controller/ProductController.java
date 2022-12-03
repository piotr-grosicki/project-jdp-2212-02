package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/products")
@RequiredArgsConstructor
public class ProductController {

    @GetMapping
    public ProductDto GetProducts(){
        return new ProductDto(1,"kurtka", 35,800);
    }

    @GetMapping(value = "{productsId}")
    public ProductDto getProducts(@PathVariable long productsId){
        return new ProductDto(2,"kurtka", 321,250);
    }


    @PostMapping(value = "{productId}")
    public void createProducts(@RequestBody ProductDto productsDto){
    }

    @PutMapping(value = "{productId}")
    public ProductDto updateProducts(@RequestBody ProductDto productsDto){
        return new ProductDto(1,"kurtka", 1, 250);
    }

    @DeleteMapping(value = "{productsId}")
    public void deleteProducts(@PathVariable long productsId){

    }
}
