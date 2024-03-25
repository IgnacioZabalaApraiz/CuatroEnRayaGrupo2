package controlador;

import java.util.Arrays;

public class Main {
	private static int[][] tablero = { 
			{0,1,0,1,0,1},
			{1,0,1,0,1,0},
			{1,1,0,0,0,1},
			{0,0,0,1,1,1},
			{1,1,0,1,1,0},
			{0,1,0,1,0,1}
			
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
		
		long inicio = System.nanoTime();
		
		if (detectarCuatroEnRaya(1)) {
		 	System.out.println("Has ganado.");
		} else {
			System.out.println("Derrota.");
		}
        long fin = System.nanoTime();

        long tiempoEjecucion = fin - inicio;
        
        System.out.println("El método tardó " + tiempoEjecucion + " nanosegundos en ejecutarse.");

	}

	public static boolean detectarCuatroEnRaya(int n) {
		int filas = tablero.length;
		int columnas = tablero[0].length;
		
		// Detectar en horizontal y en vertical
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				// Horizontal
				if (j + 3 < columnas &&
						tablero[i][j] == n &&
						tablero[i][j + 1] == n &&
						tablero[i][j + 2] == n &&
						tablero[i][j + 3] == n) {
					return true;
				}
				
				// Vertical
				if (i + 3 < filas &&
						tablero[i][j] == n &&
						tablero[i + 1][j] == n &&
						tablero[i + 2][j] == n &&
						tablero[i + 3][j] == n) {
					return true;
				}
			}
		}
		
		// Detectar en diagonal
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				// Diagonal hacia abajo
				if(i + 3 < filas && j + 3 < columnas &&
						tablero[i][j] == n &&
						tablero[i + 1][j + 1] == n &&
						tablero[i + 2][j + 2] == n &&
						tablero[i + 3][j + 3] == n) {
					return true;
				}
				
				// Diagonal hacia arriba
				if(i - 3 >= 0 && j + 3 < columnas &&
						tablero[i][j] == n &&
						tablero[i - 1][j + 1] == n &&
						tablero[i - 2][j + 2] == n &&
						tablero[i - 3][j + 3] == n) {
					return true;
				}
			}
		}
		
		return false;
	}
}