package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.ItemCreateDTO;
import com.takeandgo.takeandgo.dtos.ItemDTO;
import com.takeandgo.takeandgo.dtos.PriceDTO;
import com.takeandgo.takeandgo.exceptions.EntityException;
import com.takeandgo.takeandgo.mappers.ItemMapper;
import com.takeandgo.takeandgo.models.Cart;
import com.takeandgo.takeandgo.models.Item;
import com.takeandgo.takeandgo.models.Product;
import com.takeandgo.takeandgo.repositories.CartRepository;
import com.takeandgo.takeandgo.repositories.ItemRepository;
import com.takeandgo.takeandgo.repositories.ProductRepository;
import com.takeandgo.takeandgo.repositories.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @Autowired
    public ItemService(ItemRepository itemRepository, final CartRepository cartRepository, final UserRepository userRepository, final ProductRepository productRepository){
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<ItemDTO> getAllItem(int id) {
        Cart cart = cartRepository.findByUserIdAndStatus(id,0);
        if(cart==null)
            return new ArrayList<>();
        List<Item> items = itemRepository.findByCartId(cart.getId());
        return itemMapper.toDTO(items);
        }

    public void addItem(final ItemCreateDTO itemCreateDTO){
        Product product = productRepository.findByBarcodeAndShopId(itemCreateDTO.getBarcode(),itemCreateDTO.getShopID());
        if(product==null)
            throw new EntityException("no such product");

        Cart cart = cartRepository.findByUserIdAndStatus(itemCreateDTO.getUserID(),0);
        float price = product.getPrice();
        if(cart==null){
            cart = new Cart(0,price,userRepository.getReferenceById(itemCreateDTO.getUserID()));
            cartRepository.save(cart);
            cart = cartRepository.findByUserIdAndStatus(itemCreateDTO.getUserID(),0);
            Item item = new Item(price,product,cart);
            itemRepository.save(item);

        }
        else{
            if(itemNotInCart(cart.getItemList(),product.getId())) {
                cart.setTotal(cart.getTotal() + price);
                cartRepository.save(cart);
                cart = cartRepository.findByUserIdAndStatus(itemCreateDTO.getUserID(), 0);

                Item item = new Item(price, product, cart);
                itemRepository.save(item);
            }
            else{
                throw new EntityException("product already in cart");
            }
        }
    }

    private boolean itemNotInCart(final List<Item> itemList, int id) {
        for(Item item: itemList)
            if(item.getProduct().getId()==id)
                return false;
        return true;
    }

    public boolean deleteItem(final int itemId){
        Item item = itemRepository.getReferenceById(itemId);
        Cart cart = cartRepository.getReferenceById(item.getCart().getId());
        cart.setTotal(cart.getTotal()-item.getPrice());
        cartRepository.save(cart);
        itemRepository.deleteById(itemId);
        return true;
    }
//    public Item findByProduct(int productID){
//        List<Item> items= itemRepository.findAll();
//        for(Item item : items)
//                for(Barcode barcode : item.getBarcodes())
//                    if(barcode.getProduct().getId()==productID)
//                        return item;
//         return null;
//
//
//    }
    public boolean increaseItemQuantity(final int id){
        //to do
        return true;
    }

    public PriceDTO getPrice(final int id) {
        Cart cart = cartRepository.findByUserIdAndStatus(id,0);
        if(cart==null)
            return  null;
        List<Item> items = itemRepository.findByCartId(cart.getId());
        int total=0;
        for(Item item : items)
            total+=item.getPrice();
        return new PriceDTO(total);
    }
}
