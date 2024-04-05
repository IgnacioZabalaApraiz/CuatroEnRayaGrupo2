package modelo;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "jugador") // el elemento raíz se llamará 'Jugador'
@XmlType(propOrder = { "nombre", "numVictorias", "numEmpates", "numDerrotas", "puntuacion" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Jugador implements Comparable<Jugador> {
	@XmlElement(name = "nombre")
	private String nombre;
	@XmlElement(name = "victorias")
	private int numVictorias;
	@XmlElement(name = "empates")
	private int numEmpates;
	@XmlElement(name = "derrotas")
	private int numDerrotas;
	@XmlElement(name = "puntuacion")
	private int puntuacion = 0;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	// Método para registrar el resultado de un juego
	public void registrarResultado(int resultado) {
		if (resultado == 1) { // Victoria
			numVictorias++;
		} else if (resultado == 0) { // Empate
			numEmpates++;
		} else { // Derrota
			numDerrotas++;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumVictorias() {
		return numVictorias;
	}

	public void setNumVictorias(int numVictorias) {
		this.numVictorias = numVictorias;
	}

	public int getNumEmpates() {
		return numEmpates;
	}

	public void setNumEmpates(int numEmpates) {
		this.numEmpates = numEmpates;
	}

	public int getNumDerrotas() {
		return numDerrotas;
	}

	public void setNumDerrotas(int numDerrotas) {
		this.numDerrotas = numDerrotas;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = calcularPuntuacion();
	}

	// Método para calcular la puntuación del jugador
	public int calcularPuntuacion() {
		return numVictorias * 3 + numEmpates;
	}

	// Método para obtener la puntuación
	public int getPuntuacion() {
		return calcularPuntuacion();
	}

	// Método para mostrar el nombre y la puntuación del jugador
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", numVictorias=" + numVictorias + ", numEmpates=" + numEmpates
				+ ", numDerrotas=" + numDerrotas + ", puntuacion=" + puntuacion + "]";
	}

	// Método para comparar las puntuaciones de los jugadores
	@Override
	public int compareTo(Jugador otroJugador) {
		return Integer.compare(this.puntuacion, otroJugador.puntuacion);
	}

}