package com.reto4.reto4.repositorio;

import java.util.List;

import com.reto4.reto4.modelo.Message;
import com.reto4.reto4.repositorio.crud.MessageCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositorio {
    @Autowired
    private MessageCrudRepositorio messageCrudRepositorio;

    public List<Message>obtenerTodo(){
        return (List<Message>)messageCrudRepositorio.findAll();

    }

    public Message guardar(Message datos){
        return messageCrudRepositorio.save(datos);
    }
}
