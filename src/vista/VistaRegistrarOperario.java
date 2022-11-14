package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VistaRegistrarOperario extends JPanel implements IVistaRegistrarOperario{

	private JTextField textFieldNyA;
	private JTextField textFieldUserName;
	private JTextField textField;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ActionListener actionListener;

	/**
	 * Create the panel.
	 */
	public VistaRegistrarOperario() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registra Operario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNyA = new JLabel("Nombre y Apellido");
		panel_5.add(lblNyA);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		textFieldNyA = new JTextField();
		panel_6.add(textFieldNyA);
		textFieldNyA.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblUserName = new JLabel("Usuario");
		panel_7.add(lblUserName);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		textFieldUserName = new JTextField();
		panel_8.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		panel_9.add(lblPassword);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		
		textField = new JTextField();
		panel_10.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		JLabel lblNewLabel = new JLabel("Estado Operario");
		panel_11.add(lblNewLabel);
		
		JPanel panel_12 = new JPanel();
		panel_3.add(panel_12);
		
		JComboBox comboBox = new JComboBox<String>();
		panel_12.add(comboBox);
		comboBox.addItem(Enumerados.estadoOperario.ACTIVO);
		comboBox.addItem(Enumerados.estadoOperario.INACTIVO);
		
		
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand("CONFIRMA");
		panel_13.add(btnConfirmar);
		
		JPanel panel_14 = new JPanel();
		add(panel_14);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel_14.add(btnVolver);

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
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
		
	}

	@Override
	public String getNyA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getActivo() {
		// TODO Auto-generated method stub
		return false;
	}

}
