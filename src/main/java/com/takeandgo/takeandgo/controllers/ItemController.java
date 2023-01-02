package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.ItemDTO;
import com.takeandgo.takeandgo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ItemController {
    // add item
    // delete item by id
    // delete all items by id
    // increase item by id
    //NEW
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {this.itemService = itemService;
    }

    @GetMapping("/getItems")
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return new ResponseEntity<>(itemService.getAllItem(), HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public ResponseEntity<Boolean> addItem(@RequestBody final ItemDTO itemDTO){
        itemService.addItem(itemDTO);
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
