package vista;

import javax.swing.JPanel;
import javax.swing.JButton;

public class VistaGestionProductoOp extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaGestionProductoOp() {
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnNewButton = new JButton("Modifica Producto");
		add(btnNewButton);

	}

}
