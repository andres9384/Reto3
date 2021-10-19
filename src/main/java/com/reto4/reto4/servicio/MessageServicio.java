package com.reto4.reto4.servicio;

import java.util.List;

import com.reto4.reto4.modelo.Message;
import com.reto4.reto4.repositorio.MessageRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepositorio;
    public List<Message>obtenerTodo(){
        return messageRepositorio.obtenerTodo();
    }

    public Message guardar(Message datos){
            return messageRepositorio.guardar(datos);
    }
}
