package modelo;

public class Jugador implements Comparable<Jugador> {
	private String nombre;
	private String color;
	private int puntuacion = 0;

	
	public Jugador(String nombre, String color) {
		this.nombre = nombre;
		this.color = color;
	}

	// Método para que la puntuación incremente si el jugador ha ganado
	public void haTerminado(boolean haGanado) {
		if (haGanado) {
			this.puntuacion += 3;
		} else {
			this.puntuacion += 1;
		}
	}

	// Método para obtener la puntuación
	public int getPuntuacion() {
		return puntuacion;
	}

	// Método para mostrar el nombre y la puntuación del jugador
	@Override
	public String toString() {
		return nombre + ": " + puntuacion;
	}

	// Método para comparar las puntuaciones de los jugadores
	@Override
	public int compareTo(Jugador otroJugador) {
		return Integer.compare(this.puntuacion, otroJugador.getPuntuacion());
	}
}