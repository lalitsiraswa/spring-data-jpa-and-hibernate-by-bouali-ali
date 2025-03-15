package com.learn.spring_boot_jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_tbl")
public class Order {
    @EmbeddedId
    private OrderId orderId;
    private String orderInfo;
    private String transactionInfo;
    @Embedded
    private Address address;
}
