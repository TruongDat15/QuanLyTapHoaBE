package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    boolean existByUsername(String username);
    Optional<User> findByUsername(String username);

}
