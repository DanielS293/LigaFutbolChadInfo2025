package org.ligafutbolchad;

public abstract class Jugador {
    protected String nombre;
    protected int edad;
    protected int cantidadGoles;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantidadGoles = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }
}
