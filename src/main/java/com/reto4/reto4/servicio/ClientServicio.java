package com.reto4.reto4.servicio;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Client;
import com.reto4.reto4.repositorio.ClientRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio;
    public List<Client>obtenerTodo(){
        return clientRepositorio.obtenerTodo();
    }

    // public Client guardar(Client datos){
    //         return clientRepositorio.guardar(datos);
    // }

    public Optional<Client>obtenerCliente(int id){
        return clientRepositorio.obtenerCliente(id);
    }

    public Client guardarCliente(Client datos){
        if(datos.getIdClient()==null){
            return clientRepositorio.guardar(datos);

        }else{
            Optional<Client> consulta= clientRepositorio.obtenerCliente(datos.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepositorio.guardar(datos);
            }else{
                return datos;
            }
        }
    }
    public Client update(Client datos){
        if(datos.getIdClient()!=null){
            Optional<Client>consulta= clientRepositorio.obtenerCliente(datos.getIdClient());
            if(!consulta.isEmpty()){
                if (datos.getName()!=null) {
                    consulta.get().setName(datos.getName());   
                }if (datos.getPassword()!=null) {
                    consulta.get().setPassword(datos.getPassword());   
                }if(datos.getAge()!=null){
                    consulta.get().setAge(datos.getAge());
                }
                return clientRepositorio.guardar(consulta.get());
            }
        }return datos;
    }
    public boolean eliminarCliente(int id){
        Optional<Client>consulta = clientRepositorio.obtenerCliente(id);
        if(!consulta.isEmpty()){
            clientRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }
}
