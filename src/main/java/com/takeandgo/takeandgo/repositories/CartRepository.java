package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUserIdAndStatus(int userID, int status);
}
