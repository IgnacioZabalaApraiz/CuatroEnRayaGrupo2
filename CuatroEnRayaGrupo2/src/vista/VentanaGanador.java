package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Main;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaGanador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image fondo;

	public VentanaGanador(String nombre, boolean victoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 240);
        setLocationRelativeTo(null);
        fondo = new ImageIcon("imagenes/cuadroGanador.png").getImage();
        
        contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
            }
        };
        
        contentPane.setLayout(null); // Usamos un layout nulo para poder establecer la posición de los componentes manualmente
        setContentPane(contentPane);
        
        reproducirAudio("imagenes/audioVictoria.wav");

        if (victoria) {
            JLabel textoGanador = new JLabel("EL GANADOR ES:");
            textoGanador.setFont(new Font("Kristen ITC", Font.BOLD, 26));
            int xTextoGanador = (420 - textoGanador.getPreferredSize().width) / 2;
            textoGanador.setBounds(xTextoGanador, 25, textoGanador.getPreferredSize().width, 50);
            contentPane.add(textoGanador);

            JLabel nombreGanador = new JLabel(nombre);
            nombreGanador.setFont(new Font("Kristen ITC", Font.BOLD, 26));
            int xNombreGanador = (420 - nombreGanador.getPreferredSize().width) / 2;
            nombreGanador.setBounds(xNombreGanador, 75, nombreGanador.getPreferredSize().width, 50);
            contentPane.add(nombreGanador);
        } else {
            JLabel textoEmpate = new JLabel("¡EMPATE!");
            textoEmpate.setFont(new Font("Kristen ITC", Font.BOLD, 32));
            int xTextoEmpate = (420 - textoEmpate.getPreferredSize().width) / 2;
            textoEmpate.setBounds(xTextoEmpate, 40, textoEmpate.getPreferredSize().width, 50);
            contentPane.add(textoEmpate);
        }

        JButton boton = new JButton("CONTINUAR");
        boton.setFont(new Font("Kristen ITC", Font.BOLD, 17));
        boton.setBackground(new Color(0, 0, 0));
        boton.setForeground(new Color(255, 255, 255));
        int xBoton = (420 - boton.getPreferredSize().width) / 2;
        boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Main.vt.dispose();
				Main.vg.dispose();
			}
		});
        boton.setBounds(xBoton, 137, boton.getPreferredSize().width, 35);
        contentPane.add(boton);
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
