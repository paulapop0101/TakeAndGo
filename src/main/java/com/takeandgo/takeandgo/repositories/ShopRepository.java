package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
