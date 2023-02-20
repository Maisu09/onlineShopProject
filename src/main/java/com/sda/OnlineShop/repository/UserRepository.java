package com.sda.OnlineShop.repository;

import com.sda.OnlineShop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
