package com.github.supercodingspringproject.repository.orders;

import com.github.supercodingspringproject.repository.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}