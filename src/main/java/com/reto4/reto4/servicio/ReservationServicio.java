package com.reto4.reto4.servicio;

import java.util.List;

import com.reto4.reto4.modelo.Reservation;
import com.reto4.reto4.repositorio.ReservationRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;
    public List<Reservation>obtenerTodo(){
        return reservationRepositorio.obtenerTodo();
    }

    public Reservation guardar(Reservation datos){
            return reservationRepositorio.guardar(datos);
    }
}
