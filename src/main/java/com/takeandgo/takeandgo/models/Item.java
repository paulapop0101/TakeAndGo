package com.takeandgo.takeandgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private float price;

    private int quantity;

    private float price_per_entity;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    public Item( float price_per_entity,int quantity, Product product, Cart cart){

        this.price=price_per_entity*quantity;
        this.cart=cart;
        this.product=product;
        this.quantity=quantity;
        this.price_per_entity=price_per_entity;
    }


}
