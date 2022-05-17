package ru.kpfu.itis.baigulova.springsemesterwork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_email")
    private String client_email;

    @Column(name = "client_phone_number")
    private String client_phone_number;

    @Column(name = "client_zodiac_sign")
    private String client_zodiac_sign;


}
