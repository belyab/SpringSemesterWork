package ru.kpfu.itis.baigulova.springsemesterwork.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.OrderDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Order;
import ru.kpfu.itis.baigulova.springsemesterwork.repositories.OrderRepository;
import ru.kpfu.itis.baigulova.springsemesterwork.service.OrdersService;
import static ru.kpfu.itis.baigulova.springsemesterwork.dto.OrderDto.from;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return from(orderRepository.findAll());
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        return from(orderRepository.save(
                Order.builder()
                        .client_email(orderDto.getClient_email())
                        .client_phone_number(orderDto.getClient_phone_number())
                        .client_zodiac_sign(orderDto.getClient_zodiac_sign())
                        .build()));
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.getById(id);
        orderRepository.delete(order);
    }
}
