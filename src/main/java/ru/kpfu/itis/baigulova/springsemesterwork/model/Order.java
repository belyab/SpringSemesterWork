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
    private String clientEmail;

    @Column(name = "client_phoneNumber")
    private String clientPhoneNumber;

    @Column(name = "client_zodiacSign")
    private String clientZodiacSign;


}
