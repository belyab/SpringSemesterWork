package ru.kpfu.itis.baigulova.springsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.OrderDto;
import ru.kpfu.itis.baigulova.springsemesterwork.service.OrdersService;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class OrderRestController {

    private final OrdersService ordersService;

    @GetMapping("orders/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @PostMapping(value ="orders/addOrder")
    public ResponseEntity<OrderDto> addOrders(@RequestBody OrderDto orderDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordersService.addOrder(orderDto));
    }

    @DeleteMapping("orders/deleteOrder/{order-id}")
    public void deleteOrder(@PathVariable("order-id") Long id) {
        ordersService.deleteOrder(id);
    }
}
