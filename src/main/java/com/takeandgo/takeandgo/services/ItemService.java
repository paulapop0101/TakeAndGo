package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.ItemDTO;
import com.takeandgo.takeandgo.mappers.ItemMapper;
import com.takeandgo.takeandgo.models.Item;
import com.takeandgo.takeandgo.repositories.ItemRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemService {
    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<ItemDTO> getAllItem() { return itemMapper.toDTO(itemRepository.findAll());}

    public void addItem(final ItemDTO itemDTO){
        Item item = itemMapper.toModel(itemDTO);
        // to do

    }
    public boolean deleteItem(final int itemId){
        itemRepository.deleteById(itemId);
        return true;
    }

    public boolean increaseItemQuantity(final int id){
        //to do
        return true;
    }
}
