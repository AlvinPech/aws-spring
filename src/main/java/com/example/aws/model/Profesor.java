package com.example.aws.model;

public class Profesor {
    Integer id;
    String nombres;
    String apellidos;
    Integer numeroEmpleado;
    Integer horasClase;

    public Profesor(){

    }
    
    public Profesor(Integer id, String nombres, String apellidos, Integer numeroEmpleado, Integer horasClase) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroEmpleado = numeroEmpleado;
        this.horasClase = horasClase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Integer numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    @Override
    public String toString() {
        return "Profesor [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", numeroEmpleado="
                + numeroEmpleado + ", horasClase=" + horasClase + "]";
    }

    
    
}
