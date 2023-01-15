package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.ReceiptDTO;
import com.takeandgo.takeandgo.mappers.ReceiptMapper;
import com.takeandgo.takeandgo.models.Cart;
import com.takeandgo.takeandgo.models.Item;
import com.takeandgo.takeandgo.models.Product;
import com.takeandgo.takeandgo.models.Receipt;
import com.takeandgo.takeandgo.repositories.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    private  final UserRepository userRepository;

    private final ItemRepository itemRepository;

    private  final ProductRepository productRepository;

    private final CartRepository cartRepository;

    private final ReceiptMapper receiptMapper = Mappers.getMapper(ReceiptMapper.class);


    @Autowired
    public ReceiptService(final ReceiptRepository receiptRepository, final UserRepository userRepository, ItemRepository itemRepository, ProductRepository productRepository, final CartRepository cartRepository) {
        this.receiptRepository = receiptRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public int addOrder(final int userId){
        Receipt receipt = new Receipt();
        receipt.setUser(userRepository.getReferenceById(userId));
        Cart cart =  cartRepository.findByUserIdAndStatus(userId,0);
        cart.setStatus(1);
        cartRepository.save(cart);
        receipt.setTotal(cart.getTotal());
        receipt.setCart(cart);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        receipt.setDate(timestamp);
        receiptRepository.save(receipt);
        return cart.getId();
    }
    public boolean deleteOrder(final int id){
        Cart cart =  cartRepository.findByUserIdAndStatus(id,0);
        Product product;
        for(Item item: cart.getItemList())
        {
            product=item.getProduct();
            product.setQuantity(product.getQuantity() + item.getQuantity());
            productRepository.save(product);
        }
        cartRepository.deleteById(cart.getId());
        return true;
    }

    public List<ReceiptDTO> getReceipts(int userId) {
        return receiptMapper.toDTO(receiptRepository.findReceiptsByUserId(userId));
    }

    public ReceiptDTO getReceipt(final int cart_id){
        return receiptMapper.toDTO(receiptRepository.findReceiptByCart_Id(cart_id));
    }
}
