package com.example.demo.controllers;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

    @PostMapping()
    public String guardarEmpleado(@RequestBody EmpleadoModel usuario){
        
        LocalDate fecha_actual = LocalDate.now();
        LocalDate fecha_nacimiento = usuario.fecha_nacimiento.toLocalDate();

        Period period = Period.between(fecha_nacimiento, fecha_actual);

        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        
        String resultado = "";
    
        if(usuario.getNombres().isEmpty() || usuario.getApellidos().isEmpty() || usuario.getCargo().isEmpty()
            || usuario.getNroDocumento().isEmpty() || usuario.getTipoDocumento().isEmpty()){
            resultado = "{\"error\": \"Uno o mas datos enviados estan vacios\"}";
        } else if(years >= 18){
            this.empleadoService.guardarEmpleado(usuario);
            resultado = "{\"resultado\": \"Edad actual del empleado : Años: "+years+", Meses: "+months+", Días: "+days+"\", \"Tiempo de Vinculación a la compañía\": \"Años: "+years+", Meses: "+months+", Días: "+days+"\"}";
        } else{
            resultado = "{\"error\": \"El empleado ingresado es menor de edad y no se puede registrar\"}";
        }
        
        return resultado;
        
    }

    @GetMapping( path = "/{id}")
    public Optional<EmpleadoModel> obtenerUsuarioPorId(@PathVariable("id") String id) {
        return this.empleadoService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") String id){
        boolean ok = this.empleadoService.eliminarEmpleado(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}