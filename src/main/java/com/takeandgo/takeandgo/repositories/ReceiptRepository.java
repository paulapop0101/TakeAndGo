package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt,Integer> {

    List<Receipt> findReceiptsByUserId(int userId);

    Receipt findReceiptByCart_Id(int cartId);
}
