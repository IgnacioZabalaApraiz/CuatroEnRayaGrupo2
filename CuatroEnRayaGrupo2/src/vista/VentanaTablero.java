package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Main;

public class VentanaTablero extends JFrame {

	private static final long serialVersionUID = 1L;
	private TableroPanel panel;

	public VentanaTablero(String nombre1, String nombre2, String color1, String color2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setLayout(new BorderLayout());
        
        int columnas = Main.tablero[0].length;
        int ancho;
        int alto;
        if (columnas != 17) {
        	ancho = columnas * 130;
        	alto = (columnas - 1) * 130;
        } else {
        	ancho = columnas * 54;
        	alto = (columnas - 1) * 54;
        }
        
        Dimension minimumSize = new Dimension(ancho + 16, alto + 170 + 40);
        setMinimumSize(minimumSize);
        
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(new Color(45, 109, 223));

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));
        innerPanel.add(Box.createHorizontalGlue()); // Espacio horizontal izquierdo
        panel = new TableroPanel(nombre1, nombre2, color1, color2);
        innerPanel.add(panel);
        innerPanel.add(Box.createHorizontalGlue()); // Espacio horizontal derecho

        outerPanel.add(innerPanel);

        add(outerPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
	}

}
