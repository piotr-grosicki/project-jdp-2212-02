package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("shop/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartDbService cartDbService;
    private final CartMapper cartMapper;
    private final ProductDbService productDbService;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    @PutMapping("addProduct/{cartId}/{productId}")
    public ResponseEntity<CartDto> addProductToCard(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(cartMapper.mapToCartDto(cartDbService.addProductToCart(productId,cartId)));
    }

    @GetMapping(value = "/{cartId}")
    public ResponseEntity<List<ProductDto>> getProductsFromCart(@PathVariable long cartId) throws CartNotFoundException {
        List<Product> products = productDbService.getAllProducts();
        cartDbService.getCart(cartId).setProductList(products);
        return ResponseEntity.ok(productMapper.mapToProductDtoList(products));
    }

    @DeleteMapping(value = "{cartId}")
    public ResponseEntity<CartDto> deleteSingleProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(cartMapper.mapToCartDto(cartDbService.deleteProductFromCart(productId, cartId)));
    }

    @PostMapping(value = "/emptyCard/{userId}")
    public ResponseEntity<String> createEmptyCart(@PathVariable Long userId) throws UserNotFoundException {
        cartDbService.saveCart(cartMapper.emptyCartMap(userId));
        return ResponseEntity.ok("Card created for User: " + userId);
    }

    @PostMapping(value = "/makeOrder/{cartId}")
    public ResponseEntity<OrderDto> createOrderFromCart(@PathVariable Long cartId) throws CartNotFoundException{
        Order order = cartDbService.createOrderFromCart(cartId);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(order));
    }
}

