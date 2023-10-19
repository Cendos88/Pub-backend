package com.pub.services;



import com.pub.models.OrderSummary;
import com.pub.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryService {
    private final OrderRepository orderRepository;

    public List<OrderSummary> getOrderSummary() {
        return orderRepository.getOrderSummary();
    }
}
