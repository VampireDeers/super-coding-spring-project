package com.github.supercodingspringproject.web.service;

import com.github.supercodingspringproject.repository.orders.Order;
import com.github.supercodingspringproject.repository.orders.OrderRepository;
import com.github.supercodingspringproject.repository.orders.OrderStatus;
import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import com.github.supercodingspringproject.repository.sneaker.SneakerRepository;
import com.github.supercodingspringproject.repository.user.User;
import com.github.supercodingspringproject.repository.user.UserRepository;
import com.github.supercodingspringproject.service.exceptions.NotAcceptException;
import com.github.supercodingspringproject.service.exceptions.NotFoundException;
import com.github.supercodingspringproject.web.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserOrderWishService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final SneakerRepository sneakerRepository;

    @Transactional(transactionManager = "tmJpa")
    public Double makeOrder(OrderRequest orderRequest) {
        Integer modelId = orderRequest.getModelId();
        Sneaker sneaker = sneakerRepository.findById(modelId).orElseThrow(() -> new NotFoundException("modelId '" + modelId + "' 를 찾을 수 없습니다."));

        String shippingAddress = orderRequest.getShippingAddress();
        Integer userId = orderRequest.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("userId '" + userId + "' 를 찾을 수 없습니다."));

        if ( shippingAddress == null ){
            shippingAddress = Optional.ofNullable(user.getGeneralUsers().getFavortieShoppingAddress()).orElseThrow(() -> new NotAcceptException("배송 지역을 알 수 없습니다."));
        }
        Integer orderQuantity = orderRequest.getOrderQuantity();
        Double totalPrice = sneaker.getPrice() * orderRequest.getOrderQuantity();
        Integer sneakerSize = orderRequest.getSneakerSize();

        Order orderNew = Order.builder()
                    .sneakerSize(sneakerSize)
                    .orderQuantity(orderQuantity)
                    .shppingAddress(shippingAddress)
                    .gUser(user.getGeneralUsers())
                    .totalPrice(totalPrice)
                    .orderStatus(OrderStatus.ORDER_COMPLETED)
                    .orderAt(LocalDateTime.now())
                    .model(sneaker)
                    .build();

        Order orderSaved = orderRepository.save(orderNew);
        return orderSaved.getTotalPrice();
    }
}
