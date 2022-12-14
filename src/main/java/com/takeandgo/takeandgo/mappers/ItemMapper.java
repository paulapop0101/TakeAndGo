package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.ItemDTO;
import com.takeandgo.takeandgo.models.Item;

import java.util.List;

public interface ItemMapper {
    ItemDTO toDTO(Item item);
    Item toModel(ItemDTO itemDTO);
    List<ItemDTO> toDTO(List<Item> items);
}
