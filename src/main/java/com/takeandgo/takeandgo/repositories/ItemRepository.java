package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
