package com.mycompany.tpi.modelo;

public class Partido {
    private int id;
    private Pareja pareja1;
    private Pareja pareja2;
    private Pareja ganadora;
    private String resultado; // Ejemplo: "6-3 4-6 6-2"
    private boolean finalizado;

    // Constructor sin resultado (partido no jugado aún)
    public Partido(int id, Pareja pareja1, Pareja pareja2) {
        this.id = id;
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.finalizado = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Pareja getPareja1() {
        return pareja1;
    }

    public Pareja getPareja2() {
        return pareja2;
    }

    public Pareja getGanadora() {
        return ganadora;
    }

    public String getResultado() {
        return resultado;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    // Método para registrar el resultado
    public void registrarResultado(Pareja ganadora, String resultado) {
        this.ganadora = ganadora;
        this.resultado = resultado;
        this.finalizado = true;
    }

    // Mostrar info del partido
    public void mostrarInfo() {
        System.out.println("Partido ID: " + id);
        System.out.println("Pareja 1: " + pareja1.getNombres());
        System.out.println("Pareja 2: " + pareja2.getNombres());
        if (finalizado) {
            System.out.println("Ganadora: " + ganadora.getNombres());
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("Estado: Pendiente");
        }
        System.out.println("---------------------------");
    }
}

}
