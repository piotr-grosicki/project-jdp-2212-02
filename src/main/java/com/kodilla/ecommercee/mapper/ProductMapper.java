package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private GroupService groupService;

    public Product mapToProduct(final ProductDto productDto) throws GroupNotFoundException {;
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.isAvailability(),
                groupService.getGroupById(productDto.getId_group()));
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(product.getProductId(), product.getProductName(),
                product.getGroup().getId(), product.getPrice(), product.isAvailability());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream().map(this::mapToProductDto).collect(Collectors.toList());
    }
}
