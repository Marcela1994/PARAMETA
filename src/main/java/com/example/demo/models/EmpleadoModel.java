package com.example.demo.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class EmpleadoModel {

    @Id
    @Column(unique = true, nullable = false)
    private String nro_documento;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private String tipo_documento;
    @Column(nullable = false)
    public Date fecha_nacimiento;
    @Column(nullable = false)
    private Date fecha_vinculacion_empresa;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private Double salario;

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public String getNombres(){
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipo_documento;
    }

    public void setTipoDocumento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    
    public String getNroDocumento() {
        return nro_documento;
    }

    public void setNroDocumento(String nro_documento ) {
        this.nro_documento = nro_documento;
    }
    
    public Date getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(Date fecha_nacimiento ) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public Date getFechaVinculacionEmpresa() {
        return fecha_vinculacion_empresa;
    }

    public void setFechaVinculacionEmpresa(Date fecha_vinculacion_empresa ) {
        this.fecha_vinculacion_empresa = fecha_vinculacion_empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo ) {
        this.cargo = cargo;
    }
    
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario ) {
        this.salario = salario;
    }
}