package com.bank.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // Define the database table name
@Data // Lombok annotation for getters, setters, etc.
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username; // Unique username for authentication

    @Column(nullable = false)
    private String password; // Encrypted password for security

    @Column(nullable = false)
    private String role; // Role-based access control (e.g., ADMIN, USER)
}
