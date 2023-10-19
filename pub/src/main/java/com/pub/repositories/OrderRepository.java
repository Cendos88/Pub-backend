package com.pub.repositories;

import com.pub.models.Order;
import com.pub.models.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT d.productName AS productName, count(o) AS amount, d.price AS unitPrice, SUM( d.price) AS summaryPrice " +
            "FROM Order o " +
            "JOIN User u ON o.userId = u.id " +
            "JOIN Drink d ON o.drinkId = d.id " +
            "GROUP BY d.productName, d.price")
    List<OrderSummary> getOrderSummary();
}

