package org.ligafutbolchad;
import java.util.*;

public class EstadisticaService {
    private LigaChadService liga;

    public EstadisticaService(LigaChadService liga) {
        this.liga = liga;
    }

    public void goleadorLiga() {
        Jugador goleador = null;
        for (Equipo equipo : liga.getEquipos()) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (goleador == null || jugador.getCantidadGoles() > goleador.getCantidadGoles()) {
                    goleador = jugador;
                }
            }
        }
        if (goleador != null) {
            System.out.println("Goleador de la liga: " + goleador.getNombre());
        }
    }

    public void promedioGolesEquipo() {
        for (Equipo equipo : liga.getEquipos()) {
            int totalGoles = 0;
            for (Jugador jugador : equipo.getJugadores()) {
                totalGoles += jugador.getCantidadGoles();
            }
            double promedio = equipo.getJugadores().size() > 0 ? (double) totalGoles / equipo.getJugadores().size() : 0;
            System.out.println("Promedio de goles de " + equipo.getNombre() + ": " + promedio);
        }
    }

    public void rankingEquiposPorGoles() {
        List<Equipo> equipos = liga.getEquipos();
        equipos.sort(new Comparator<Equipo>() {
            public int compare(Equipo e1, Equipo e2) {
                return Integer.compare(getTotalGoles(e2), getTotalGoles(e1));
            }
        });
        for (Equipo equipo : equipos) {
            System.out.println(equipo.getNombre() + ": " + getTotalGoles(equipo) + " goles");
        }
    }

    private int getTotalGoles(Equipo equipo) {
        int total = 0;
        for (Jugador jugador : equipo.getJugadores()) {
            total += jugador.getCantidadGoles();
        }
        return total;
    }

    public void suplentesNuncaIngresados() {
        for (Equipo equipo : liga.getEquipos()) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador instanceof JugadorSuplente) {
                    JugadorSuplente js = (JugadorSuplente) jugador;
                    if (js.getPartidosIngresados() == 0) {
                        System.out.println("Suplente sin ingresar: " + js.getNombre());
                    }
                }
            }
        }
    }

    public void titularConMasMinutos() {
        JugadorTitular max = null;
        for (Equipo equipo : liga.getEquipos()) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador instanceof JugadorTitular) {
                    JugadorTitular jt = (JugadorTitular) jugador;
                    if (max == null || jt.getMinutosJugados() > max.getMinutosJugados()) {
                        max = jt;
                    }
                }
            }
        }
        if (max != null) {
            System.out.println("Titular con más minutos: " + max.getNombre());
        }
    }

    public void reporteGeneralLiga() {
        for (Equipo equipo : liga.getEquipos()) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (Jugador jugador : equipo.getJugadores()) {
                System.out.println("- " + jugador.getNombre() + ", Goles: " + jugador.getCantidadGoles());
            }
        }
    }

    public void reporteEquipo(Equipo equipo) {
        System.out.println("Equipo: " + equipo.getNombre());
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.println("- " + jugador.getNombre() + ", Goles: " + jugador.getCantidadGoles());
        }
    }
}