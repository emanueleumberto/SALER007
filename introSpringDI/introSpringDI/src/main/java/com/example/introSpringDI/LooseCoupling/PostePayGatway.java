package com.example.introSpringDI.LooseCoupling;

public class PostePayGatway implements PaymentGatway {

    @Override
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento effettuato tramite postepay!!");
    }
}
