package com.takeandgo.takeandgo.controllers;


import com.takeandgo.takeandgo.dtos.AddressDTO;
import com.takeandgo.takeandgo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AddressController {
   // get adresses
    private final AddressService addressService;
    @Autowired
    public AddressController(final AddressService addressService){ this.addressService=addressService;}

    @GetMapping("/getAddress")
    public ResponseEntity<List<AddressDTO>> getAllAddresses(){
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }
}
