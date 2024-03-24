package controlador;

import java.util.Arrays;

public class Main {
	private static int[][] tablero = { 
			// Pruebas
			{0,0,0,0,0,0},
			{0,0,1,0,0,0},
			{0,0,0,1,0,0},
			{0,0,0,0,1,0},
			{0,0,0,0,0,1},
			{0,0,0,0,0,0}
			
	};
//		{		
//		{0,0,0,0,0,0},
//		{0,0,0,0,0,0},
//		{0,0,0,0,0,0},
//		{0,0,0,0,0,0},
//		{0,0,0,0,0,0},
//		{0,0,0,0,0,0}
//		};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[][] tablero = new int [6][2];// primero filas y luego columnas

		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}

//		if (detectarColumna(1)) {// aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
//		 	System.out.println("Has ganado.");
//		} else {
//			System.out.println("Derrota.");
//		}
		if (detectarFila(1)) {
			System.out.println("Has ganado formando una fila de 4");
		} else if(detectarColumna(1)){
			System.out.println("Has ganado formando una columna de 4");
		} else if(detectarDiagonal(1)){
			System.out.println("Has ganado formando una diagonal de 4");
		} else {
			System.out.println("No se ha encontrado nada");
		}

	}

	public static boolean detectarFila(int n) {
		int cont = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == n) {
					cont++;
				} else {
					cont = 0;
				}
				if (cont == 4) {
					return true;
				}
			}
			cont = 0;
		}

		return false;
	}

	public static boolean detectarColumna(int n) {
		int cont = 0;
		for (int i = 0; i < tablero[0].length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[j][i] == n) {
					cont++;
				} else {
					cont = 0;
				}
				if (cont == 4) {
					return true;
				}
			}
			cont = 0;
		}

		return false;
	}


	public static boolean detectarDiagonal(int n) {
	    int cont = 0;
	    // Diagonal desde superior izquierda hasta inferior derecha
	    for (int tamaño = 0; tamaño < tablero.length + tablero[0].length - 1; tamaño++) {
	        for (int i = 0; i < tablero.length; i++) {
	            for (int j = 0; j < tablero[0].length; j++) {
	                if (i + j == tamaño) {
	                    if (tablero[i][j] == n) {
	                        cont++;
	                    } else {
	                        cont = 0;
	                    }
	                    if (cont == 4) {
	                        return true;
	                    }
	                }
	            }
	        }
	        cont = 0;
	    }

	 // Diagonales desde superior derecha hasta inferior izquierda
	    for (int tamaño = 1 - tablero.length; tamaño < tablero[0].length; tamaño++) {
	        for (int i = 0; i < tablero.length; i++) {
	            for (int j = 0; j < tablero[0].length; j++) {
	                if (i - j == tamaño) { 
	                    if (tablero[i][j] == n) {
	                        cont++;
	                    } else {
	                        cont = 0;
	                    }
	                    if (cont == 4) {
	                        return true;
	                    }
	                }
	            }
	        }
	        cont = 0;
	    }
		return false;
	}
}