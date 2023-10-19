package com.pub.repositories;

import com.pub.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    @Query("SELECT d.productName AS productName, o.userId AS userId, COUNT(o) AS amount, SUM(o.price) AS price " +
            "FROM Order o " +
            "JOIN User u ON o.userId = u.id " +
            "JOIN Drink d ON o.drinkId = d.id " +
            "GROUP BY d.productName, o.userId")
    List<DrinkOrderSummary> getOrdersForAllDrinks();

    @Query("SELECT u.id AS userId, d.productName AS productName, o.price AS price " +
            "FROM Order o " +
            "JOIN User u ON o.userId = u.id " +
            "JOIN Drink d ON o.drinkId = d.id")
    List<UserOrderSummary> getOrdersForAllUsers();

    @Query("SELECT o.id AS id, d.productName AS productName, o.price AS price " +
            "FROM Order o " +
            "JOIN User u ON o.userId = u.id " +
            "JOIN Drink d ON o.drinkId = d.id " +
            "WHERE u.id = :userId")
    List<OrderDTO> getOrdersForUser(@Param("userId") Integer userId);

}


