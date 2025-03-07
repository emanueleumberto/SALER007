package com.example.GestionePizzeriaJPA.servicecs;

import com.example.GestionePizzeriaJPA.models.Cliente;
import com.example.GestionePizzeriaJPA.repositories.ClienteDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired ClienteDAORepository db;
    @Autowired @Qualifier("creaCliente") ObjectProvider<Cliente> clienteObjectProvider;

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = clienteObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public void salvaCliente(Cliente cliente) {
        db.save(cliente);
    }

    public Cliente leggiCliente(long id) {
        return db.findById(id).get();
    }

}
