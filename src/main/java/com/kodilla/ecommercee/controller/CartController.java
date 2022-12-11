package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
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

    @PutMapping("addProduct/{cartId}/{productId}")
    public ResponseEntity<CartDto> addProductToCard(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(cartMapper.mapToCartDto(cartDbService.addProductToCart(productId,cartId)));
    }

    @GetMapping(value = "{cartId}")
    public List<Product> getProductsFromCart(@PathVariable long cartId) throws CartNotFoundException {
        List<Product> products = productDbService.getAllProducts();
        cartDbService.getCard(cartId).setProductList(products);
        return products;
    }

    @DeleteMapping(value = "{cartId}")
    public ResponseEntity<CartDto> deleteSingleProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(cartMapper.mapToCartDto(cartDbService.deleteProductFromCart(productId, cartId)));
    }

    @PostMapping(value = "/emptyCard/{userId}")
    public ResponseEntity<Void> createEmptyCart(@PathVariable Long userId) throws UserNotFoundException {
        cartDbService.saveCart(cartMapper.mapEmptyCart(userId));
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/order/{cartId}")
    public void createOrderFromCart(@PathVariable Long cartId) throws CartNotFoundException, ProductNotFoundException{ //DO ZAKTUALIZOWANIA GDY BEDE MIAL ORDERMAPPER
        //Order newOrder = cartDbService.getCard(cartId).getOrder();
        Order order = cartDbService.createOrderFromCart(cartId);
        //return ResponseEntity.ok(orderMapper.mapToOrderDto(order));
    }
}

