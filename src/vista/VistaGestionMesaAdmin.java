package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

public class VistaGestionMesaAdmin extends JPanel implements IVistaGestionMesaAdmin{
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public VistaGestionMesaAdmin() {
		
		setBorder(new TitledBorder(null, "Gestion Mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar la cantidad de sillas");
		panel_11.add(lblNewLabel_1);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		textField_1 = new JTextField();
		panel_12.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSeteaMozo = new JButton("Setear Mozo");
		panel_2.add(btnSeteaMozo);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JComboBox comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnModificaMesa = new JButton("Modificar Mesa");
		panel_3.add(btnModificaMesa);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JButton btnNewButton = new JButton("Agregar Mesa");
		panel_8.add(btnNewButton);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JButton btnNewButton_1 = new JButton("Eliminar Mesa");
		panel_9.add(btnNewButton_1);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JButton btnCerrarMesa = new JButton("Cerrar Mesa");
		btnCerrarMesa.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_10.add(btnCerrarMesa);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Numero de Mesa");
		panel_6.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
//		setLayout(new GridLayout(0, 1, 0, 0));
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.PINK);
//		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
//		add(panel);
//		
//		JButton btnEliminaMesa = new JButton("Elimina Mesa");
//		panel.add(btnEliminaMesa);
//		
//		JPanel panel_1 = new JPanel();
//		add(panel_1);
//		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
//		
//		JPanel panel_5 = new JPanel();
//		panel_1.add(panel_5);
//		
//		JPanel panel_4 = new JPanel();
//		panel_5.add(panel_4);
//		
//		JLabel lblCantSillas = new JLabel("Ingresar Cantidad de sillas");
//		panel_4.add(lblCantSillas);
//		
//		JPanel panel_3 = new JPanel();
//		panel_5.add(panel_3);
//		
//		textField = new JTextField();
//		textField.setColumns(10);
//		panel_3.add(textField);
//		
//		JPanel panel_2 = new JPanel();
//		panel_1.add(panel_2);
//		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		
//		JButton btnAgregaMesa = new JButton("Agrega Mesa");
//		panel_2.add(btnAgregaMesa);
	}

}