package com.pub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    Integer userId;
    Long drinkId;
    int price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
