package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.ReceiptDTO;
import com.takeandgo.takeandgo.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(final ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/addOrder/{user_id}")
    public ResponseEntity<Integer> addOrder(@PathVariable final int user_id){
        return new ResponseEntity<>( receiptService.addOrder(user_id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable final int id){
        receiptService.deleteOrder(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @GetMapping("/getReceipts/{id}")
    public ResponseEntity<List<ReceiptDTO>> getReceipts(@PathVariable final int id){
        return new ResponseEntity<>(receiptService.getReceipts(id),HttpStatus.OK);
    }
    @GetMapping("/getReceipt/{id}")
    public ResponseEntity<ReceiptDTO> getReceipt(@PathVariable final int id){
        return new ResponseEntity<>(receiptService.getReceipt(id),HttpStatus.OK);
    }
}
