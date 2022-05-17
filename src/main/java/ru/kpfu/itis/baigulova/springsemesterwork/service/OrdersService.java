package ru.kpfu.itis.baigulova.springsemesterwork.service;

import ru.kpfu.itis.baigulova.springsemesterwork.dto.OrderDto;

import java.util.List;

public interface OrdersService {
    List<OrderDto> getAllOrders();
    OrderDto addOrder(OrderDto orderDto);
    void deleteOrder(Long id);
}
