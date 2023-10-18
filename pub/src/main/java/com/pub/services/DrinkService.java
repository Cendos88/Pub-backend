package com.pub.services;

import com.pub.models.Drink;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DrinkService {
    List<Drink> getAllDrinks();
}
