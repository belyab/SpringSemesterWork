package ru.kpfu.itis.baigulova.springsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.baigulova.springsemesterwork.exception.ResourceNotFoundException;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Order;
import ru.kpfu.itis.baigulova.springsemesterwork.repositories.OrderRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String getOrdersPage() {
        return "orders";
    }

}

