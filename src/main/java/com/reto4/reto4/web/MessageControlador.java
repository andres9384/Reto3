package com.reto4.reto4.web;

import java.util.List;

import com.reto4.reto4.modelo.Message;
import com.reto4.reto4.servicio.MessageServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageControlador {
    @Autowired
    private MessageServicio messageServicio;
    @GetMapping("/all")
    public List<Message>obtenerTodo(){
        return messageServicio.obtenerTodo();
    }

    @PostMapping("/save")
    // @ResponseStatus(HttpStatus.CREATED)
    public Message guardar(@RequestBody Message datos){
        return messageServicio.guardar(datos);
    }
}
