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
	private final int ANCHO_PANEL = 910;
	private final int ALTO_PANEL = 950;
	private final int ANCHO_FICHA = 130;
	private Image[] fichas = new Image[43];
	private Image tableroIMG;
	private JLabel textoTurno;
	private String textoGanador = "";
	private int contMovimientos = 0;
	private Timer timer;
	private int yVelocidad = 25;
	private int x = 0;
	private int y = 0;

	// Constructor
	public TableroPanel() {
		this.setPreferredSize(new Dimension(ANCHO_PANEL, ALTO_PANEL));
		this.setBackground(new Color(16, 71, 169));
		tableroIMG = new ImageIcon("imagenes/tablero7x6.png").getImage();
		timer = new Timer(10, this);
		setLayout(null);// cuidado con esto

		textoTurno = new JLabel("Turno del jugador 1");
		textoTurno.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		textoTurno.setForeground(new Color(255, 255, 255));
		textoTurno.setBounds(300, 860, 372, 91);
		add(textoTurno);

		for (int i = 0; i < 7; i++) {
			final int index = i;
			JButton btnNewButton = new JButton(String.valueOf(i + 1));
			btnNewButton.setFont(new Font("Kristen ITC", Font.BOLD, 32));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(45, 109, 223));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					generarFicha(index);
				}
			});
			btnNewButton.setBounds(15 + ANCHO_FICHA * i, 800, 100, 60);
			add(btnNewButton);
		}
		timer.start();
	}
	
	public void generarFicha(int i) {
		y = 0;
		x = i;
		if (Main.tablero[0][x] == 0) {// solo se genere una ficha si quedan huecos en la columna
			if (contMovimientos % 2 == 0) {
				fichas[contMovimientos] = new ImageIcon("imagenes/fichaAmarillaBuena.png").getImage();
			} else {
				fichas[contMovimientos] = new ImageIcon("imagenes/fichaRojaBuena.png").getImage();
			}
		}
	}

	// Se ejecuta al principio al iniciar la ventana y luego cada vez que se ejecuta el repaint()
	public void paint(Graphics g) {

		super.paint(g); // necesario para sobreescribir cada frame

		Graphics2D g2D = (Graphics2D) g;

		// Se pintan las fichas que estan guardadas en el array tablero
		for (int i = 0; i < Main.tablero.length; i++) {
			for (int j = 0; j < Main.tablero[0].length; j++) {
				if (Main.tablero[i][j] == 1) {
					g2D.drawImage(new ImageIcon("imagenes/fichaAmarillaBuena.png").getImage(), j * ANCHO_FICHA,
							i * ANCHO_FICHA, null);
				} else if (Main.tablero[i][j] == 2) {
					g2D.drawImage(new ImageIcon("imagenes/fichaRojaBuena.png").getImage(), j * ANCHO_FICHA,
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
	
	// Este metodo se ejecuta automaticamente dependiendo de la configuracion del Timer
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int pos = 5;
		for (int i = 0; i < Main.tablero.length; i++) {
			if (Main.tablero[i][x] != 0) {
				pos = i - 1;
				break;
			}
		}
		if (fichas[contMovimientos] != null && y < 130 * pos) {
			y = y + yVelocidad;
		} else if (fichas[contMovimientos] != null && y >= 130 * pos) {// si termina la animacion se introduce la ficha en el array tablero
			if (contMovimientos % 2 == 0) {
				Main.tablero[pos][x] = 1;
			} else {
				Main.tablero[pos][x] = 2;
			}
			// INTRODUCIR AUDIO DE LAS FICHAS
			try {
				AudioInputStream audioInputStream = AudioSystem
						.getAudioInputStream(new File("imagenes/audioFicha.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch (Exception ex) {
				System.out.println("Error al reproducir el audio: " + ex.getMessage());
			}
			
			// Detectar si ha habido 4 en raya
			if (Main.juegoCompleto()) {
				textoGanador();
			}
			contMovimientos++;
			cambiarNombre();
		}
		repaint();

	}

	// Cambiar el nombre del jugador que le toca cada turno
	public void cambiarNombre() {
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
}