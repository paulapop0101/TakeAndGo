package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.CardDTO;
import com.takeandgo.takeandgo.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {
    CardDTO toDTO(Card card);
    Card toModel(CardDTO cardDTO);
    List<CardDTO> toDTO(List<Card> cards);
}
