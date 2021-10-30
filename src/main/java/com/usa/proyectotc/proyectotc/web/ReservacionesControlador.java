package com.usa.proyectotc.proyectotc.web;

import java.util.List;
import java.util.Optional;

import com.usa.proyectotc.proyectotc.model.Reservaciones;
import com.usa.proyectotc.proyectotc.service.ReservacionesServicio;

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
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservacionesControlador {
    @Autowired
    private ReservacionesServicio servicio4;
    @GetMapping("/all")
    public List<Reservaciones> getReservations(){
        return servicio4.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio4.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio4.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return servicio4.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio4.deleteReservation(reservationId);
    }
    
}
