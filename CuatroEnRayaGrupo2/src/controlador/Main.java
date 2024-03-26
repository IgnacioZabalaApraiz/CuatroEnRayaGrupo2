package controlador;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int[][] tablero = { 
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0}
			
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Tablero inicial:");
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
		
		long inicio = System.nanoTime();
		
		
		int turnoJugador = turnoJugador();
		 Scanner scanner = new Scanner(System.in);

		// Bucle para verificar si está completo el tablero
		 while (!juegoCompleto()) {
		     
			 System.out.println();
		     System.out.println("Turno del jugador " + turnoJugador + ":");
		     
		     
		     int columna = obtenerColumna(scanner);

		     // Colocar ficha del jugador actual en la columna seleccionada
		     
		     if (colocarFicha(columna, turnoJugador)) {
		    	 System.out.println();
		         System.out.println("Tablero después del turno del jugador " + turnoJugador + ":");
		         imprimirTablero();

		         if (juegoCompleto()) {
		             break; 
		         }

		         // Le toca al siguiente jugador
		         turnoJugador = (turnoJugador == 1) ? 2 : 1;
		         
		     }
		 }
		 
		 System.out.println(detectarCuatroEnRaya(1) ? "El jugador 1 ha ganado." : "El jugador 2 ha ganado.");

	    
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
	    	
	    	return (int)(Math.random()*2)+1;
	    }
}