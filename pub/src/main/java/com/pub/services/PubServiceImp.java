package com.pub.services;

import com.pub.models.Drink;
import com.pub.models.Order;
import com.pub.models.PubException;
import com.pub.models.User;
import com.pub.repositories.DrinkRepository;
import com.pub.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PubServiceImp implements PubService {
    private final DrinkRepository drinkRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public int buyDrink(Order order) throws PubException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getPocket() <= order.getPrice()) {
            throw new PubException("Not enough money");
        }
        if (!user.isAdult() && drinkRepository.findById(order.getDrinkId()).get().isForAdult()) {
            throw new PubException("You are not adult");
        }
        orderRepository.save(order);
        return user.getPocket() - order.getPrice();

    }
}
