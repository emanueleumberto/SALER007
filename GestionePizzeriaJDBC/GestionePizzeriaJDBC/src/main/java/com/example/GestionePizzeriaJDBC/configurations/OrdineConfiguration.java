package com.example.GestionePizzeriaJDBC.configurations;

import com.example.GestionePizzeriaJDBC.models.Cliente;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Ordine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class OrdineConfiguration {

    @Bean("creaCliente")
    @Scope("prototype")
    public Cliente creaCliente() {
        return new Cliente();
    }

    @Bean("creaOrdine")
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }

}
