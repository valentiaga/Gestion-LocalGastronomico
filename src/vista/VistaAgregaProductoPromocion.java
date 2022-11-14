package vista;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import modelo.Enumerados.diasDePromo;
import modelo.Producto;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaAgregaProductoPromocion extends JPanel implements IVistaAgregaProductoPromocion{
	private JTextField textFieldCantMinima;
	private JTextField textFieldPrecioUnitarioConDescuento;

	/**
	 * Create the panel.
	 */
	public VistaAgregaProductoPromocion() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agrega Promocion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_18 = new JPanel();
		panel.add(panel_18);
		
		JLabel lblNewLabel = new JLabel("Producto");
		panel_18.add(lblNewLabel);
		
		JPanel panel_19 = new JPanel();
		panel.add(panel_19);
		
		JComboBox comboBoxProductos = new JComboBox();
		panel_19.add(comboBoxProductos);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_15 = new JPanel();
		panel_1.add(panel_15);
		
		JLabel lblNewLabel_1 = new JLabel("Aplica 2x1");
		panel_15.add(lblNewLabel_1);
		
		JPanel panel_13 = new JPanel();
		panel_1.add(panel_13);
		
		JComboBox comboBox2x1 = new JComboBox<String>();
		panel_13.add(comboBox2x1);
		comboBox2x1.setEditable(true);
		comboBox2x1.addItem("Si");
		comboBox2x1.addItem("No");
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		
		JLabel lblNewLabel_2 = new JLabel("Aplica descuento por cantidad");
		panel_12.add(lblNewLabel_2);
		
		JPanel panel_14 = new JPanel();
		panel_2.add(panel_14);
		
		JComboBox comboBoxDescuentoPorCantidad = new JComboBox<String>();
		panel_14.add(comboBoxDescuentoPorCantidad);
		comboBoxDescuentoPorCantidad.setEditable(true);
		comboBoxDescuentoPorCantidad.addItem("Si");
		comboBoxDescuentoPorCantidad.addItem("No");
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		JLabel lblNewLabel_3 = new JLabel(" Cantidad minima");
		panel_11.add(lblNewLabel_3);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		textFieldCantMinima = new JTextField();
		panel_10.add(textFieldCantMinima);
		textFieldCantMinima.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		JLabel lblNewLabel_4 = new JLabel("Precio Unitario con descuento");
		panel_8.add(lblNewLabel_4);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		textFieldPrecioUnitarioConDescuento = new JTextField();
		panel_9.add(textFieldPrecioUnitarioConDescuento);
		textFieldPrecioUnitarioConDescuento.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		JButton btnVolver = new JButton("Volver");
		panel_6.add(btnVolver);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);

		JButton btnConfimar =new JButton("Confimar");
		panel_7.add(btnConfimar);
		
		
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
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

	@Override
	public int getIdProm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAplica2x1() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAplicaDtoPorCant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDtoPorCant_CantMinima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDtoPorCant_PrecioUnitario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getActiva() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public diasDePromo getDiasDePromo() {
		// TODO Auto-generated method stub
		return null;
	}

}
