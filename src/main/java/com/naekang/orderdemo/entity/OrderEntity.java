package com.naekang.orderdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "count")
    private int count;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "item_id")
    private Long itemId;

    public void orderItems(LocalDateTime orderDate, OrderStatus orderStatus, int count, Long userId, Long itemId) {

        this.orderDate = orderDate;

        this.orderStatus = orderStatus;

        this.count = count;

        this.userId = userId;

        this.itemId = itemId;

    }

}