package org.ligafutbolchad;

public class CsvService {
    public void exportarDatosEquipo(Equipo equipo) {
        System.out.println("Exportando datos del equipo: " + equipo.getNombre());
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.println(jugador.getNombre() + ", Goles: " + jugador.getCantidadGoles());
        }
    }
}