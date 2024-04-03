package controlador;

import java.util.Arrays;
import java.util.Scanner;

import vista.VentanaGanador;
import vista.VentanaTablero;

public class Main {
	public static int[][] tablero;
	public static VentanaTablero vt;
	public static VentanaGanador vg;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Elige la dificultad (facil, normal o dificil):");
		Scanner sc = new Scanner(System.in);
		String resp = sc.nextLine();
		switch (resp) {
		case "facil":
			tablero = new int[4][5];
			break;
		case "normal":
			tablero = new int[6][7];
			break;
		case "dificil":
			tablero = new int[16][17];
			break;
		default:
			System.out.println("Error al elegir dificultad. Dificultad normal elegida por defecto.");
			tablero = new int[6][7];
		}
		// Se rellena el tablero de 0
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = 0;
			}
		}
		vt = new VentanaTablero();
		vt.setVisible(true);
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

	public static int obtenerColumna(Scanner scanner) {

		System.out.print("Ingrese el número de columna donde desea colocar la ficha (0-5): ");
		return scanner.nextInt();
	}

	public static boolean juegoCompleto() {

		boolean ganador = detectarCuatroEnRaya(1) || detectarCuatroEnRaya(2);
		return ganador;
	}

	// Método para decidir quién empieza primero
	public static int turnoJugador() {

		return (int) (Math.random() * 2) + 1;
	}
}