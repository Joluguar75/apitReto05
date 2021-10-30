package com.usa.proyectotc.proyectotc.repository;

import java.util.List;
import java.util.Optional;

import com.usa.proyectotc.proyectotc.model.Computer;
import com.usa.proyectotc.proyectotc.repository.crud.ComputerCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepositorio {
    @Autowired
    private ComputerCrudRepositorio crud;

    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();
    }

    public Optional<Computer> getComputer(int id){
        return crud.findById(id);
    }

    public Computer save(Computer computer){
        return crud.save(computer);
    }

    public void delete(Computer computer){
        crud.delete(computer);
    }
    
}
