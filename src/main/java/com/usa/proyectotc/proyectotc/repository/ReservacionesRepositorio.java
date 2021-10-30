package com.usa.proyectotc.proyectotc.repository;

import java.util.List;
import java.util.Optional;

import com.usa.proyectotc.proyectotc.model.Reservaciones;
import com.usa.proyectotc.proyectotc.repository.crud.ReservacionesCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservacionesRepositorio {
    @Autowired
    private ReservacionesCrudRepositorio crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }
    
}
