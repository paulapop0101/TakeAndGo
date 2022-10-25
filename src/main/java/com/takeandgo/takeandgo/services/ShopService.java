package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.ShopDTO;
import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.mappers.ShopMapper;
import com.takeandgo.takeandgo.models.Shop;
import com.takeandgo.takeandgo.repositories.ShopRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    private final ShopMapper shopMapper = Mappers.getMapper(ShopMapper.class);

    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDTO> getShops(){
        return shopMapper.toDTO(shopRepository.findAll());

    }

    public void addShop(final ShopDTO shopDTO){
//        Shop shop = shopMapper.toModel(shopDTO);
        System.out.println(shopMapper.toModel(shopDTO));
        shopRepository.save(shopMapper.toModel(shopDTO));

    }

}
