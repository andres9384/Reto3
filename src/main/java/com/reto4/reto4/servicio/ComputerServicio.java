package com.reto4.reto4.servicio;

import java.util.List;

import com.reto4.reto4.modelo.Computer;
import com.reto4.reto4.repositorio.ComputerRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerServicio {
    @Autowired
    private ComputerRepositorio computerRepositorio;
    public List<Computer>obtenerTodo(){
        return computerRepositorio.obtenerTodo();
    }
   
    public Computer guardar(Computer datos){
      
            return computerRepositorio.guardar(datos);
    
        
    }
}
