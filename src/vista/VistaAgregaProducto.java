package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VistaAgregaProducto extends JPanel implements IVistaAgregaProducto{
	
	private JTextField textFieldCosto;
	private JTextField textFieldVenta;
	private JTextField textFieldStock;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ActionListener actionListener;
	private JTextField textFieldNombre;
	/**
	 * Create the panel.
	 */
	public VistaAgregaProducto () {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agrega Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		//comboBox.addItemListener(this);
		
		JLabel lblNombre = new JLabel("Nombre del producto");
		panel_1.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblCosto = new JLabel("Costo del producto");
		panel_2.add(lblCosto);
		
		textFieldCosto = new JTextField();
		panel_2.add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblPrecioVenta = new JLabel("Precio de venta ");
		panel_3.add(lblPrecioVenta);
		
		textFieldVenta = new JTextField();
		panel_3.add(textFieldVenta);
		textFieldVenta.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblStock = new JLabel("Stock inicial");
		panel_4.add(lblStock);
		
		textFieldStock = new JTextField();
		panel_4.add(textFieldStock);
		textFieldStock.setColumns(10);
		
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
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.textFieldNombre.getText();
	}

	@Override
	public float getPrecioCosto() {
		float costo=-1;
		try {
			costo = Float.parseFloat(this.textFieldCosto.getText());
		}
		catch (NumberFormatException e2) {
		}
		return costo;
	}

	@Override
	public float getPrecioVenta() {
		float venta=-1;
		try {
			venta = Float.parseFloat(this.textFieldVenta.getText());
		}
		catch (NumberFormatException e2) {
		}
		return venta;
	}

	@Override
	public int getStockInicial() {
		int stock=-1;
		try {
			stock = Integer.parseInt(this.textFieldStock.getText());
		}
		catch (NumberFormatException e2) {
		}
		return stock;
	}

	@Override
	public void addAcionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}

	@Override
	public void limpiarVista() {
		this.textFieldCosto.setText("");
		this.textFieldVenta.setText("");
		this.textFieldStock.setText("");
		this.textFieldNombre.setText("");
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
