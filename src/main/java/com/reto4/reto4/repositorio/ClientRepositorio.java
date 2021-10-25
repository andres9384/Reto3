package com.reto4.reto4.repositorio;
import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Client;
import com.reto4.reto4.repositorio.crud.ClientCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositorio {
    @Autowired

    private ClientCrudRepositorio clientCrudRepositorio;

    public List<Client>obtenerTodo(){
        return (List<Client>)clientCrudRepositorio.findAll();

    }

    public Client guardar(Client datos){
        return clientCrudRepositorio.save(datos);
    }

    public Optional<Client>obtenerCliente(int id){
        return clientCrudRepositorio.findById(id);
    }

    public void  delete(Client dato){
        clientCrudRepositorio.delete(dato);
    }
}
