package vista;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import modelo.Enumerados;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaGestionOperario extends JPanel implements IVistaGestionOperario{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VistaGestionOperario() {
		setBorder(new TitledBorder(null, "Gestion Operarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel lblUserName = new JLabel("Usuario");
		panel_7.add(lblUserName);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		textField = new JTextField();
		panel_8.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JButton btnModificarOperario = new JButton("Estado Operario");
		panel_6.add(btnModificarOperario);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		
		JComboBox comboBox = new JComboBox<String>();
		panel_5.add(comboBox);
		comboBox.add(null,Enumerados.estadoOperario.ACTIVO);
		comboBox.add(null,Enumerados.estadoOperario.INACTIVO);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		JButton btnNewButton = new JButton("Eliminar Operario");
		panel_9.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		JButton btnAgregar = new JButton("Agregar Operario");
		panel_10.add(btnAgregar);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		
		JButton btnVolver = new JButton("Volver");
		panel_11.add(btnVolver);

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

}
