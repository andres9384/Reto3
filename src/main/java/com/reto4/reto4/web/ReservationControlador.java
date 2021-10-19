package com.reto4.reto4.web;

import java.util.List;

import com.reto4.reto4.modelo.Reservation;
import com.reto4.reto4.servicio.ReservationServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    // @ResponseStatus(HttpStatus.CREATED)
    public Reservation guardar(@RequestBody Reservation datos){
        return reservationServicio.guardar(datos);
    }
}
