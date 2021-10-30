package com.reto4.reto4.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Client;
import com.reto4.reto4.modelo.Reservation;
import com.reto4.reto4.modelo.Reporte.ContReservations;
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

    public List<Reservation> estados(String estado){
        return reservationCrudRepositorio.findAllByStatus(estado);
    }

    public List<Reservation> fechasReservacion(Date start, Date end){
        return reservationCrudRepositorio.findAllByStartDateAfterAndDevolutionDateBefore(start, end);
    }

    public List<ContReservations>topReservaciones(){
        List<ContReservations>res= new ArrayList<>();

        List<Object[]> reporte= reservationCrudRepositorio.countTotalReservationByClient();

        for(int i =0; i< reporte.size();i++){
            res.add(new ContReservations((Long)reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }
        return res;
    }
}
