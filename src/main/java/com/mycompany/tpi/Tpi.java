package com.mycompany.tpi;

import com.mycompany.tpi.Archivos.ManejadorArchivos;
import com.mycompany.tpi.controlador.ControladorTorneo;
import com.mycompany.tpi.modelo.Jugador;
import com.mycompany.tpi.modelo.Pareja;
import com.mycompany.tpi.modelo.Torneo;
import com.mycompany.tpi.vista.MenuPrincipal;
import java.util.List;

public class Tpi {

    public static void main(String[] args) {
        // Ruta archivo jugadores
        String archivoJugadores = "src/main/java/com/mycompany/tpi/Archivos/Jugadores.txt";

        // Ruta archivo parejas
        String archivoParejas = "src/main/java/com/mycompany/tpi/Archivos/Parejas.txt";

        // Cargar jugadores
        List<Jugador> listaJugadores = ManejadorArchivos.cargarJugadores(archivoJugadores);

        // Cargar parejas usando la lista de jugadores
        List<Pareja> listaParejas = ManejadorArchivos.cargarParejas(archivoParejas, listaJugadores);

        // Crear torneo
        Torneo torneo = new Torneo("Torneo Final");

        // Crear controlador y pasarle el torneo
        ControladorTorneo controlador = new ControladorTorneo(torneo);

        // Crear menú y pasárselo al controlador
        MenuPrincipal menu = new MenuPrincipal(controlador);

        // Mostrar menú principal
        menu.mostrarMenu();
    }
}
