package com.pub.controllers;

import com.pub.services.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SummaryController {
    private final SummaryService summaryService;
    @GetMapping("/all")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.ok(summaryService.getOrderSummary());
    }
}
