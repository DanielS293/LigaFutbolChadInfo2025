package org.ligafutbolchad;

class JugadorTitular extends Jugador {
    private int minutosJugados;

    public JugadorTitular(String nombre, int edad, int minutosJugados) {
        super(nombre, edad);
        this.minutosJugados = minutosJugados;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }
}