package com.takeandgo.takeandgo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
    private int id;
    private String code;

    private int month;

    private int year;
}
