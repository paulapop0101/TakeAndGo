package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.ProductDTO;
import com.takeandgo.takeandgo.mappers.ProductMapper;
import com.takeandgo.takeandgo.models.Product;
import com.takeandgo.takeandgo.repositories.ProductRepository;
import com.takeandgo.takeandgo.repositories.ShopRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final ShopRepository shopRepository;

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Autowired
    public ProductService(ProductRepository productRepository, ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
    }

    public ProductDTO addProduct(final ProductDTO productDTO){
        Product product = productMapper.toModel(productDTO);
        product.setShop(shopRepository.getReferenceById(productDTO.getShopID()));
        productRepository.save(product);
        return productDTO;
    }
    public List<ProductDTO> getProducts(){
        return productMapper.toDTO(productRepository.findAll());
    }
}
