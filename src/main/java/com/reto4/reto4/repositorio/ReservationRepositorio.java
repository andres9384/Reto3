package com.reto4.reto4.repositorio;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Reservation;
import com.reto4.reto4.repositorio.crud.ReservationCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;

    public List<Reservation>obtenerTodo(){
        return (List<Reservation>)reservationCrudRepositorio.findAll();

    }

    public Reservation guardar(Reservation datos){
        return reservationCrudRepositorio.save(datos);
    }

    public Optional<Reservation>obtenerReservacion(int id){
        return reservationCrudRepositorio.findById(id);
    }

    public void  delete(Reservation dato){
        reservationCrudRepositorio.delete(dato);
    }
}
