package vista;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class VentanaTablero extends JFrame {

	private static final long serialVersionUID = 1L;
	private TableroPanel panel;

	public VentanaTablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new TableroPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
