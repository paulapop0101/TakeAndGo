package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.ItemCreateDTO;
import com.takeandgo.takeandgo.dtos.ItemDTO;
import com.takeandgo.takeandgo.dtos.PriceDTO;
import com.takeandgo.takeandgo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(final ItemService itemService) {this.itemService = itemService;
    }

    @GetMapping("/getItems/{id}")
    public ResponseEntity<List<ItemDTO>> getAllItems(@PathVariable final int id){
        return new ResponseEntity<>(itemService.getAllItem(id), HttpStatus.OK);
    }
    @GetMapping("/getPrice/{id}")
    public ResponseEntity<PriceDTO> getPrice(@PathVariable final int id){
        return new ResponseEntity<>(itemService.getPrice(id), HttpStatus.OK);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<Boolean> addItem(@RequestBody final ItemCreateDTO itemCreateDTO){
        System.out.println("here");
        itemService.addItem(itemCreateDTO);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable final int id){
        return new ResponseEntity<>(itemService.deleteItem(id),HttpStatus.OK);
    }

    @PostMapping("increaseItemQuantity/{id}")
    public ResponseEntity<Boolean> increaseItemQuantity(@PathVariable final int id){
        return new ResponseEntity<>(itemService.increaseItemQuantity(id),HttpStatus.OK);
    }







}
