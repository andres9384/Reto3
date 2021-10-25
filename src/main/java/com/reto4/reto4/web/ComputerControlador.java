package com.reto4.reto4.web;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Computer;
import com.reto4.reto4.servicio.ComputerServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return computerServicio.guardarComputador(datos);
    }

    @GetMapping("/{numId}")
    public Optional<Computer>getComputer(@PathVariable("numId")int id){
        return computerServicio.obtenerComputador(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer update(@RequestBody Computer datos){
        return computerServicio.update(datos);
    }
    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCategoria(@PathVariable("numId")int id){
        return computerServicio.eliminarComputador(id);
    }
}
