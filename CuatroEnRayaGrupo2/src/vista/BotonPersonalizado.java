package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class BotonPersonalizado extends JButton {

	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
    private Color hoverColor;
    private Color pressedColor;

    public BotonPersonalizado(String text) {
        super(text);
        backgroundColor = new Color(241, 180, 52);
        hoverColor = new Color(102, 178, 255);
        pressedColor = new Color(0, 102, 204);

        setContentAreaFilled(false); // Hacer que el área de contenido no sea rellena para mostrar el color personalizado
        setFocusPainted(false); // No mostrar el borde de enfoque
        setForeground(Color.WHITE); // Establecer el color del texto

        // Establecer un borde redondeado
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        if (getModel().isPressed()) {
            g2d.setColor(pressedColor);
        } else if (getModel().isRollover()) {
            g2d.setColor(hoverColor);
        } else {
            g2d.setColor(backgroundColor);
        }

        // Dibujar un fondo redondeado
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 120, 120));
        super.paintComponent(g2d);
        g2d.dispose();
    }
}