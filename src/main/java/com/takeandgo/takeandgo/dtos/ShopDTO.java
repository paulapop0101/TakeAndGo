package com.takeandgo.takeandgo.dtos;

import com.takeandgo.takeandgo.models.Address;
import com.takeandgo.takeandgo.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
    private String name;
    private AddressDTO addressDTO;
}