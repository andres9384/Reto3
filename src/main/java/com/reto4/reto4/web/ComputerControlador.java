package com.reto4.reto4.web;

import java.util.List;

import com.reto4.reto4.modelo.Computer;
import com.reto4.reto4.servicio.ComputerServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ComputerControlador {
    @Autowired
    private ComputerServicio computerServicio;
    @GetMapping("/all")
    public List<Computer>obtenerTodo(){
        return computerServicio.obtenerTodo();
    }

    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer guardar(@RequestBody Computer datos){
        return computerServicio.guardar(datos);
    }
}
