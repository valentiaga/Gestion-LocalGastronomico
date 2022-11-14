package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VistaAgregarPromocionTemporal extends JPanel {
	
	private JTextField textFieldNombre;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBoxDiaDePromo;
	private JComboBox comboBoxFormaDePago;

	/**
	 * Create the panel.
	 */
	public VistaAgregarPromocionTemporal() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agregar Promocion Temporal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(9, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JLabel lblNewLabel = new JLabel("Nombre de la promocion");
		panel_9.add(lblNewLabel);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		textFieldNombre = new JTextField();
		panel_10.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("Dia de promocion");
		panel_11.add(lblNewLabel_1);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		comboBoxDiaDePromo = new JComboBox();
		comboBoxDiaDePromo.setEditable(true);
		panel_12.add(comboBoxDiaDePromo);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		
		JLabel lblNewLabel_2 = new JLabel("Forma de pago");
		panel_13.add(lblNewLabel_2);
		
		JPanel panel_14 = new JPanel();
		panel_2.add(panel_14);
		
		comboBoxFormaDePago = new JComboBox();
		comboBoxFormaDePago.setEditable(true);
		panel_14.add(comboBoxFormaDePago);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		
		JLabel lblNewLabel_6 = new JLabel("Promocion activa");
		panel_15.add(lblNewLabel_6);
		
		JPanel panel_25 = new JPanel();
		panel_3.add(panel_25);
		
		JComboBox comboBoxActiva = new JComboBox<String>();
		comboBoxActiva.setEditable(true);
		comboBoxActiva.addItem("Si");
		comboBoxActiva.addItem("No");
		panel_25.add(comboBoxActiva);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_16 = new JPanel();
		panel_4.add(panel_16);
		
		JLabel lblNewLabel_7 = new JLabel("Promocion acumulable");
		panel_16.add(lblNewLabel_7);
		
		JPanel panel_26 = new JPanel();
		panel_4.add(panel_26);
		
		JComboBox comboBoxAcumulable = new JComboBox<String>();
		comboBoxAcumulable.setEditable(true);
		comboBoxAcumulable.addItem("Si");
		comboBoxAcumulable.addItem("No");
		panel_26.add(comboBoxAcumulable);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		
		JLabel lblNewLabel_3 = new JLabel("Porcentaje de descuento");
		panel_17.add(lblNewLabel_3);
		
		JPanel panel_18 = new JPanel();
		panel_5.add(panel_18);
		
		textField = new JTextField();
		panel_18.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		JPanel panel_19 = new JPanel();
		panel_6.add(panel_19);
		
		JLabel lblNewLabel_4 = new JLabel("Hora inicio");
		panel_19.add(lblNewLabel_4);
		
		JPanel panel_20 = new JPanel();
		panel_6.add(panel_20);
		
		textField_1 = new JTextField();
		panel_20.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		
		JPanel panel_21 = new JPanel();
		panel_7.add(panel_21);
		
		JLabel lblNewLabel_5 = new JLabel("Hora finalizacion");
		panel_21.add(lblNewLabel_5);
		
		JPanel panel_22 = new JPanel();
		panel_7.add(panel_22);
		
		textField_2 = new JTextField();
		panel_22.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		
		JPanel panel_23 = new JPanel();
		panel_8.add(panel_23);
		
		JButton btnVolver = new JButton("Volver");
		panel_23.add(btnVolver);
		
		JPanel panel_24 = new JPanel();
		panel_8.add(panel_24);
		
		JButton btnConfirmar = new JButton("Confirmar");
		panel_24.add(btnConfirmar);

	}

}
