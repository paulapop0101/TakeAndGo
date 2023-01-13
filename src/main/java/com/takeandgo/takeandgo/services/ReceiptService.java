package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.ReceiptDTO;
import com.takeandgo.takeandgo.models.Cart;
import com.takeandgo.takeandgo.models.Receipt;
import com.takeandgo.takeandgo.repositories.CartRepository;
import com.takeandgo.takeandgo.repositories.ReceiptRepository;
import com.takeandgo.takeandgo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    private  final UserRepository userRepository;

    private final CartRepository cartRepository;


    @Autowired
    public ReceiptService(final ReceiptRepository receiptRepository, final UserRepository userRepository, final CartRepository cartRepository) {
        this.receiptRepository = receiptRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public boolean addOrder(final ReceiptDTO receiptDTO){
        Receipt receipt = new Receipt();
        receipt.setUser(userRepository.getReferenceById(receiptDTO.getUser_id()));
        Cart cart =  cartRepository.findByUserIdAndStatus(receiptDTO.getUser_id(),0);
        cart.setStatus(1);
        cartRepository.save(cart);
        receipt.setTotal(cart.getTotal());
        receipt.setCart(cart);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        receipt.setDate(timestamp);
        receiptRepository.save(receipt);
        return true;
    }
}
