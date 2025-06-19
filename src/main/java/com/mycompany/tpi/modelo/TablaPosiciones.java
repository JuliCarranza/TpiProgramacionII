package com.mycompany.tpi.modelo;

public class TablaPosiciones {
    private int puntos;
    private int ganados;
    private int perdidos;

    public void partidoGanado() {
        puntos += 2;
        ganados++;
    }

    public void partidoPerdido() {
        perdidos++;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getGanados() {
        return ganados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public int getJugados() {
        return ganados + perdidos;
    }
}
   
