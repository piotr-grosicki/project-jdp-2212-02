package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderDbService orderDbService;

    public Cart getCart(final Long cartId) throws CartNotFoundException {
        return cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
    }
    public List<Cart> getCards(){
        return cartRepository.findAll();
    }
    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);
    }
    public Cart addProductToCart(final Long productId, final Long cartId) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        if(product.isAbailability()) {
            cart.getProductList().add(product);
            cartRepository.save(cart);
            return cart;
        } else throw new ProductNotFoundException();
    }
    public Cart deleteProductFromCart(final Long productId, final Long cartId) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        List<Product> temporaryProductList = cart.getProductList();
        Product foundProduct = temporaryProductList.stream().filter(a -> a.getProductId().equals(productId)).findAny().orElseThrow(ProductNotFoundException::new);
        cart.getProductList().remove(foundProduct);
        return cart;
    }
    public Order createOrderFromCart(final long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        Order order = new Order(cart.getId(), LocalDate.now(), true, cart.getUser(), cart.getProductList());
        orderDbService.createOrder(order);
        return order;
    }
}
