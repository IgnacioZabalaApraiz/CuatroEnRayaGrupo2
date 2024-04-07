package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.Main;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ScrollPaneConstants;

public class VentanaResultados extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaResultados(String jugador1, String jugador2, String color1, String color2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(45, 109, 223));
		addWindowListener(this);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 0, 50, 0};
		gbl_contentPane.rowHeights = new int[]{100, 0, 80, 20, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{257, 0};
		gbl_panel.rowHeights = new int[]{56, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel titulo = new JLabel("RESULTADOS");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Kristen ITC", Font.BOLD, 33));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 0;
		panel.add(titulo, gbc_titulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(null);
		panelResultados.setBackground(new Color(45, 109, 223));
		scrollPane.setViewportView(panelResultados);
		GridBagLayout gbl_panelResultados = new GridBagLayout();
		gbl_panelResultados.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelResultados.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelResultados.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelResultados.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelResultados.setLayout(gbl_panelResultados);
		
		JLabel lbJugador = new JLabel("JUGADOR");
		lbJugador.setForeground(new Color(255, 255, 255));
		lbJugador.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelResultados.add(lbJugador, gbc_lblNewLabel);
		
		JLabel lbVitorias = new JLabel("VICTORIAS");
		lbVitorias.setForeground(Color.WHITE);
		lbVitorias.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panelResultados.add(lbVitorias, gbc_lblNewLabel_1);
		
		JLabel lbEmpates = new JLabel("EMPATES");
		lbEmpates.setForeground(Color.WHITE);
		lbEmpates.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panelResultados.add(lbEmpates, gbc_lblNewLabel_2);
		
		JLabel lbDerrotas = new JLabel("DERROTAS");
		lbDerrotas.setForeground(Color.WHITE);
		lbDerrotas.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 0;
		panelResultados.add(lbDerrotas, gbc_lblNewLabel_4);
		
		JLabel lbPuntuacion = new JLabel("PUNTUACIÓN");
		lbPuntuacion.setForeground(Color.WHITE);
		lbPuntuacion.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 0;
		panelResultados.add(lbPuntuacion, gbc_lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton botonJugarOtravez = new JButton("OTRA VEZ");
		botonJugarOtravez.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Se resetea el tablero
				for (int i = 0; i < Main.tablero.length; i++) {
					for (int j = 0; j < Main.tablero[i].length; j++) {
						Main.tablero[i][j] = 0;
					}
				}
				Main.vr.dispose();
				Main.vt = new VentanaTablero(jugador1, jugador2, color1, color2);
				Main.vt.setVisible(true);
			}
		});
		botonJugarOtravez.setForeground(Color.WHITE);
		botonJugarOtravez.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		botonJugarOtravez.setBackground(new Color(22, 66, 148));
		GridBagConstraints gbc_botonJugarOtravez = new GridBagConstraints();
		gbc_botonJugarOtravez.anchor = GridBagConstraints.SOUTH;
		gbc_botonJugarOtravez.insets = new Insets(0, 0, 0, 5);
		gbc_botonJugarOtravez.gridx = 0;
		gbc_botonJugarOtravez.gridy = 0;
		panel_1.add(botonJugarOtravez, gbc_botonJugarOtravez);
		
		JButton botonElegirJugadores = new JButton("ELEGIR JUGADORES");
		botonElegirJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Main.vr.dispose();
				Main.vi = new VentanaInicio();
				Main.vi.setVisible(true);
			}
		});
		botonElegirJugadores.setForeground(Color.WHITE);
		botonElegirJugadores.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		botonElegirJugadores.setBackground(new Color(22, 66, 148));
		GridBagConstraints gbc_botonElegirJugadores = new GridBagConstraints();
		gbc_botonElegirJugadores.anchor = GridBagConstraints.SOUTH;
		gbc_botonElegirJugadores.insets = new Insets(0, 0, 0, 5);
		gbc_botonElegirJugadores.gridx = 1;
		gbc_botonElegirJugadores.gridy = 0;
		panel_1.add(botonElegirJugadores, gbc_botonElegirJugadores);
		
		JButton botonSalir = new JButton("SALIR");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Main.almacenarJugadores();
				Main.vr.dispose();
			}
		});
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		botonSalir.setBackground(new Color(22, 66, 148));
		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.anchor = GridBagConstraints.SOUTH;
		gbc_botonSalir.gridx = 2;
		gbc_botonSalir.gridy = 0;
		panel_1.add(botonSalir, gbc_botonSalir);
		
		if (Main.lj.getJugadores().length > 0) {
			for (int i = 0; i < Main.lj.getJugadores().length; i++) {
				JLabel lbJugador1 = new JLabel(Main.lj.getJugadores()[i].getNombre());
				lbJugador1.setForeground(new Color(255, 255, 255));
				lbJugador1.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
				GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
				gbc_lblNewLabel1.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel1.gridx = 0;
				gbc_lblNewLabel1.gridy = i + 1;
				panelResultados.add(lbJugador1, gbc_lblNewLabel1);
				
				JLabel lbVitorias1 = new JLabel(String.valueOf(Main.lj.getJugadores()[i].getNumVictorias()));
				lbVitorias1.setForeground(Color.WHITE);
				lbVitorias1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
				gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_11.gridx = 1;
				gbc_lblNewLabel_11.gridy = i + 1;
				panelResultados.add(lbVitorias1, gbc_lblNewLabel_11);
				
				JLabel lbEmpates1 = new JLabel(String.valueOf(Main.lj.getJugadores()[i].getNumEmpates()));
				lbEmpates1.setForeground(Color.WHITE);
				lbEmpates1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
				gbc_lblNewLabel_21.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_21.gridx = 2;
				gbc_lblNewLabel_21.gridy = i + 1;
				panelResultados.add(lbEmpates1, gbc_lblNewLabel_21);
				
				JLabel lbDerrotas1 = new JLabel(String.valueOf(Main.lj.getJugadores()[i].getNumDerrotas()));
				lbDerrotas1.setForeground(Color.WHITE);
				lbDerrotas1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_41 = new GridBagConstraints();
				gbc_lblNewLabel_41.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_41.gridx = 3;
				gbc_lblNewLabel_41.gridy = i + 1;
				panelResultados.add(lbDerrotas1, gbc_lblNewLabel_41);
				
				JLabel lbPuntuacion1 = new JLabel(String.valueOf(Main.lj.getJugadores()[i].getPuntuacion()));
				lbPuntuacion1.setForeground(Color.WHITE);
				lbPuntuacion1.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
				GridBagConstraints gbc_lblNewLabel_51 = new GridBagConstraints();
				gbc_lblNewLabel_51.gridx = 4;
				gbc_lblNewLabel_51.gridy = i + 1;
				panelResultados.add(lbPuntuacion1, gbc_lblNewLabel_51);
			}
		} else {
			JLabel lbSinRegistros = new JLabel("Sin jugadores registrados");
			lbSinRegistros.setForeground(Color.WHITE);
			lbSinRegistros.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
			GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
			gbc_lblNewLabel_21.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_21.gridx = 2;
			gbc_lblNewLabel_21.gridy = 1;
			panelResultados.add(lbSinRegistros, gbc_lblNewLabel_21);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Main.almacenarJugadores();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
