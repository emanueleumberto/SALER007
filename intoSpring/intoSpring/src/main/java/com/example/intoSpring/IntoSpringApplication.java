package com.example.intoSpring;

import com.example.intoSpring.classes.User;
import com.example.intoSpring.component.UserComponent;
import com.example.intoSpring.configurations.ConfigurationUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IntoSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntoSpringApplication.class, args);

		// Per creare istanze in un Application Context di Spring posso utilizzare:
		// Dichiarazione XML -> Si possono configurare i beans utilizzando un file XML di configurazione.
		// Classe Configurazione -> Si possono configurare i beans utilizzando delle classi
		// 							con un Annotazione @Configuration
		// Annotazioni -> Si possono configurare i beans utilizzando direttamente annotazione nelle classi Java


		//User u = new User("Mario", "Rossi", "Roma", 45, "m.rossi@example.com");
		//User u = new User();
		//u.setName("Mario") .... u.setEmail("m.rossi@example.com")

		// Metodo 1 -> Dichiarazione XML
		// Configurazione tramite configuration_beans.xml
		// configWith_XML();

		// Metodo 2 -> Classe Configurazione
		// Configurazione tramite classe @Configuration
		configWith_Configuration();

		// Metodo 3 -> Annotazioni sulla classe
		// Configurazione tramite @Component
		// configWith_Component();

		// Scope
		// -> Singleton
		// -> Prototype
		// -> Request -> per Web Application
		// -> Session -> per Web Application
		// -> Application -> per Web Application
		// -> Websocket -> per Web Application

	}

	public static void configWith_XML() {
		// Creo un Application Context dove utilizzare i beans sulla base del file di
		// configurazione configuration_beans.xml creato
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("configuration_beans.xml");

		// Creazione di un bean tramite il costruttore
		User userXml = (User) appContext.getBean("beanUser");
		System.out.println(userXml);

		// Creazione di un bean tramite i setter delle proprietà
		User userXmlSet = (User) appContext.getBean("beanUserSetter");
		System.out.println(userXmlSet);

		// Chiudo il Application Context
		appContext.close();
	}

	public static void configWith_Configuration() {
		// Creo un Application Context dove utilizzare i beans sulla base della classe di
		// configurazione annotata con @Configuration
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationUser.class);

		User userDefault = (User) appContext.getBean("userDefault");
		System.out.println(userDefault);

		User userCustom = (User) appContext.getBean("customUser", "Giuseppe", "Verdi", "Milano", 22, "g.verdi@example.com");
		System.out.println(userCustom);

		User userAdmin = (User) appContext.getBean("adminUser");
		System.out.println(userAdmin);

		// Chiudo il Application Context
		appContext.close();
	}

	public static void configWith_Component() {
		// Creo un Application Context dove utilizzare i beans sulla base della classe di
		// configurazione annotata con @Configuration
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();

		appContext.scan("com.example.intoSpring.component");
		appContext.refresh();

		UserComponent user = (UserComponent) appContext.getBean("user_component");
		user.setName("Mario");
		user.setLastname("Rossi");
		user.setCity("Roma");
		user.setAge(45);
		user.setEmail("m.rossi@example.com");
		System.out.println(user);

		UserComponent userConstr = (UserComponent) appContext.getBean("user_component", "Giuseppe", "Verdi", "Milano", 22, "g.verdi@example.com");
		System.out.println(userConstr);

		// Chiudo il Application Context
		appContext.close();
	}
}
