package com.reto4.reto4.web;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Reservation;
import com.reto4.reto4.servicio.ReservationServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationControlador {
    @Autowired
    private ReservationServicio reservationServicio;
    @GetMapping("/all")
    public List<Reservation>obtenerTodo(){
        return reservationServicio.obtenerTodo();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation guardar(@RequestBody Reservation datos){
        return reservationServicio.guardarReservacion(datos);
    }

    
    @GetMapping("/{numId}")
    public Optional<Reservation>getMessage(@PathVariable("numId")int id){
        return reservationServicio.obtenerReservacion(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation datos){
        return reservationServicio.update(datos);
    }
    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarMensaje(@PathVariable("numId")int id){
        return reservationServicio.eliminarReservacion(id);
    }
}
