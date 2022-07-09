package com.woyo.toko.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_transaction")
@Getter
@Setter
@NoArgsConstructor
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private int price;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "shipping_address", columnDefinition = "TEXT")
    private String shippingAddress;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
