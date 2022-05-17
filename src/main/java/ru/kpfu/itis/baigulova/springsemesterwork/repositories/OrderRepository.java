package ru.kpfu.itis.baigulova.springsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {
}
