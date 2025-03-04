package com.example.introSpringDI.LooseCoupling;

import java.util.List;

public class OrderProcessor {

    //private PayPalGatway paymentGatway = new PayPalGatway(); // Accoppiamento Stretto
    // Dependency Injection su proprietà se public
    private PaymentGatway paymentGatway; // Accoppiamento debole

    // Dependency Injection su Costruttore
    public OrderProcessor(PaymentGatway paymentGatway) {
        this.paymentGatway = paymentGatway;
    }

    // Dependency Injection su Setter
    public void setPaymentGatway(PaymentGatway paymentGatway) {
        this.paymentGatway = paymentGatway;
    }

    public void orderProcessor(Order order) {
        paymentGatway.processPayment(order.getTotalOrder());
    }

}
