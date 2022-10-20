package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
