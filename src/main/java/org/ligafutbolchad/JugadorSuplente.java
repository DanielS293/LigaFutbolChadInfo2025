package org.ligafutbolchad;

class JugadorSuplente extends Jugador {
    private int partidosIngresados;

    public JugadorSuplente(String nombre, int edad, int partidosIngresados) {
        super(nombre, edad);
        this.partidosIngresados = partidosIngresados;
    }

    public int getPartidosIngresados() {
        return partidosIngresados;
    }

    public void setPartidosIngresados(int partidosIngresados) {
        this.partidosIngresados = partidosIngresados;
    }
}
