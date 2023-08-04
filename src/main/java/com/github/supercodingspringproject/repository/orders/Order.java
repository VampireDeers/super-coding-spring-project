package com.github.supercodingspringproject.repository.orders;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import com.github.supercodingspringproject.repository.generalUser.GeneralUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "g_user_id", nullable = false)
    private GeneralUser gUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Sneaker model;

    @Column(name = "sneaker_size", nullable = false)
    private Integer sneakerSize;

    @Column(name = "order_quantity", nullable = false)
    private Integer orderQuantity;

    @Column(name = "shpping_address", nullable = false, length = 30)
    private String shppingAddress;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_status")
    private Byte orderStatus;

    @Column(name = "order_at", nullable = false)
    private Instant orderAt;

}