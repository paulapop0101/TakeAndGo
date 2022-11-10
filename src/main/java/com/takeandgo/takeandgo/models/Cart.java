package com.takeandgo.takeandgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
 @Table(name="cart")
 public class Cart{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private int status;

        private float total;

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

        @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
        private List<Item> itemList;
 }


