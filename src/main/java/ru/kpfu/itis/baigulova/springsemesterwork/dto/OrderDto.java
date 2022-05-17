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
    private String clientEmail;
    private String clientPhoneNumber;
    private String clientZodiacSign;


    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .clientEmail(order.getClientEmail())
                .clientPhoneNumber(order.getClientPhoneNumber())
                .clientZodiacSign(order.getClientZodiacSign())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
