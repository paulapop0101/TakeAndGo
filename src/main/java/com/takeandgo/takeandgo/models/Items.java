package com.takeandgo.takeandgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private float price;

    private float price_per_entity;

  //  @ManyToOne
    //@JoinColumn(name = "receipt_id", columnDefinition = "id")
   // private Receipt receipt;
   // @ManyToOne
   // @JoinColumn(name = "product_id", columnDefinition = "id")
   // private Product product;

}
