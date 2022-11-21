package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.CardDTO;
import com.takeandgo.takeandgo.models.Card;
import com.takeandgo.takeandgo.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CardController {
    // add card to user
    // delete card
    // get cards by user
    private final CardService cardService;

    @Autowired
    public CardController(final CardService cardService){ this.cardService=cardService;}

    @GetMapping("/getCards")
    public ResponseEntity<List<CardDTO>> getAllCards(){
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }

    @PostMapping("/addCard")
    public ResponseEntity<Boolean> addCard(@RequestBody final CardDTO cardDTO){
        cardService.addCard(cardDTO);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<Boolean> deleteCard(@PathVariable final int id){
        return new ResponseEntity<>(cardService.deleteCard(id),HttpStatus.OK);
    }




}
