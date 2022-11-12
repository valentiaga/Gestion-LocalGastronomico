package vista;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class VistaGestionProductoAdmin extends JPanel implements IVistaGestionProductoAdmin {

	private JButton btnModificaProducto;
	private JButton btnAgregaProducto;
	private JButton btnEliminaProducto;
	private JButton btnVolver;
	private ActionListener actionListener;
	/**
	 * Create the panel.
	 */
	public VistaGestionProductoAdmin() {
		setBorder(new TitledBorder(null, "Gestion Productos Operario", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		setLayout(new GridLayout(4, 1, 0, 0));
		JPanel panel = new JPanel();
		add(panel);
		btnModificaProducto = new JButton("Modifica Producto");
		btnModificaProducto.setActionCommand("MODIFICA");
		panel.add(btnModificaProducto);
		JPanel panel_1 = new JPanel();
		add(panel_1);
		btnAgregaProducto = new JButton("Agregar Producto");
		btnAgregaProducto.setActionCommand("AGREGA");
		panel_1.add(btnAgregaProducto);
		JPanel panel_2 = new JPanel();
		add(panel_2);
		btnEliminaProducto = new JButton("Eliminar Producto");
		btnEliminaProducto.setActionCommand("ELIMINA");
		panel_2.add(btnEliminaProducto);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel_3.add(btnVolver);

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnAgregaProducto.addActionListener(actionListener);
		this.btnEliminaProducto.addActionListener(actionListener);
		this.btnModificaProducto.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}

}
