package modelo;

import java.util.Arrays;

public class Tablero {
	private int[][] tablero = { 
	        {0,0,0,0,0,0},
	        {0,0,0,0,0,0},
	        {0,0,0,0,0,0},
	        {0,0,0,0,0,0},
	        {0,0,0,0,0,0},
	        {0,0,0,0,0,0}
	    };

	public void mostrarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
	}
	//Método para verificar si la columna es válida
	public boolean colocarFicha(int columna, int jugador) {
		
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
	
	// Método para deducir quién ha ganado en las distintas vías posibles
	public boolean detectarCuatroEnRaya(int n) {
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

	public boolean juegoCompleto() {
		boolean ganador = detectarCuatroEnRaya(1) || detectarCuatroEnRaya(2);
		return ganador;
	}
}