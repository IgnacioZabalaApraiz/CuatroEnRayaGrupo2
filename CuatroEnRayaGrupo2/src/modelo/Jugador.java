package modelo;

public class Jugador {
    private String nombre;
    private int numeroJugador;

    public Jugador(String nombre, int numeroJugador) {
        this.nombre = nombre;
        this.numeroJugador = numeroJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }
}