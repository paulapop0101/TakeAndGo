package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.ReceiptDTO;
import com.takeandgo.takeandgo.dtos.UserCreateDTO;
import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(final ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Boolean> addOrder(@RequestBody final ReceiptDTO receiptDTO){
        receiptService.addOrder(receiptDTO);
        return new ResponseEntity<>( true, HttpStatus.OK);
    }
}
