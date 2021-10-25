package com.reto4.reto4.servicio;

import java.util.List;
import java.util.Optional;

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
   
    // public Computer guardar(Computer datos){
      
    //         return computerRepositorio.guardar(datos);
    // }

    public Optional<Computer>obtenerComputador(int id){
        return computerRepositorio.obtenerComputador(id);
    }

    public Computer guardarComputador(Computer datos){
        if(datos.getId()==null){
            return computerRepositorio.guardar(datos);

        }else{
            Optional<Computer> consulta= computerRepositorio.obtenerComputador(datos.getId());
            if (consulta.isEmpty()) {
                return computerRepositorio.guardar(datos);
            }else{
                return datos;
            }
        }
    }
    public Computer update(Computer datos){
        if(datos.getId()!=null){
            Optional<Computer>consulta= computerRepositorio.obtenerComputador(datos.getId());
            if(!consulta.isEmpty()){
                if (datos.getName()!=null) {
                    consulta.get().setName(datos.getName());   
                }if(datos.getBrand()!=null){
                    consulta.get().setBrand(datos.getBrand());
                }if (datos.getYear()!=null) {
                    consulta.get().setYear(datos.getYear());   
                }if(datos.getDescription()!=null){
                    consulta.get().setDescription(datos.getDescription());
                }
                return computerRepositorio.guardar(consulta.get());
            }
        }return datos;
    }
    public boolean eliminarComputador(int id){
        Optional<Computer>consulta = computerRepositorio.obtenerComputador(id);
        if(!consulta.isEmpty()){
            computerRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

}
