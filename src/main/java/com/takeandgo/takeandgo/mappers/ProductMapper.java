package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.ProductDTO;
import com.takeandgo.takeandgo.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "shopID", expression = "java(product.getShop().getId())")
    })
    ProductDTO toDTO(Product product);

    Product toModel(ProductDTO productDTO);

    List<ProductDTO> toDTO(List<Product> products);
}
