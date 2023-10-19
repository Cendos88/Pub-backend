package com.pub.services;


import com.pub.models.DrinkOrderSummary;
import com.pub.models.OrderSummary;
import com.pub.models.UserOrderSummary;
import com.pub.repositories.DrinkRepository;
import com.pub.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryService {
    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;

    public List<OrderSummary> getOrderSummary() {
        return orderRepository.getOrderSummary();
    }

    public List<DrinkOrderSummary> getDrinkOrderSummary() {
        return orderRepository.getOrdersForAllDrinks();
    }

    public List<UserOrderSummary> getUserOrderSummary() {
        return orderRepository.getOrdersForAllUsers();
    }

}
