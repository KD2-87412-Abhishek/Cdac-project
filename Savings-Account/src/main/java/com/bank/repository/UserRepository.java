package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    // You can add custom queries here if needed
}
