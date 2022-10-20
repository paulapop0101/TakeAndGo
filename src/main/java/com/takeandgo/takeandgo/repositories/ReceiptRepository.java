package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Integer> {
}
