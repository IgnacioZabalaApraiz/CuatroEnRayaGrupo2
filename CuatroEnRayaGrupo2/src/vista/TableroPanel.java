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
	private Image fichaAmarilla;
	private Image fichaRoja;
	private JLabel textoTurno;
	private String textoGanador = "";
	private int contMovimientos = 0;
	private Timer timer;
	private int yVelocidad = 25;
	private int x = 0;
	private int y = 0;

	// Constructor
	public TableroPanel() {
		// Setear las constantes dependiendo del tamaño del tablero
		COLUMNAS = Main.tablero[0].length;
		FILAS = Main.tablero.length;
		if (COLUMNAS != 17) {
			ANCHO_FICHA = 130;
			fichaAmarilla = new ImageIcon("imagenes/fichaAmarilla.png").getImage();
			fichaRoja = new ImageIcon("imagenes/fichaRoja.png").getImage();
		} else {
			ANCHO_FICHA = 54;
			fichaAmarilla = new ImageIcon("imagenes/fichaAmarillaPequena.png").getImage();
			fichaRoja = new ImageIcon("imagenes/fichaRojaPequena.png").getImage();
		}
		tableroIMG = new ImageIcon("imagenes/tablero" + COLUMNAS + "x" + FILAS + ".png").getImage();
		ANCHO_PANEL = COLUMNAS * ANCHO_FICHA;
		ALTO_PANEL = FILAS * ANCHO_FICHA + 170;
		fichas = new Image[COLUMNAS * FILAS + 1];
		
		this.setPreferredSize(new Dimension(ANCHO_PANEL, ALTO_PANEL));
		this.setBackground(new Color(16, 71, 169));
		timer = new Timer(10, this);
		setLayout(null);// Para poder poner los elementos en cualquier parte del panel

		textoTurno = new JLabel("Turno del jugador 1");
		textoTurno.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		textoTurno.setForeground(new Color(255, 255, 255));
		if (COLUMNAS == 5) {
			textoTurno.setBounds(150, ALTO_PANEL - 90, 372, 91);
		} else {
			textoTurno.setBounds(300, ALTO_PANEL - 90, 372, 91);
		}
		add(textoTurno);

		// Bucle para crear los botones
		for (int i = 0; i < COLUMNAS; i++) {
			final int index = i;
			JButton btnNewButton = new JButton(String.valueOf(i + 1));
			btnNewButton.setFont(new Font("Kristen ITC", Font.BOLD, ANCHO_FICHA / 4));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(45, 109, 223));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					generarFicha(index);
				}
			});
			if (COLUMNAS != 17) {
				btnNewButton.setBounds(15 + ANCHO_FICHA * i, ALTO_PANEL - 150, 100, 60);
			} else {
				btnNewButton.setBounds(2 + ANCHO_FICHA * i, ALTO_PANEL - 150, 50, 40);
			}
			add(btnNewButton);
		}
		timer.start();
	}
	
	public void generarFicha(int i) {
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
	
	public void paint(Graphics g) {// Se ejecuta al principio al iniciar la ventana y luego cada vez que se ejecuta el repaint()

		super.paint(g); // Necesario para sobrescribir cada frame

		Graphics2D g2D = (Graphics2D) g;

		// Se pintan las fichas que estan guardadas en el array tablero
		for (int i = 0; i < Main.tablero.length; i++) {
			for (int j = 0; j < Main.tablero[0].length; j++) {
				if (Main.tablero[i][j] == 1) {
					g2D.drawImage(fichaAmarilla, j * ANCHO_FICHA,
							i * ANCHO_FICHA, null);
				} else if (Main.tablero[i][j] == 2) {
					g2D.drawImage(fichaRoja, j * ANCHO_FICHA,
							i * ANCHO_FICHA, null);
				}
			}
		}
		// Se pinta la ficha nueva en movimiento
		g2D.drawImage(fichas[contMovimientos], x * ANCHO_FICHA, y, null);
		// Se pinta el tablero
		g2D.drawImage(tableroIMG, 0, 0, null);
		// Se pinta el texto del ganador
		g2D.setFont(new Font("Kristen ITC", Font.BOLD, 48));
	    g2D.setColor(new Color(255, 255, 255));
	    g2D.drawString(textoGanador, 150, 400);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {// Este metodo se ejecuta automaticamente dependiendo de la configuracion del Timer
		int pos = FILAS - 1;
		for (int i = 0; i < FILAS; i++) {
			if (Main.tablero[i][x] != 0) {
				pos = i - 1;
				break;
			}
		}
		if (fichas[contMovimientos] != null && y < ANCHO_FICHA * pos) {
			y += yVelocidad;
		} else if (fichas[contMovimientos] != null && y >= ANCHO_FICHA * pos) {// Si termina la animacion se introduce la ficha en el array tablero
			if (contMovimientos % 2 == 0) {
				Main.tablero[pos][x] = 1;
			} else {
				Main.tablero[pos][x] = 2;
			}

			reproducirAudio("imagenes/audioFicha.wav");
			
			// Detectar si ha habido 4 en raya
			if (Main.juegoCompleto()) {
				textoGanador();
			}
			contMovimientos++;
			cambiarNombre();
		}
		repaint();

	}

	public void cambiarNombre() {// Cambiar el nombre del jugador que le toca cada turno
		if (contMovimientos % 2 == 0) {
			textoTurno.setText("Turno del jugador 1");
		} else {
			textoTurno.setText("Turno del jugador 2");
		}
	}
	
	public void textoGanador() {
		if (contMovimientos % 2 == 0) {
			textoGanador = "GANA EL JUGADOR 1";
		} else {
			textoGanador = "GANA EL JUGADOR 2";
		}
		timer.stop();
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