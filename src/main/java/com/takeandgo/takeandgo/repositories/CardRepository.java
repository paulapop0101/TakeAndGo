package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Integer> {
    List<Card> findByUserId(int userId);

    Card findCardByCode(String code);
}
