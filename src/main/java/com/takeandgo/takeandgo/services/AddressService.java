package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.AddressDTO;
import com.takeandgo.takeandgo.mappers.AddressMapper;
import com.takeandgo.takeandgo.repositories.AddressRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Autowired
    public AddressService(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }
    public List<AddressDTO> getAllAddres(){
        return  addressMapper.toDTO(addressRepository.findAll());
    }
}
