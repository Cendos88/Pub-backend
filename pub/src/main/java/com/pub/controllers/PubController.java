package com.pub.controllers;

import com.pub.services.PubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequiredArgsConstructor
public class PubController {
    private final PubService pubService;
    @RequestMapping("/drink-menu")
    public ResponseEntity<?> getAllDrinks() {
        return ResponseEntity.ok(pubService.getAllDrinks());
    }

}
