package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.ItemCreateDTO;
import com.takeandgo.takeandgo.dtos.ItemDTO;
import com.takeandgo.takeandgo.models.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {
    @Mappings({
            @Mapping(target = "name", expression = "java(item.getProduct().getName())")
    })
    ItemDTO toDTO(Item item);
    List<ItemDTO> toDTO(List<Item> items);
}
