package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaGestionProductoOp extends JPanel implements IVistaGestionProductoOp{
	private JButton btnModificaProducto;
	private JButton btnVolver;
	private ActionListener actionListener;
	/**
	 * Create the panel.
	 */
	public VistaGestionProductoOp() {
		setBorder(new TitledBorder(null, "Gestion Productos Operario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		btnModificaProducto = new JButton("Modifica Producto");
		btnModificaProducto.setActionCommand("MODIFICAR");
		panel_4.add(btnModificaProducto);
		
		JPanel panel = new JPanel();
		add(panel);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel.add(btnVolver);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnModificaProducto.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;	
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,mensaje );
	}

}