package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.CardDTO;
import com.takeandgo.takeandgo.mappers.CardMapper;
import com.takeandgo.takeandgo.models.Card;
import com.takeandgo.takeandgo.repositories.CardRepository;
import com.takeandgo.takeandgo.repositories.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    public final CardRepository cardRepository;
    public final UserRepository userRepository;
    public final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);

    @Autowired
    public CardService(final CardRepository cardRepository, UserRepository userRepository){
        this.cardRepository=cardRepository;
        this.userRepository = userRepository;
    }

    public List<CardDTO> getAllCards(int id){
        List<CardDTO> cards = cardMapper.toDTO(cardRepository.findByUserId(id));
        for(CardDTO card: cards)
            card.setCode(card.getCode().substring(card.getCode().length() - 4));
        return cards;
    }

    public void addCard(final CardDTO cardDTO,final int id){
        Card card = cardMapper.toModel(cardDTO);
        card.setUser(userRepository.findById(id));
        cardRepository.save(card);
    }

    public boolean deleteCard(final int cardId){
        cardRepository.deleteById(cardId);
        return true;
    }
}
