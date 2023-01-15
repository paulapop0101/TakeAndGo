package com.takeandgo.takeandgo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int id;

    private float price;
    private int quantity;

    private float price_per_entity;

    private int max_quantity;

    private String name;
}
