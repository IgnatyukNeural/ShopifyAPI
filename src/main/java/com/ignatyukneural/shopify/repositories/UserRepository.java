package com.ignatyukneural.shopify.repositories;

import com.ignatyukneural.shopify.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
