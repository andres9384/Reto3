package com.reto4.reto4.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Reservation;
import com.reto4.reto4.modelo.Reporte.ContReservations;
import com.reto4.reto4.modelo.Reporte.ContStatus;
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

    public List<ContReservations>topReservaciones(){
        return reservationRepositorio.topReservaciones();
    }

    public ContStatus estados(){
        List<Reservation> completed= reservationRepositorio.estados("completed");
        List<Reservation> cancelled= reservationRepositorio.estados("cancelled");

        ContStatus reporteEstados = new ContStatus(completed.size(),cancelled.size());
        return reporteEstados;
    }
    public List<Reservation> fechaReservations(String inicio,String fin){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date start= new Date();
        Date end= new Date();

        try {
            start=formato.parse(inicio);
            end=formato.parse(fin);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(start.before(end)){
            return reservationRepositorio.fechasReservacion(start, end);
        }else{
            return new ArrayList<>();
        }
    }
}
