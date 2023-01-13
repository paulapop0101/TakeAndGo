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
        return cardMapper.toDTO(cardRepository.findByUserId(id));
    }

    public void addCard(final CardDTO cardDTO){
        Card card = cardMapper.toModel(cardDTO);
        card.setUser(userRepository.getReferenceById(cardDTO.getUser_id()));
        cardRepository.save(card);
    }

    public boolean deleteCard(final int cardId){
        cardRepository.deleteById(cardId);
        return true;
    }
}
