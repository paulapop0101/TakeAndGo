package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.ShopDTO;
import com.takeandgo.takeandgo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/getShops")
    public ResponseEntity<List<ShopDTO>> getShops(){
        return new ResponseEntity<>(shopService.getShops(), HttpStatus.OK);
    }
    @PostMapping("/addShop")
    public ResponseEntity <Boolean> addShop(@RequestBody final ShopDTO shopDTO){
        shopService.addShop(shopDTO);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
