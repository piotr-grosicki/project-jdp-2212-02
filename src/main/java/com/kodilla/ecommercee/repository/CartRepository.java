package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Product, Long> {
}