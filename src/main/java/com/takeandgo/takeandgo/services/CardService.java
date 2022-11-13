package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.CardDTO;
import com.takeandgo.takeandgo.mappers.CardMapper;
import com.takeandgo.takeandgo.models.Card;
import com.takeandgo.takeandgo.repositories.CardRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    public final CardRepository cardRepository;

    public final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);

    @Autowired
    public CardService(final CardRepository cardRepository){
        this.cardRepository=cardRepository;
    }

    public List<CardDTO> getAllCards(){
        return cardMapper.toDTO(cardRepository.findAll());
    }

    public void addCard(final Card card){
        cardRepository.save(card);
    }

    public void  deleteCard(final Card card){
        cardRepository.delete(card);
    }
}
