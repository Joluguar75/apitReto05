package com.usa.proyectotc.proyectotc.repository;

import java.util.List;
import java.util.Optional;

import com.usa.proyectotc.proyectotc.model.Cliente;
import com.usa.proyectotc.proyectotc.repository.crud.ClienteCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ClienteRepositorio {
    @Autowired
    private ClienteCrudRepositorio crud2;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud2.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        return crud2.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crud2.save(cliente);
    }
    public void delete(Cliente cliente){
        crud2.delete(cliente);
    }
    
}

