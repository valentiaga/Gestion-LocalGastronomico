package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VistaModificaProducto extends JPanel implements IVistaModificaProducto{
	

	private JTextField textFieldNyA;
	private JTextField textFieldCantHijos;
	private JTextField textFieldFecha;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ActionListener actionListener;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public VistaModificaProducto () {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modifica Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		//comboBox.addItemListener(this);
		
		JLabel lblNombre = new JLabel("Nombre del producto");
		panel_1.add(lblNombre);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblCosto = new JLabel("Costo del producto");
		panel_2.add(lblCosto);
		
		textFieldNyA = new JTextField();
		panel_2.add(textFieldNyA);
		textFieldNyA.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblPrecioVenta = new JLabel("Precio de venta ");
		panel_3.add(lblPrecioVenta);
		
		textFieldCantHijos = new JTextField();
		panel_3.add(textFieldCantHijos);
		textFieldCantHijos.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblStock = new JLabel("Stock ");
		panel_4.add(lblStock);
		
		textFieldFecha = new JTextField();
		panel_4.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand("CONFIRMAR");
		panel_5.add(btnConfirmar);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel_6.add(btnVolver);

	}

	@Override
	public int getidProd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPrecioCosto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPrecioVenta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStockInicial() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAcionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		// TODO Auto-generated method stub
		
	}

}
