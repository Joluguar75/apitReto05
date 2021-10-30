package com.usa.proyectotc.proyectotc.service;

import java.util.List;
import java.util.Optional;

import com.usa.proyectotc.proyectotc.model.Reservaciones;
import com.usa.proyectotc.proyectotc.repository.ReservacionesRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservacionesServicio {
    @Autowired
    private ReservacionesRepositorio metodosCrud4;

    public List<Reservaciones> getAll(){
        return metodosCrud4.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud4.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud4.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud4.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud4.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud4.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud4.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud4.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
