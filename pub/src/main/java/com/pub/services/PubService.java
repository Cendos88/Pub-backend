package com.pub.services;

import com.pub.models.Drink;
import com.pub.models.Order;
import com.pub.models.PubException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PubService {
    List<Drink> getAllDrinks();

    int buyDrink(Order order) throws PubException;

}
