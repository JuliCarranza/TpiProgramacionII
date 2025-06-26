package com.mycompany.tpi.controlador;

import com.mycompany.tpi.Archivos.ManejadorArchivos;
import com.mycompany.tpi.modelo.Jugador;
import com.mycompany.tpi.modelo.Pareja;
import com.mycompany.tpi.modelo.Torneo;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ControladorTorneo {
    private Torneo torneo;
    private Scanner sc = new Scanner(System.in);

    public ControladorTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public void cargarDatosDesdeArchivos() {
        System.out.println("Cargando jugadores y parejas desde archivos...");
        List<Jugador> jugadores = ManejadorArchivos.cargarJugadores("src/main/java/com/mycompany/tpi/Archivos/Jugadores.txt");
        List<Pareja> parejas = ManejadorArchivos.cargarParejas("src/main/java/com/mycompany/tpi/Archivos/Parejas.txt", jugadores);

        if (parejas.isEmpty()) {
            System.out.println("No se cargaron parejas. Verifica el archivo.");
            return;
        }

        for (Pareja p : parejas) {
            torneo.agregarPareja(p);
        }

        System.out.println("Se cargaron " + parejas.size() + " parejas correctamente.");
        System.out.println("Jugadores asociados: " + jugadores.size());
    }

    public void mostrarJugadores() {
        Set<Jugador> jugadores = new HashSet<>();
        for (Pareja p : torneo.getParejas()) {
            jugadores.add(p.getJugador1());
            jugadores.add(p.getJugador2());
        }
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores cargados.");
            return;
        }
        System.out.println("Listado de jugadores:");
        for (Jugador j : jugadores) {
            System.out.println(j);
        }
    }

    public void generarFixture() {
        if (torneo.getParejas().size() < 2) {
            System.out.println("No hay suficientes parejas para generar el fixture.");
            return;
        }
        torneo.generarFixture();
    }

    public void mostrarFixture() {
        if (torneo.getPartidos().isEmpty()) {
            System.out.println("El fixture no está generado. Generalo primero.");
            return;
        }
        torneo.mostrarFixture();
    }

    public void registrarResultadoDesdeConsola() {
        if (torneo.getPartidos().isEmpty()) {
            System.out.println("No hay partidos para registrar resultado. Genera el fixture primero.");
            return;
        }

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

        if (ganadora == null) {
            System.out.println("Pareja ganadora no encontrada.");
            return;
        }

        torneo.registrarResultado(id, ganadora, resultado);
    }

    public void mostrarTabla() {
        if (torneo.getParejas().isEmpty()) {
            System.out.println("No hay parejas cargadas para mostrar la tabla.");
            return;
        }
        torneo.mostrarTabla();
    }

    public void mostrarCampeon() {
        if (torneo.getParejas().isEmpty()) {
            System.out.println("No hay parejas cargadas para determinar campeón.");
            return;
        }
        torneo.mostrarCampeon();
    }
}
