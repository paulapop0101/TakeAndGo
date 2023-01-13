package com.takeandgo.takeandgo.dtos;

import com.takeandgo.takeandgo.models.Cart;
import com.takeandgo.takeandgo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {
    private int user_id;
}
