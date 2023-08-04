package com.github.supercodingspringproject.web.service;

import com.github.supercodingspringproject.repository.generalUser.GeneralUserRepository;
import com.github.supercodingspringproject.repository.orders.Order;
import com.github.supercodingspringproject.repository.orders.OrderRepository;
import com.github.supercodingspringproject.repository.sneaker.SneakerRepository;
import com.github.supercodingspringproject.service.mapper.OrderMapper;
import com.github.supercodingspringproject.web.dto.OrderInfo;
import com.github.supercodingspringproject.web.dto.PayRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserOrderPayService {

    private final GeneralUserRepository generalUserRepository;
    private final SneakerRepository sneakerRepository;
    private final OrderRepository orderRepository;

    public Page<OrderInfo> listOrderInfo(Integer generalUserID, Pageable pageable) {
        Page<Order> orders = orderRepository.findAllByGeneralUserId(generalUserID, pageable);
        return orders.map(OrderMapper.INSTANCE::orderToOrderInfo);
    }

    public Boolean makePay(PayRequest payRequest) {
        Integer generalUserId = payRequest.getGeneralUserId();
        Integer orderId = payRequest.getOrderId();

    }
}
