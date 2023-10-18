package com.pub.controllers;

import com.pub.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drink-menu")
@RequiredArgsConstructor
public class MenuController {
    private final DrinkService drinkService;

    public ResponseEntity<?> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

}
