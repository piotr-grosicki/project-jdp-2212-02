package com.kodilla.ecommercee.repository;

<<<<<<< HEAD
import com.kodilla.ecommercee.entity.Product;
=======
import com.kodilla.ecommercee.entity.Cart;
>>>>>>> origin/JDP221202-1_
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long cartId);

    @Override
    Cart save(Cart cart);

    @Override
    void deleteById(Long cartId);
}
