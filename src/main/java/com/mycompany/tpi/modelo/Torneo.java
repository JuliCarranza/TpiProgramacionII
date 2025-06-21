package com.mycompany.tpi.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Torneo {

    private String nombre;
    private List<Pareja> parejas;
    private List<Partido> partidos;
    private Map<Pareja, TablaPosiciones> tablaDePosiciones;

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.parejas = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.tablaDePosiciones = new HashMap<>();
    }

    // Agregar pareja al torneo
    public void agregarPareja(Pareja p) {
        parejas.add(p);
        tablaDePosiciones.put(p, new TablaPosiciones());
    }

    // Genera automáticamente los 15 partidos (round robin)
    public void generarFixture() {
        int id = 1;
        for (int i = 0; i < parejas.size(); i++) {
            for (int j = i + 1; j < parejas.size(); j++) {
                Partido partido = new Partido(id++, parejas.get(i), parejas.get(j));
                partidos.add(partido);
            }
        }
        System.out.println("Fixture generado con " + partidos.size() + " partidos.");
    }

    // Registrar resultado de un partido
    public void registrarResultado(int idPartido, Pareja ganadora, String resultado) {
        for (Partido p : partidos) {
            if (p.getId() == idPartido) {
                if (p.isFinalizado()) {
                    System.out.println("Ese partido ya fue finalizado.");
                    return;
                }
                p.registrarResultado(ganadora, resultado);

                // Actualizar tabla
                TablaPosiciones tpGanadora = tablaDePosiciones.get(ganadora);
                tpGanadora.partidoGanado();

                Pareja perdedora = (p.getPareja1().equals(ganadora)) ? p.getPareja2() : p.getPareja1();
                TablaPosiciones tpPerdedora = tablaDePosiciones.get(perdedora);
                tpPerdedora.partidoPerdido();

                System.out.println("Resultado registrado con exito.");
                return;
            }
        }
        System.out.println("Partido no encontrado.");
    }

    // Mostrar tabla de posiciones ordenada por puntos (y por diferencia de partidos si querés)
    public void mostrarTabla() {
        System.out.println("Tabla de Posiciones:");
        System.out.println("--------------------");

        parejas.sort((p1, p2) -> {
            TablaPosiciones tp1 = tablaDePosiciones.get(p1);
            TablaPosiciones tp2 = tablaDePosiciones.get(p2);
            return Integer.compare(tp2.getPuntos(), tp1.getPuntos()); // de mayor a menor
        });

        for (Pareja p : parejas) {
            TablaPosiciones tp = tablaDePosiciones.get(p);
            System.out.println(p.getNombres() + " | Pts: " + tp.getPuntos()
                    + " | Ganados: " + tp.getGanados()
                    + " | Perdidos: " + tp.getPerdidos()
                    + " | Jugados: " + tp.getJugados());
        }
    }

    // Mostrar pareja campeona
    public void mostrarCampeon() {
        Pareja campeon = null;
        int maxPuntos = -1;

        for (Pareja p : parejas) {
            int puntos = tablaDePosiciones.get(p).getPuntos();
            if (puntos > maxPuntos) {
                maxPuntos = puntos;
                campeon = p;
            }
        }

        if (campeon != null) {
            System.out.println("La pareja campeona es: " + campeon.getNombres() + " con " + maxPuntos + " puntos");
        } else {
            System.out.println("No hay campeón aún.");
        }
    }

    // Getters
    public List<Pareja> getParejas() {
        return parejas;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public Map<Pareja, TablaPosiciones> getTablaDePosiciones() {
        return tablaDePosiciones;

    }

    public void mostrarFixture() {
        System.out.println("-------- Fixture del Torneo --------");
        for (Partido partido : partidos) {
            System.out.print("Partido ID: " + partido.getId() + " - ");
            System.out.print("[" + partido.getPareja1().getId() + "] " + partido.getPareja1().getNombres()
                    + " vs [" + partido.getPareja2().getId() + "] " + partido.getPareja2().getNombres());

            if (partido.isFinalizado()) {
                System.out.println(" | Resultado: " + partido.getResultado()
                        + " | Ganadora: [" + partido.getGanadora().getId() + "] " + partido.getGanadora().getNombres());
            } else {
                System.out.println(" | Estado: Pendiente");
            }
        }
        System.out.println("------------------------------------");
    }

}
