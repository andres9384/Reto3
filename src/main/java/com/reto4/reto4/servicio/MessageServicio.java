package com.reto4.reto4.servicio;

import java.util.List;
import java.util.Optional;

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

    // public Message guardar(Message datos){
    //         return messageRepositorio.guardar(datos);
    // }

    public Optional<Message>obtenerMensaje(int id){
        return messageRepositorio.obtenerMensage(id);
    }

    public Message guardarMensaje(Message datos){
        if(datos.getIdMessage()==null){
            return messageRepositorio.guardar(datos);

        }else{
            Optional<Message> consulta= messageRepositorio.obtenerMensage(datos.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepositorio.guardar(datos);
            }else{
                return datos;
            }
        }
    }
    public Message update(Message datos){
        if(datos.getIdMessage()!=null){
            Optional<Message>consulta= messageRepositorio.obtenerMensage(datos.getIdMessage());
            if(!consulta.isEmpty()){
                if (datos.getMessageText()!=null) {
                    consulta.get().setMessageText(datos.getMessageText());   
                }
                return messageRepositorio.guardar(consulta.get());
            }
        }return datos;
    }
    public boolean eliminarMensaje(int id){
        Optional<Message>consulta = messageRepositorio.obtenerMensage(id);
        if(!consulta.isEmpty()){
            messageRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }
}
