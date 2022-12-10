package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);
}