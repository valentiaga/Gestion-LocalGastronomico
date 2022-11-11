package vista;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class VistaGestionProductoAdmin extends JPanel implements IVistaGestionProductoAdmin {

	/**
	 * Create the panel.
	 */
	public VistaGestionProductoAdmin() {
		setBorder(new TitledBorder(null, "Gestion Productos Operario", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		setLayout(new GridLayout(3, 1, 0, 0));
		JPanel panel = new JPanel();
		add(panel);
		JButton btnModificaProducto = new JButton("Modifica Producto");
		panel.add(btnModificaProducto);
		JPanel panel_1 = new JPanel();
		add(panel_1);
		JButton btnAgregaProducto = new JButton("Agregar Producto");
		panel_1.add(btnAgregaProducto);
		JPanel panel_2 = new JPanel();
		add(panel_2);
		JButton btnEliminaProducto = new JButton("Eliminar Producto");
		panel_2.add(btnEliminaProducto);

	}

}
