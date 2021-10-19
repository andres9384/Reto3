package com.reto4.reto4.repositorio;

import java.util.List;

import com.reto4.reto4.modelo.Computer;
import com.reto4.reto4.repositorio.crud.ComputerCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ComputerRepositorio {
    @Autowired

    private ComputerCrudRepositorio computerCrudRepositorio;

    public List<Computer>obtenerTodo(){
        return (List<Computer>)computerCrudRepositorio.findAll();

    }
  
    public Computer guardar(Computer datos){
        return computerCrudRepositorio.save(datos);
    }
    
}
