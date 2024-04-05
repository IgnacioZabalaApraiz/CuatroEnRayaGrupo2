package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

import controlador.Main;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JList;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VentanaElegirColor vc;
	private JButton botonColor1;
	private JButton botonColor2;
	private String color1 = "Amarilla";
	private String color2 = "Roja";

	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(45, 109, 223));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 25, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel titulo = new JLabel("4  EN RAYA");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Kristen ITC", Font.BOLD, 33));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 0;
		panel.add(titulo, gbc_titulo);
		
		JLabel jugador1 = new JLabel("Jugador 1");
		jugador1.setForeground(Color.WHITE);
		jugador1.setFont(new Font("Kristen ITC", Font.BOLD, 22));
		GridBagConstraints gbc_jugador1 = new GridBagConstraints();
		gbc_jugador1.anchor = GridBagConstraints.SOUTH;
		gbc_jugador1.insets = new Insets(0, 0, 5, 5);
		gbc_jugador1.gridx = 1;
		gbc_jugador1.gridy = 1;
		contentPane.add(jugador1, gbc_jugador1);
		
		JComboBox nombre1 = new JComboBox();
		nombre1.setEditable(true);
		nombre1.setForeground(new Color(45, 109, 223));
		nombre1.setFont(new Font("Kristen ITC", Font.PLAIN, 22));
		GridBagConstraints gbc_nombre1 = new GridBagConstraints();
		gbc_nombre1.insets = new Insets(0, 0, 5, 5);
		gbc_nombre1.fill = GridBagConstraints.BOTH;
		gbc_nombre1.gridx = 1;
		gbc_nombre1.gridy = 2;
		contentPane.add(nombre1, gbc_nombre1);
		
		JPanel panelColor1 = new JPanel();
		panelColor1.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_panelColor1 = new GridBagConstraints();
		gbc_panelColor1.insets = new Insets(0, 0, 5, 0);
		gbc_panelColor1.fill = GridBagConstraints.BOTH;
		gbc_panelColor1.gridx = 2;
		gbc_panelColor1.gridy = 2;
		contentPane.add(panelColor1, gbc_panelColor1);
		GridBagLayout gbl_panelColor1 = new GridBagLayout();
		gbl_panelColor1.columnWidths = new int[]{40, 0, 0, 0};
		gbl_panelColor1.rowHeights = new int[]{20, 40, 20, 0};
		gbl_panelColor1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelColor1.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelColor1.setLayout(gbl_panelColor1);
		
		botonColor1 = new JButton("");//------------------------------------------------------------------------------------------------------------------
		botonColor1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				vc = new VentanaElegirColor(1);
				vc.setVisible(true);
			}
		});
		botonColor1.setBackground(new Color(255, 255, 0));
		GridBagConstraints gbc_botonColor1 = new GridBagConstraints();
		gbc_botonColor1.fill = GridBagConstraints.BOTH;
		gbc_botonColor1.insets = new Insets(0, 0, 5, 5);
		gbc_botonColor1.gridx = 0;
		gbc_botonColor1.gridy = 1;
		panelColor1.add(botonColor1, gbc_botonColor1);
		
		JLabel jugador2 = new JLabel("Jugador 2");
		jugador2.setForeground(Color.WHITE);
		jugador2.setFont(new Font("Kristen ITC", Font.BOLD, 22));
		GridBagConstraints gbc_jugador2 = new GridBagConstraints();
		gbc_jugador2.anchor = GridBagConstraints.SOUTH;
		gbc_jugador2.insets = new Insets(0, 0, 5, 5);
		gbc_jugador2.gridx = 1;
		gbc_jugador2.gridy = 3;
		contentPane.add(jugador2, gbc_jugador2);
		
		JComboBox nombre2 = new JComboBox();
		nombre2.setForeground(new Color(45, 109, 223));
		nombre2.setFont(new Font("Kristen ITC", Font.PLAIN, 22));
		nombre2.setEditable(true);
		GridBagConstraints gbc_nombre2 = new GridBagConstraints();
		gbc_nombre2.insets = new Insets(0, 0, 5, 5);
		gbc_nombre2.fill = GridBagConstraints.BOTH;
		gbc_nombre2.gridx = 1;
		gbc_nombre2.gridy = 4;
		contentPane.add(nombre2, gbc_nombre2);
		
		JPanel panelColor1_1 = new JPanel();
		panelColor1_1.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_panelColor1_1 = new GridBagConstraints();
		gbc_panelColor1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panelColor1_1.fill = GridBagConstraints.BOTH;
		gbc_panelColor1_1.gridx = 2;
		gbc_panelColor1_1.gridy = 4;
		contentPane.add(panelColor1_1, gbc_panelColor1_1);
		GridBagLayout gbl_panelColor1_1 = new GridBagLayout();
		gbl_panelColor1_1.columnWidths = new int[]{40, 0, 0, 0};
		gbl_panelColor1_1.rowHeights = new int[]{20, 40, 20, 0};
		gbl_panelColor1_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelColor1_1.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelColor1_1.setLayout(gbl_panelColor1_1);
		
		botonColor2 = new JButton("");//------------------------------------------------------------------------------------------------------------------
		botonColor2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				vc = new VentanaElegirColor(2);
				vc.setVisible(true);
			}
		});
		botonColor2.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_botonColor2 = new GridBagConstraints();
		gbc_botonColor2.fill = GridBagConstraints.BOTH;
		gbc_botonColor2.insets = new Insets(0, 0, 5, 5);
		gbc_botonColor2.gridx = 0;
		gbc_botonColor2.gridy = 1;
		panelColor1_1.add(botonColor2, gbc_botonColor2);
		
		JPanel panelDificultad = new JPanel();
		panelDificultad.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true), "Dificultad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelDificultad.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_panelDificultad = new GridBagConstraints();
		gbc_panelDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_panelDificultad.fill = GridBagConstraints.BOTH;
		gbc_panelDificultad.gridx = 1;
		gbc_panelDificultad.gridy = 6;
		contentPane.add(panelDificultad, gbc_panelDificultad);
		GridBagLayout gbl_panelDificultad = new GridBagLayout();
		gbl_panelDificultad.columnWidths = new int[]{53, 0, 0, 0};
		gbl_panelDificultad.rowHeights = new int[]{25, 0};
		gbl_panelDificultad.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelDificultad.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDificultad.setLayout(gbl_panelDificultad);
		
		ButtonGroup grupo = new ButtonGroup();
		JRadioButton radioFacil = new JRadioButton("Fácil");
		JRadioButton radioNormal = new JRadioButton("Normal");
		radioNormal.setSelected(true);
		JRadioButton radioDificil = new JRadioButton("Difícil");
		
		grupo.add(radioFacil);
        grupo.add(radioNormal);
        grupo.add(radioDificil);
        
		radioFacil.setForeground(new Color(255, 255, 255));
		radioFacil.setBackground(new Color(45, 109, 223));
		radioFacil.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		GridBagConstraints gbc_radioFacil = new GridBagConstraints();
		gbc_radioFacil.insets = new Insets(0, 0, 0, 5);
		gbc_radioFacil.gridx = 0;
		gbc_radioFacil.gridy = 0;
		panelDificultad.add(radioFacil, gbc_radioFacil);
		
		radioNormal.setForeground(Color.WHITE);
		radioNormal.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		radioNormal.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_radioNormal = new GridBagConstraints();
		gbc_radioNormal.insets = new Insets(0, 0, 0, 5);
		gbc_radioNormal.gridx = 1;
		gbc_radioNormal.gridy = 0;
		panelDificultad.add(radioNormal, gbc_radioNormal);
		
		radioDificil.setForeground(Color.WHITE);
		radioDificil.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		radioDificil.setBackground(new Color(45, 109, 223));
		GridBagConstraints gbc_radioDificil = new GridBagConstraints();
		gbc_radioDificil.gridx = 2;
		gbc_radioDificil.gridy = 0;
		panelDificultad.add(radioDificil, gbc_radioDificil);
		
		JButton botonJugar = new JButton("¡JUGAR!");
		botonJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (radioFacil.isSelected()) {
					Main.tablero = new int[4][5];
				} else if (radioNormal.isSelected()) {
					Main.tablero = new int[6][7];
				} else if (radioDificil.isSelected()) {
					Main.tablero = new int[16][17];
				} else {
					Main.tablero = new int[6][7];// Si hay algun error se pone el normal por defecto
				}
				// Se rellena el tablero de 0
				for (int i = 0; i < Main.tablero.length; i++) {
					for (int j = 0; j < Main.tablero[i].length; j++) {
						Main.tablero[i][j] = 0;
					}
				}
				
				String jugador1;
				String jugador2;
				
				if (nombre1.getSelectedItem() != null) {
					jugador1 = String.valueOf(nombre1.getSelectedItem());
				} else {
					jugador1 = "Jugador1";
				}
				
				if (nombre2.getSelectedItem() != null) {
					jugador2 = String.valueOf(nombre2.getSelectedItem());
				} else {
					jugador2 = "Jugador2";
				}
				
				Main.vt = new VentanaTablero(jugador1, jugador2, color1, color2);
				Main.vt.setVisible(true);
				Main.vi.dispose();
			}
		});
		botonJugar.setForeground(new Color(255, 255, 255));
		botonJugar.setBackground(new Color(27, 80, 180));
		botonJugar.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		GridBagConstraints gbc_botonJugar = new GridBagConstraints();
		gbc_botonJugar.insets = new Insets(0, 0, 0, 5);
		gbc_botonJugar.gridx = 1;
		gbc_botonJugar.gridy = 7;
		contentPane.add(botonJugar, gbc_botonJugar);
	}
	
	public void cambiarColor(int num, int r, int g, int b, String color) {
		if (num == 1) {
			botonColor1.setBackground(new Color(r, g, b));
			color1 = color;
		} else {
			botonColor2.setBackground(new Color(r, g, b));
			color2 = color;
		}
		vc.dispose();
	}

}
