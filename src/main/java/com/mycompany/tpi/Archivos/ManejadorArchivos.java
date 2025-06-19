package com.mycompany.tpi.Archivos;

import com.mycompany.tpi.modelo.Jugador;
import com.mycompany.tpi.modelo.Pareja;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivos {
    // Carga jugadores desde un archivo .txt
    public static List<Jugador> cargarJugadores(String nombreArchivo) {
        List<Jugador> jugadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // ignora líneas vacías

                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String dni = datos[2];
                    int edad = Integer.parseInt(datos[3]);
                    String categoria = datos[4];
                    String localidad = datos[5];

                    Jugador jugador = new Jugador(nombre, apellido, dni, categoria, localidad, edad);
                    jugadores.add(jugador);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de jugadores: " + e.getMessage());
        }

        return jugadores;
    }

    // Carga parejas desde archivo .txt usando la lista de jugadores ya cargados
    public static List<Pareja> cargarParejas(String nombreArchivo, List<Jugador> jugadores) {
        List<Pareja> parejas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int id = Integer.parseInt(datos[0]);
                    String dni1 = datos[1];
                    String dni2 = datos[2];

                    Jugador j1 = buscarJugadorPorDNI(jugadores, dni1);
                    Jugador j2 = buscarJugadorPorDNI(jugadores, dni2);

                    if (j1 != null && j2 != null) {
                        Pareja pareja = new Pareja(id, j1, j2);
                        parejas.add(pareja);
                    } else {
                        System.out.println("Advertencia: Jugadores no encontrados para pareja ID " + id);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de parejas: " + e.getMessage());
        }

        return parejas;
    }

    // Busca un jugador por su DNI dentro de la lista
    private static Jugador buscarJugadorPorDNI(List<Jugador> jugadores, String dni) {
        for (Jugador j : jugadores) {
            if (j.getDni().equals(dni)) {
                return j;
            }
        }
        return null; 
    }
}
