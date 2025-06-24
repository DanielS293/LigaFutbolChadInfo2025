package org.ligafutbolchad;
import java.util.Map;
import java.util.HashMap;

class Partido {
    private String nombreTorneo;
    private int fechaTorneo;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private Map<Jugador, Integer> golesPorJugador;

    public Partido(String nombreTorneo, int fechaTorneo, Equipo local, Equipo visitante) {
        this.nombreTorneo = nombreTorneo;
        this.fechaTorneo = fechaTorneo;
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesPorJugador = new HashMap<>();
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getFechaTorneo() {
        return fechaTorneo;
    }

    public void setFechaTorneo(int fechaTorneo) {
        this.fechaTorneo = fechaTorneo;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public void setGolesPorJugador(Jugador jugador, int goles) {
        golesPorJugador.put(jugador, goles);
    }

    public int getGolesPorJugador(Jugador jugador) {
        Integer goles = golesPorJugador.get(jugador);
        return (goles != null) ? goles : 0;
    }

    public Map<Jugador, Integer> getGolesPorJugadorMap() {
        return golesPorJugador;
    }
}

