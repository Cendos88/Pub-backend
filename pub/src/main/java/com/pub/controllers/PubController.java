package com.pub.controllers;

import com.pub.models.Order;
import com.pub.models.PubException;
import com.pub.services.PubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequiredArgsConstructor
public class PubController {
    private final PubService pubService;

    @RequestMapping("/drink-menu")
    public ResponseEntity<?> getAllDrinks() {
        return ResponseEntity.ok(pubService.getAllDrinks());
    }

    @PostMapping("buy")
    public ResponseEntity<?> buyDrink(@RequestBody Order order) {
        try {
            return ResponseEntity.ok(pubService.buyDrink(order));
        } catch (PubException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
