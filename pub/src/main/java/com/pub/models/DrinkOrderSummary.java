package com.pub.models;

public interface DrinkOrderSummary {

    String getProductName();

    Integer getUserId();

    int getAmount();

    int getPrice();

    interface UserOrderSummary {
        Integer getUserId();
        String getProductName();
        int getPrice();
    }
}
