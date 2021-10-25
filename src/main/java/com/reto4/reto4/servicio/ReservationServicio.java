package com.reto4.reto4.servicio;

import java.util.List;
import java.util.Optional;

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

    // public Reservation guardar(Reservation datos){
    //         return reservationRepositorio.guardar(datos);
    // }

    public Optional<Reservation>obtenerReservacion(int id){
        return reservationRepositorio.obtenerReservacion(id);
    }

    public Reservation guardarReservacion(Reservation datos){
        if(datos.getIdReservation()==null){
            return reservationRepositorio.guardar(datos);

        }else{
            Optional<Reservation> consulta= reservationRepositorio.obtenerReservacion(datos.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepositorio.guardar(datos);
            }else{
                return datos;
            }
        }
    }
    public Reservation update(Reservation datos){
        if(datos.getIdReservation()!=null){
            Optional<Reservation>consulta= reservationRepositorio.obtenerReservacion(datos.getIdReservation());
            if(!consulta.isEmpty()){
                if (datos.getStartDate()!=null) {
                    consulta.get().setStartDate(datos.getStartDate());   
                }
                if (datos.getDevolutionDate()!=null) {
                    consulta.get().setDevolutionDate(datos.getDevolutionDate());   
                }
                if (datos.getStatus()!=null) {
                    consulta.get().setStatus(datos.getStatus());   
                }
                return reservationRepositorio.guardar(consulta.get());
            }
        }return datos;
    }
    public boolean eliminarReservacion(int id){
        Optional<Reservation>consulta = reservationRepositorio.obtenerReservacion(id);
        if(!consulta.isEmpty()){
            reservationRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }
}
