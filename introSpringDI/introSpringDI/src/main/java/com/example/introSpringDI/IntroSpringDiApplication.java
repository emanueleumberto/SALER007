package com.example.introSpringDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroSpringDiApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntroSpringDiApplication.class, args);


		// Accoppiamento Debole -> Loose Coupling
		// I componenti dipendono da interfacce o da classi astratte
		// invece che da classi concrete
		// IOC (Inversion of Control)
		// DI (Dependency Injection)

		// Metodi di pagamento proposti
		//PayPalGatway payPal = new PayPalGatway();
		//PostePayGatway postePay = new PostePayGatway();
		//BonificoGatway bonifico = new BonificoGatway();

		// Ordine effettuato sul sito
		//Order o = new Order(1, List.of("Iphone"), 850.0);

		// Processo di pagamento
		//OrderProcessor op = new OrderProcessor(bonifico);
		//op.orderProcessor(o);


	}

}
