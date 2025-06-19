package com.mycompany.tpi.vista;

import com.mycompany.tpi.controlador.ControladorTorneo;
import java.util.Scanner;

public class MenuPrincipal {

    private final ControladorTorneo controlador;
    private final Scanner sc;

    public MenuPrincipal(ControladorTorneo controlador) {
        this.controlador = controlador;
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n----- MENÚ TORNEO DE PÁDEL -----");
            System.out.println("1. Cargar jugadores y parejas desde archivo");
            System.out.println("2. Generar fixture de partidos");
            System.out.println("3. Mostrar fixture");
            System.out.println("4. Registrar resultado");
            System.out.println("5. Mostrar tabla de posiciones");
            System.out.println("6. Mostrar pareja campeona");
            System.out.println("7. Mostrar jugadores");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar salto de línea

            switch (opcion) {
                case 1 -> controlador.cargarDatosDesdeArchivos();
                case 2 -> controlador.generarFixture();
                case 3 -> controlador.mostrarFixture();
                case 4 -> controlador.registrarResultadoDesdeConsola();
                case 5 -> controlador.mostrarTabla();
                case 6 -> controlador.mostrarCampeon();
                case 7 -> controlador.mostrarJugadores();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

}
        
