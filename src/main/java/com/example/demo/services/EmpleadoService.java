package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.repositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }

    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }

    public Optional<EmpleadoModel> obtenerPorId(String id){
        return empleadoRepository.findById(id);
    }

    public boolean eliminarEmpleado(String id) {
        try{
            empleadoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}