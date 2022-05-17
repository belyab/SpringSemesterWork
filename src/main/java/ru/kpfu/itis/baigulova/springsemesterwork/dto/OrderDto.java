package ru.kpfu.itis.baigulova.springsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private String client_email;
    private String client_phone_number;
    private String client_zodiac_sign;


    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .client_email(order.getClient_email())
                .client_phone_number(order.getClient_phone_number())
                .client_zodiac_sign(order.getClient_phone_number())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
