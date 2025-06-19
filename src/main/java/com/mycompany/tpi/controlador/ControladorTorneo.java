package com.mycompany.tpi.controlador;

import com.mycompany.tpi.Archivos.ManejadorArchivos;
import com.mycompany.tpi.modelo.Jugador;
import com.mycompany.tpi.modelo.Pareja;
import com.mycompany.tpi.modelo.Torneo;
import java.util.List;
import java.util.Scanner;


public class ControladorTorneo {
    private Torneo torneo;
    private Scanner sc = new Scanner(System.in);

    public ControladorTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public void cargarDatosDesdeArchivos() {
        List<Jugador> jugadores = ManejadorArchivos.cargarJugadores("jugadores.txt");
        List<Pareja> parejas = ManejadorArchivos.cargarParejas("parejas.txt", jugadores);

        for (Pareja p : parejas) {
            torneo.agregarPareja(p);
        }
        System.out.println("Jugadores y parejas cargados correctamente.");
    }

    public void generarFixture() {
        torneo.generarFixture();
    }

    public void mostrarFixture() {
        torneo.mostrarFixture();
    }

    public void mostrarTabla() {
        torneo.mostrarTabla();
    }

    public void mostrarCampeon() {
        torneo.mostrarCampeon();
    }

    public void registrarResultadoDesdeConsola() {
        System.out.print("ID del partido: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("ID de la pareja ganadora: ");
        int idGanadora = sc.nextInt();
        sc.nextLine();
        System.out.print("Resultado (ej: 6-3 4-6 6-2): ");
        String resultado = sc.nextLine();

        Pareja ganadora = null;
        for (Pareja p : torneo.getParejas()) {
            if (p.getId() == idGanadora) {
                ganadora = p;
                break;
            }
        }

        if (ganadora != null) {
            torneo.registrarResultado(id, ganadora, resultado);
        } else {
            System.out.println("Pareja no encontrada.");
        }
    }
    
}
