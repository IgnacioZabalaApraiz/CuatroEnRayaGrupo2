package controlador;

import java.util.Arrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import modelo.Jugador;
import modelo.ListaJugadores;

import vista.VentanaGanador;
import vista.VentanaInicio;
import vista.VentanaResultados;
import vista.VentanaTablero;

public class Main {
	public static int[][] tablero;
	public static VentanaTablero vt;
	public static VentanaGanador vg;
	public static VentanaInicio vi;
	public static VentanaResultados vr;
	public static ListaJugadores lj;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JAXBContext contexto = JAXBContext.newInstance(ListaJugadores.class);
			Unmarshaller um = contexto.createUnmarshaller();
			lj = (ListaJugadores) um.unmarshal(new File("resources/jugadores.xml"));
			System.out.println("Lectura de archivos realizada con exito!");

		} catch (JAXBException e) {
			System.out.println("Ha habido un error con JAXB");
			lj = new ListaJugadores();
		} catch (IllegalArgumentException e) {
			System.out.println("No se encuentra el archico jugadores.xml. Se creara uno nuevo.");
			lj = new ListaJugadores();
		}

		vi = new VentanaInicio();
		vi.setVisible(true);
	}
	
	public static void anadirResultado(String ganador, String perdedor, boolean victoria) {
		for (Jugador j : lj.getJugadores()) {
			if (j.getNombre().equals(ganador)) {
				if (victoria) {
					j.registrarResultado(1);
				} else {
					j.registrarResultado(0);
				}
				j.calcularPuntuacion();
			} else if (j.getNombre().equals(perdedor)) {
				if (victoria) {
					j.registrarResultado(2);
				} else {
					j.registrarResultado(0);
				}
				j.calcularPuntuacion();
			}
		}
		Arrays.sort(lj.getJugadores());
		
	}

	public static void almacenarJugadores() {
		try {
			JAXBContext contexto = JAXBContext.newInstance(ListaJugadores.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(lj, new FileWriter("resources/jugadores.xml"));
			System.out.println("Lista de jugadores actualizada y almacenada en el archivo jugadores.xml");

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean detectarCuatroEnRaya(int n) {

		int filas = tablero.length;
		int columnas = tablero[0].length;

		// Detectar en horizontal y en vertical
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				// Horizontal
				if (j + 3 < columnas && tablero[i][j] == n && tablero[i][j + 1] == n && tablero[i][j + 2] == n
						&& tablero[i][j + 3] == n) {
					return true;
				}

				// Vertical
				if (i + 3 < filas && tablero[i][j] == n && tablero[i + 1][j] == n && tablero[i + 2][j] == n
						&& tablero[i + 3][j] == n) {
					return true;
				}
			}
		}

		// Detectar en diagonal
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				// Diagonal hacia abajo
				if (i + 3 < filas && j + 3 < columnas && tablero[i][j] == n && tablero[i + 1][j + 1] == n
						&& tablero[i + 2][j + 2] == n && tablero[i + 3][j + 3] == n) {
					return true;
				}

				// Diagonal hacia arriba
				if (i - 3 >= 0 && j + 3 < columnas && tablero[i][j] == n && tablero[i - 1][j + 1] == n
						&& tablero[i - 2][j + 2] == n && tablero[i - 3][j + 3] == n) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean colocarFicha(int columna, int jugador) {

		// Verificar si la columna es válida

		if (columna < 0 || columna >= tablero[0].length) {
			System.out.println("Columna inválida. La ficha no se puede colocar en esa columna.");
			return false;
		}

		// El tablero se dibujará desde abajo hacia arriba

		for (int fila = tablero.length - 1; fila >= 0; fila--) {

			if (tablero[fila][columna] == 0) {
				// Si se encuentra una celda vacía se colocará la ficha del jugador actual
				tablero[fila][columna] = jugador;
				return true;
			}
		}

		System.out.println("La columna está llena. No se pudo colocar la ficha.");
		return false;
	}

	public static void imprimirTablero() {

		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
	}

	public static boolean juegoCompleto() {

		boolean ganador = detectarCuatroEnRaya(1) || detectarCuatroEnRaya(2);
		return ganador;
	}

	// Método para decidir quién empieza primero
	public static int turnoJugador() {

		return (int) (Math.random() * 2) + 1;
	}

	public static boolean tableroLleno() {
		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == 0) {
					return false;
				}
			}
		}
		// Si no se encontraron celdas vacías, el tablero está lleno
		System.out.println("El tablero está lleno.");
		return true;
	}

}