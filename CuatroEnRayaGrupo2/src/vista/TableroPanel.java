package vista;

import java.awt.*;

import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.swing.*;

import controlador.Main;

public class TableroPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final int COLUMNAS;
	private final int FILAS;
	private final int ANCHO_PANEL;
	private final int ALTO_PANEL;
	private final int ANCHO_FICHA;
	private Image[] fichas;
	private Image tableroIMG;
	private Image fondo;
	private Image ficha1;
	private Image ficha2;
	private JLabel textoTurno;
	private JLabel nombreTurno;
	private int contMovimientos = 0;
	private Timer timer;
	private int yVelocidad;
	private int x = 0;
	private int y = 0;
	private String nombre1;
	private String nombre2;

	// Constructor
	public TableroPanel(String jugador1, String jugador2, String color1, String color2) {
		// Setear las constantes dependiendo del tamaño del tablero
		COLUMNAS = Main.tablero[0].length;
		FILAS = Main.tablero.length;
		if (COLUMNAS != 17) {
			ANCHO_FICHA = 130;
			ficha1 = new ImageIcon("imagenes/ficha" + color1 + ".png").getImage();
			ficha2 = new ImageIcon("imagenes/ficha" + color2 + ".png").getImage();
			yVelocidad = 65;// Avanzara 1/2 ficha * el Timer
		} else {
			ANCHO_FICHA = 54;
			ficha1 = new ImageIcon("imagenes/ficha" + color1 + "Pequena.png").getImage();
			ficha2 = new ImageIcon("imagenes/ficha" + color2 + "Pequena.png").getImage();
			yVelocidad = 54;// Avanzara 1 ficha * el Timer
		}
		fondo = new ImageIcon("imagenes/fondo" + COLUMNAS + "x" + FILAS + ".png").getImage();
		tableroIMG = new ImageIcon("imagenes/tablero" + COLUMNAS + "x" + FILAS + ".png").getImage();
		ANCHO_PANEL = COLUMNAS * ANCHO_FICHA;
		ALTO_PANEL = FILAS * ANCHO_FICHA + 170;
		fichas = new Image[COLUMNAS * FILAS + 1];
		
		nombre1 = jugador1;
		nombre2 = jugador2;

		this.setPreferredSize(new Dimension(ANCHO_PANEL, ALTO_PANEL));
		this.setBackground(new Color(45, 109, 223));
		timer = new Timer(10, this);// Cada 10 ms
		setLayout(null);// Para poder poner los elementos en cualquier parte del panel

		textoTurno = new JLabel("Turno de");
		textoTurno.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		textoTurno.setForeground(new Color(255, 255, 255));
		textoTurno.setBounds((ANCHO_PANEL - textoTurno.getPreferredSize().width) / 2, ALTO_PANEL - 120, 372, 91);
		add(textoTurno);
		
		nombreTurno = new JLabel(nombre1);
		nombreTurno.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		nombreTurno.setForeground(new Color(255, 255, 255));
		nombreTurno.setBounds((ANCHO_PANEL - nombreTurno.getPreferredSize().width) / 2, ALTO_PANEL - 80, 372, 91);
		add(nombreTurno);

		// Bucle para crear los botones
		for (int i = 0; i < COLUMNAS; i++) {
			final int index = i;
			BotonPersonalizado boton = new BotonPersonalizado("");// Boton sin texto
			boton.setFont(new Font("Kristen ITC", Font.BOLD, ANCHO_FICHA / 4));
			boton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					generarFicha(index);
				}
			});
			if (COLUMNAS != 17) {
				boton.setBounds(15 + ANCHO_FICHA * i, ALTO_PANEL - 150, 100, 30);
			} else {
				boton.setBounds(2 + ANCHO_FICHA * i, ALTO_PANEL - 150, 50, 20);
			}
			add(boton);
		}
		timer.start();
	}

	public void generarFicha(int i) {
		boolean tableroLleno = Main.tableroLleno(); 
		y = 0;
		x = i; // Se queda seleccionada la columna concreta
		// Verifica si el tablero no está lleno y si hay espacio en la columna
		if (!tableroLleno && Main.tablero[0][x] == 0) {
			if (contMovimientos % 2 == 0) {
				fichas[contMovimientos] = ficha1;
			} else {
				fichas[contMovimientos] = ficha2;
			}
		}
	}
	
	/*
	 * MÉTODO ANTIGUO, EL MÉTODO DE ARRIBA ES SOLO PARA COMPROBAR EL MÉTODO tableroLleno funcione correctamente.
	 * public void generarFicha(int i) {
		y = 0;
		x = i;// Se queda seleccionada la columna concreta
		if (Main.tablero[0][x] == 0) {// Solo se genere una ficha si quedan huecos en la columna
			if (contMovimientos % 2 == 0) {
				fichas[contMovimientos] = fichaAmarilla;
			} else {
				fichas[contMovimientos] = fichaRoja;
			}
		}
	}
	 */

	public void paint(Graphics g) {// Se ejecuta al principio al iniciar la ventana y luego cada vez que se ejecuta
									// el repaint()

		super.paint(g); // Necesario para sobrescribir cada frame

		Graphics2D g2D = (Graphics2D) g;

		// Se pinta el fondo
		g2D.drawImage(fondo, 0, 0, null);
		// Se pintan las fichas que estan guardadas en el array tablero
		for (int i = 0; i < Main.tablero.length; i++) {
			for (int j = 0; j < Main.tablero[0].length; j++) {
				if (Main.tablero[i][j] == 1) {
					g2D.drawImage(ficha1, j * ANCHO_FICHA, i * ANCHO_FICHA, null);
				} else if (Main.tablero[i][j] == 2) {
					g2D.drawImage(ficha2, j * ANCHO_FICHA, i * ANCHO_FICHA, null);
				}
			}
		}
		// Se pinta la ficha nueva en movimiento
		g2D.drawImage(fichas[contMovimientos], x * ANCHO_FICHA, y, null);
		// Se pinta el tablero
		g2D.drawImage(tableroIMG, 0, 0, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// Este metodo se ejecuta automaticamente dependiendo de la
												// configuracion del Timer
		int pos = FILAS - 1;
		for (int i = 0; i < FILAS; i++) {
			if (Main.tablero[i][x] != 0) {
				pos = i - 1;
				break;
			}
		}
		if (fichas[contMovimientos] != null && y < ANCHO_FICHA * pos) {
			y += yVelocidad;
		} else if (fichas[contMovimientos] != null && y >= ANCHO_FICHA * pos) {// Si termina la animacion se introduce
																				// la ficha en el array tablero
			if (contMovimientos % 2 == 0) {
				Main.tablero[pos][x] = 1;
			} else {
				Main.tablero[pos][x] = 2;
			}

			reproducirAudio("imagenes/audioFicha.wav");

			
			if (Main.juegoCompleto()) {// Detectar si ha habido 4 en raya
				ventanaGanador(true);
				timer.stop();
			} else if (Main.tableroLleno()) {// Detectar si se ha llenado el tablero
				ventanaGanador(false);
				timer.stop();
			}
			contMovimientos++;
			cambiarNombre();
		}
		repaint();

	}

	public void cambiarNombre() {// Cambiar el nombre del jugador que le toca cada turno
		if (contMovimientos % 2 == 0) {
			nombreTurno.setText(nombre1);
		} else {
			nombreTurno.setText(nombre2);
		}
	}

	public void ventanaGanador(boolean victoria) {
		if (contMovimientos % 2 == 0 && victoria) {
			Main.vg = new VentanaGanador(nombre1, true);
		} else if (victoria) {
			Main.vg = new VentanaGanador(nombre2, true);
		} else {
			Main.vg = new VentanaGanador("texto", false);
		}
		Main.vg.setResizable(false);
		Main.vg.setVisible(true);
	}

	private void reproducirAudio(String path) {
		try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path))) {
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error al reproducir el audio: " + ex.getMessage());
		}
	}
}