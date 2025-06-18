
package com.mycompany.tpi.modelo;


public class Pareja {
    private int id;
    private Jugador jugador1;
    private Jugador jugador2;

    public Pareja(int id, Jugador jugador1, Jugador jugador2) {
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public int getId() {
        return id;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    @Override
    public String toString() {
        return "Pareja{" + "id=" + id + ", jugador1=" + jugador1 + ", jugador2=" + jugador2 + '}';
    }
    
    public String getNombres() {
    return jugador1.getNombre() + "y" + jugador2.getNombre();
    }
    
}
