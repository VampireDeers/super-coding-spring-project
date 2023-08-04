package com.github.supercodingspringproject.repository.wish;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import com.github.supercodingspringproject.repository.generalUser.GeneralUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "wish")
public class Wish {
    @Id
    @Column(name = "wish_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "g_user_id", nullable = false)
    private GeneralUser gUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Sneaker model;

    @Column(name = "sneaker_size")
    private Integer sneakerSize;

    @Column(name = "expected_replenisment_date")
    private Instant expectedReplenismentDate;

    @Column(name = "wish_at", nullable = false)
    private Instant wishAt;

}