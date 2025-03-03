package com.example.GestionPizzeria;

import com.example.GestionPizzeria.configuration.PizzeriaConfig;
import com.example.GestionPizzeria.model.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GestionPizzeriaApplication {

	public static void main(String[] args) {

		SpringApplication.run(GestionPizzeriaApplication.class, args);

		stampaMenu();
	}

	public static void stampaMenu() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PizzeriaConfig.class);

		Menu menu = (Menu) appContext.getBean("creaMenu");
		//System.out.println(menu);
		System.out.println("************* Menu Pizzeria " + menu.getNome() +" **************");
		System.out.println("----- Pizze -----");
		// 1. nomePizza (ingrediente1, ingrediente2, ...., ingredietnteN) 0.00
		menu.getListaPizze().forEach(p -> {
			System.out.println(
					(menu.getListaPizze().indexOf(p) + 1) + ". "
							+ p.getNome() + " "
							+ p.getIngredienti().toString()
							+ "  Prezzo: €" + p.getPrezzo());
		});
		System.out.println("----- Drink -----");
		menu.getListaDrink().forEach(d -> {
			System.out.println(
					(menu.getListaDrink().indexOf(d) + 1) + ". "
							+ d.getNome() + " "
							+ d.getGradi() + "° Prezzo: €"
							+ d.getPrezzo()
			);
		});


		appContext.close();
	}

}
