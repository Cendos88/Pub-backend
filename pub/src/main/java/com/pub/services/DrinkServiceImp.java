package com.pub.services;

import com.pub.models.Drink;
import com.pub.repositories.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DrinkServiceImp implements DrinkService{
    private final DrinkRepository drinkRepository;
    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
}
