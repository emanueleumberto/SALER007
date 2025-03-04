package com.example.introSpringDI.LooseCoupling;

public class PayPalGatway implements PaymentGatway {

    @Override
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento effettuato tramite paypal!!");
    }

}
