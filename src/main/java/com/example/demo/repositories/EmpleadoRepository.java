package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.EmpleadoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, String> {
    //public abstract ArrayList<EmpleadoModel> findByNro_documento(Integer nro_documento);

}