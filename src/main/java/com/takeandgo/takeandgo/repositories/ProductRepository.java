package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByBarcodeAndShopId(String barcode, int ShopId);
}
