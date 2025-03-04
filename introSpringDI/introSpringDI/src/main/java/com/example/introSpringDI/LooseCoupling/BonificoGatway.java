package com.example.introSpringDI.LooseCoupling;

public class BonificoGatway implements PaymentGatway {
    @Override
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento effettuato tramite bonifico!!");
    }
}
