package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaGestionPromociones extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public VistaGestionPromociones() {
		setBorder(new TitledBorder(null, "Gestion de Promociones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JButton btnAgregarProdProm = new JButton("Agregar promocion");
		panel_8.add(btnAgregarProdProm);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		
		JButton btnNewButton = new JButton("Modificar promocion");
		panel_9.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Id promocion");
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		
		JButton btnNewButton_1 = new JButton("Eliminar promocion");
		panel_10.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id promocion");
		panel_2.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		JButton btnNewButton_2 = new JButton("Agregar promocion temporal");
		panel_11.add(btnNewButton_2);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		
		JButton btnNewButton_3 = new JButton("Modificar promocion temporal");
		panel_12.add(btnNewButton_3);
		
		JLabel lblNombrePromocion = new JLabel("Nombre promocion");
		panel_4.add(lblNombrePromocion);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_4.add(textField_3);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JButton btnNewButton_4 = new JButton("Eliminar promocion temporal");
		panel_13.add(btnNewButton_4);
		
		JLabel lblNombrePromocion_1 = new JLabel("Nombre promocion");
		panel_5.add(lblNombrePromocion_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_5.add(textField_4);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		
		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14);
		
		JButton btnVolver = new JButton("Volver");
		panel_14.add(btnVolver);

	}

}
