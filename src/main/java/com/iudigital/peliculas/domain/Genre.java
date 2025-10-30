package com.iudigital.peliculas.domain;

public class Genre {

    private int id;
    private String nombre;

    public Genre() {
    }

    public Genre(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
}
