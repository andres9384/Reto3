package com.reto4.reto4.web;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Client;
import com.reto4.reto4.servicio.ClientServicio;

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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientControlador {
    @Autowired
    private ClientServicio clientServicio;
    @GetMapping("/all")
    public List<Client>obtenerTodo(){
        return clientServicio.obtenerTodo();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client guardar(@RequestBody Client datos){
        return clientServicio.guardarCliente(datos);
    }

    @GetMapping("/{numId}")
    public Optional<Client>getComputer(@PathVariable("numId")int id){
        return clientServicio.obtenerCliente(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client datos){
        return clientServicio.update(datos);
    }
    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCategoria(@PathVariable("numId")int id){
        return clientServicio.eliminarCliente(id);
    }
}
