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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VistaGestionProductoAdmin extends JPanel implements IVistaGestionProductoAdmin {
	
	private ActionListener actionListener;
	private JTextField textFieldIdProducto;
	private JButton btnModificaProducto;
	private JButton btnAgregaProducto;
	private JButton btnEliminaProducto;
	private JButton btnVolver;
	
	/**
	 * Create the panel.
	 */
	public VistaGestionProductoAdmin() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gestion Productos Admin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		this.btnModificaProducto = new JButton("Modifica Producto");
		panel_7.add(btnModificaProducto);
		btnModificaProducto.setActionCommand("MODIFICA");
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		this.btnEliminaProducto = new JButton("Eliminar Producto");
		panel_2.add(btnEliminaProducto);
		btnEliminaProducto.setActionCommand("ELIMINA");
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		this.btnAgregaProducto = new JButton("Agregar Producto");
		panel_3.add(btnAgregaProducto);
		btnAgregaProducto.setActionCommand("AGREGA");
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		this.btnVolver = new JButton("Volver");
		panel_10.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		
		this.actionListener = actionListener;
		this.btnAgregaProducto.addActionListener(actionListener);
		this.btnModificaProducto.addActionListener(actionListener);
		this.btnEliminaProducto.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		
		
	}

	@Override
	public void limpiarVista() {
		this.textFieldIdProducto.setText("");
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	@Override
	public int getIdProd() {
		int id=-1;
		try {
			id = Integer.parseInt(this.textFieldIdProducto.getText());
		}
		catch (NumberFormatException e2) {
		}
		return id;
	}

}
