package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.CartDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartMapper {

    private CartDbService cartDbService;

    public Cart mapToCart(final CartDto cartDto) throws CartNotFoundException {
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setUser(cartDto.getUser());
        return cart;
    }

    public CartDto mapToCartDto(final Cart cart){
        CartDto cartDto = new CartDto(cart.getId(), cart.getTotalPrice(),
                cart.getProductList(), cart.getId(), cart.getUser());
        return cartDto;
    }

    public Cart mapEmptyCart(final Long userId) throws UserNotFoundException {
        return new Cart();
    }
}
