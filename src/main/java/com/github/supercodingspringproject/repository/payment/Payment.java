package com.github.supercodingspringproject.repository.payment;

import com.github.supercodingspringproject.repository.generalUser.GeneralUser;
import com.github.supercodingspringproject.repository.orders.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "g_user_id", nullable = false)
    private GeneralUser gUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "type", nullable = false)
    private Byte type;

    @Column(name = "payment_at", nullable = false)
    private Instant paymentAt;

}