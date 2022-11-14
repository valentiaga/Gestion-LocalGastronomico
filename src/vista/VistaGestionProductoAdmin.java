package vista;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaGestionProductoAdmin extends JPanel implements IVistaGestionProductoAdmin {
	private ActionListener actionListener;
	private JTextField textFieldIdProducto;
	/**
	 * Create the panel.
	 */
	public VistaGestionProductoAdmin() {
		setBorder(new TitledBorder(null, "Gestion Productos Operario", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		setLayout(new GridLayout(5, 1, 0, 0));
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblIdProducto = new JLabel("Id del producto");
		panel_5.add(lblIdProducto);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		textFieldIdProducto = new JTextField();
		panel_6.add(textFieldIdProducto);
		textFieldIdProducto.setColumns(10);
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnModificaProducto = new JButton("Modifica Producto");
		btnModificaProducto.setActionCommand("MODIFICA");
		panel_1.add(btnModificaProducto);
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JButton btnAgregaProducto = new JButton("Agregar Producto");
		btnAgregaProducto.setActionCommand("AGREGA");
		panel_2.add(btnAgregaProducto);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JButton btnEliminaProducto = new JButton("Eliminar Producto");
		btnEliminaProducto.setActionCommand("ELIMINA");
		panel_3.add(btnEliminaProducto);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel_4.add(btnVolver);

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
//		this.btnAgregaProducto.addActionListener(actionListener);
//		this.btnEliminaProducto.addActionListener(actionListener);
//		this.btnModificaProducto.addActionListener(actionListener);
//		this.btnVolver.addActionListener(actionListener);
//		this.actionListener = actionListener;
		
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIdProd() {
		// TODO Auto-generated method stub
		return 0;
	}

}
