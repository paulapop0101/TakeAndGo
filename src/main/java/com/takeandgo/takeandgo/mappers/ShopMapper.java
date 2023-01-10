package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.AddressDTO;
import com.takeandgo.takeandgo.dtos.ShopDTO;
import com.takeandgo.takeandgo.models.Address;
import com.takeandgo.takeandgo.models.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopMapper {
    @Mappings({
            @Mapping(target = "addressDTO", expression = "java(toDTO(shop.getAddress()))"),
            @Mapping(target = "latitude", expression = "java(Float.valueOf(shop.getLatitude()))"),
            @Mapping(target = "longitude", expression = "java(Float.valueOf(shop.getLongitude()))")
    })
    ShopDTO toDTO(Shop shop);
    @Mappings({
            @Mapping(target = "address", expression = "java(toModel(shopDTO.getAddressDTO()))"),
            @Mapping(target = "latitude", expression = "java(String.valueOf(shopDTO.getLatitude()))"),
            @Mapping(target = "longitude", expression = "java(String.valueOf(shopDTO.getLongitude()))")
    })
    Shop toModel(ShopDTO shopDTO);
    AddressDTO toDTO(Address address);
    Address toModel(AddressDTO addressDTO);
    List<ShopDTO> toDTO(List<Shop> shops);
}
