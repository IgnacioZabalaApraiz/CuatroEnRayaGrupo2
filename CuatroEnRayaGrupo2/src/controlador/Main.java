package controlador;

import java.util.Arrays;

public class Main {
	private static int[][] tablero = 
		{		
				{0,1,1,0,0,0},
				{0,1,1,0,0,0},
				{0,0,1,0,1,1},
				{1,1,0,1,0,1},
				{0,0,0,1,1,1},
				{0,1,0,0,0,1}
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
		
		//int[][] tablero = new int [6][2];// primero filas y luego columnas
		
		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
		
		if (detectarColumna(1)) {// aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
			System.out.println("Has ganado.");
		} else {
			System.out.println("Derrota.");
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
		
		return false;
	}

}
