package controller;

import domain.ProductsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/products")
@Service
@AllArgsConstructor

public class ProductController {

    @GetMapping(value = "{productsId}")
    public ProductsDto getProducts(@PathVariable long id){
        return new ProductsDto(1, "kurtka zimowa", 250, 12);
    }

    @GetMapping
    public List<ProductsDto> GetProducts(){
        return new ArrayList<ProductsDto>();
    }

    @PostMapping
    public void createProducts(ProductsDto productsDto){
    }

    @PutMapping
    public ProductsDto updateProducts(ProductsDto productsDto){
        return new ProductsDto(1,"kurtka", 250, 1);
    }

    @DeleteMapping(value = "{productsId}")
    public void deleteProducts(@PathVariable long productsId){

    }
}
