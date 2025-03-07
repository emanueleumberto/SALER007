package com.example.GestionePizzeriaJPA.configurations;

import com.example.GestionePizzeriaJPA.models.Cliente;
import com.example.GestionePizzeriaJPA.models.Ordine;
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
