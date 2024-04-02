package modelo;

public class ListaJugadores {
	private Jugador[] jugadores;

	
	public ListaJugadores(int cantidadJugadores) {
		this.jugadores = new Jugador[cantidadJugadores];
	}

	// Método para agregar un jugador a la lista
	public void agregarJugador(int indice, Jugador jugador) {
		if (indice >= 0 && indice < jugadores.length) {
			jugadores[indice] = jugador;
		} else {
			System.out.println("Índice fuera de rango.");
		}
	}

	// Método para obtener un jugador de la lista
	public Jugador obtenerJugador(int indice) {
		if (indice >= 0 && indice < jugadores.length) {
			return jugadores[indice];
		} else {
			System.out.println("Índice fuera de rango.");
			return null;
		}
	}

	// Método para obtener la cantidad de jugadores en la lista
	public int cantidadJugadores() {
		return jugadores.length;
	}
}