package modelo;

import java.util.Arrays;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "cuatroEnRaya")
@XmlType(propOrder = { "jugadores" })
@XmlAccessorType(XmlAccessType.FIELD)

public class ListaJugadores {
	@XmlElementWrapper(name = "listaJugadores")
	@XmlElement(name = "jugador")
	private Jugador[] jugadores;

	public ListaJugadores() {
		this.jugadores = new Jugador[0];
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	// Método para agregar un jugador a la lista
	public void agregarJugador(Jugador jugador) {
		jugadores = Arrays.copyOf(jugadores, jugadores.length + 1);
		jugadores[jugadores.length - 1] = jugador;
	}

	// Método para eliminar un jugador a la lista
	public void eliminarJugador(Jugador jugador) {

	}

	// Método para obtener un jugador de la lista
	public Jugador obtenerJugador(int indice) {
		if (indice >= 0 && indice < jugadores.length) {
			return jugadores[indice];
		} else {
			System.out.println("Indice fuera de rango.");
			return null;
		}
	}

	// Método para obtener la cantidad de jugadores en la lista
	public int cantidadJugadores() {
		return jugadores.length;
	}
}