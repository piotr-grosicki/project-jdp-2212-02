package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/products")
@Service
public class ProductController {

    @GetMapping(value = "{productsId}")
    public ProductDto getProducts(@PathVariable long id){return new ProductDto(1,"kurtka", 321,250);
    }


    @GetMapping
    public List<ProductDto> GetProducts(){
        return new ArrayList<ProductDto>();
    }

    @PostMapping
    public void createProducts(ProductDto productDto){
    }

    @PutMapping
    public ProductDto updateProducts(ProductDto productDto){
        return new ProductDto(1,"kurtka", 1, 250);
    }

    @DeleteMapping(value = "{productsId}")
    public void deleteProducts(@PathVariable long ProductsId){

    }
}
