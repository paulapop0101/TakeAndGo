package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.ProductDTO;
import com.takeandgo.takeandgo.dtos.ReceiptDTO;
import com.takeandgo.takeandgo.models.Product;
import com.takeandgo.takeandgo.models.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceiptMapper {
    @Mappings({
            @Mapping(target = "cart_id", expression = "java(receipt.getCart().getId())"),
            @Mapping(target = "date",dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target = "shopName", expression = "java(receipt.getCart().getShop().getName())")
    })
    ReceiptDTO toDTO(Receipt receipt);

    List<ReceiptDTO> toDTO(List<Receipt> receipts);
}
