package com.takeandgo.takeandgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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

         @ManyToOne
         @JoinColumn(name = "shop_id", referencedColumnName = "id")
         private Shop shop;

        @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
        private List<Item> itemList;

        public Cart(int status, float total, User user, Shop shop){
            this.status = status;
            this.total = total;
            this.user = user;
            this.itemList = new ArrayList<>();
            this.shop = shop;
        }
 }


