package modelo;

public class Jugador implements Comparable<Jugador> {
	private String nombre;
	private String color;
	private int numVictorias;
	private int numEmpates;
	private int numDerrotas;
	private int puntuacion = 0;

	public Jugador(String nombre, String color) {
		this.nombre = nombre;
		this.color = color;
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
		return nombre + ": " + calcularPuntuacion();
	}

	// Método para comparar las puntuaciones de los jugadores
	@Override
	public int compareTo(Jugador otroJugador) {
		return Integer.compare(this.calcularPuntuacion(), otroJugador.calcularPuntuacion());
	}
}