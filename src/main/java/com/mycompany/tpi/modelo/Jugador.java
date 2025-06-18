package com.mycompany.tpi.modelo;

public class Jugador {

    private String nombre;
    private String apellido;
    private String dni;
    private String categoria;
    private String localidad;
    private int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getEdad() {
        return edad;
    }

    public Jugador(String nombre, String apellido, String dni, String categoria, String localidad, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.categoria = categoria;
        this.localidad = localidad;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", categoria=" + categoria + ", localidad=" + localidad + ", edad=" + edad + '}';
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
