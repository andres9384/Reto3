package com.reto4.reto4.servicio;

import java.util.List;


import com.reto4.reto4.modelo.Client;
import com.reto4.reto4.repositorio.ClientRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio;
    public List<Client>obtenerTodo(){
        return clientRepositorio.obtenerTodo();
    }

    public Client guardar(Client datos){
            return clientRepositorio.guardar(datos);
    }
}
