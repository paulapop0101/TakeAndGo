package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    Item findByProductId(int productId);
    List<Item> findByCartId(int cartId);
}
