package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
