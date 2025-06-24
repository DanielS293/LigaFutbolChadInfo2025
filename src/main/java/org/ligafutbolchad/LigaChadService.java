package org.ligafutbolchad;
import java.util.ArrayList;
import java.util.List;

public class LigaChadService {
    private List<Equipo> equipos = new ArrayList<>();
    private List<Partido> partidos = new ArrayList<>();

    public void crearEquipo(String nombre) {
        equipos.add(new Equipo(nombre));
    }

    public void registrarJugador(Jugador jugador, Equipo equipo) {
        equipo.agregarJugador(jugador);
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    public void registrarGoles(Jugador jugador, int cantidad) {
        jugador.setCantidadGoles(jugador.getCantidadGoles() + cantidad);
    }

    public void listarJugadores(Equipo equipo) {
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.println(jugador.getNombre());
        }
    }

    public void transferirJugador(Jugador jugador, Equipo origen, Equipo destino) {
        origen.quitarJugador(jugador);
        destino.agregarJugador(jugador);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}