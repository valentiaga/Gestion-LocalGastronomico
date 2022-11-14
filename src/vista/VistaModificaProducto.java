package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import modelo.Producto;
import negocio.Sistema;

public class VistaModificaProducto extends JPanel implements IVistaModificaProducto, KeyListener{
	

	private JTextField textFieldCosto;
	private JTextField textFieldVenta;
	private JTextField textFieldStock;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ActionListener actionListener;
	private JTextField textFieldNombre;
	private JTextField textFieldIdProd;
	/**
	 * Create the panel.
	 */
	public VistaModificaProducto () {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modifica Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Id Prod");
		panel_1.add(lblNewLabel);
		
		textFieldIdProd = new JTextField();
		textFieldIdProd.addKeyListener(this);
		panel_1.add(textFieldIdProd);
		textFieldIdProd.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		//comboBox.addItemListener(this);
		
		JLabel lblNombre = new JLabel("Nombre del producto");
		panel_2.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel_2.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblCosto = new JLabel("Costo del producto");
		panel_3.add(lblCosto);
		
		textFieldCosto = new JTextField();
		panel_3.add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblPrecioVenta = new JLabel("Precio de venta ");
		panel_4.add(lblPrecioVenta);
		
		textFieldVenta = new JTextField();
		panel_4.add(textFieldVenta);
		textFieldVenta.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblStock = new JLabel("Stock ");
		panel_5.add(lblStock);
		
		textFieldStock = new JTextField();
		panel_5.add(textFieldStock);
		textFieldStock.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		btnConfirmar = new JButton("Confirmar");
		panel_6.add(btnConfirmar);
		btnConfirmar.setActionCommand("CONFIRMAR");
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		btnVolver = new JButton("Volver");
		panel_7.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");

	}

	@Override
	public String getNombre() {
		return this.textFieldNombre.getText();
	}

	@Override
	public float getPrecioCosto() {
		float costo=-1;
		try {
			costo = Float.valueOf(this.textFieldCosto.getText());
		}
		catch (NumberFormatException e2) {
		}
		return costo;
	}

	@Override
	public float getPrecioVenta() {
		float venta=-1;
		try {
			venta = Float.valueOf(this.textFieldVenta.getText());
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
		this.textFieldIdProd.setText("");
		this.textFieldNombre.setText("");
		this.textFieldCosto.setText("");
		this.textFieldVenta.setText("");
		this.textFieldStock.setText("");
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	@Override
	public int getIdProd() {
		int id=-1;
		try {
			id = Integer.parseInt(this.textFieldIdProd.getText());
		}
		catch (NumberFormatException e2) {
		}
		return id;
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean condition = this.getIdProd()!=-1;
		if (condition) {
			Producto producto = Sistema.getInstance().getProductos().get(this.getIdProd());
			if (producto!=null) {
				this.textFieldNombre.setText(producto.getNombre());
				this.textFieldCosto.setText(String.valueOf(producto.getPrecioCosto()));
				this.textFieldVenta.setText(String.valueOf(producto.getPrecioVenta()));
				this.textFieldStock.setText(String.valueOf(producto.getStockInicial()));
			}
		}
		else {
			this.textFieldNombre.setText("");
			this.textFieldCosto.setText("");
			this.textFieldVenta.setText("");
			this.textFieldStock.setText("");
		}
	}
	public void keyTyped(KeyEvent e) {
	}
}
