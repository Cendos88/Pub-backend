package com.pub.models;

public interface OrderSummary {

        String getProductName();
        int getAmount();
        int getUnitPrice();
        int getSummaryPrice();

}
