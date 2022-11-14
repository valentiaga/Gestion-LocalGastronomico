package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaModificaDatosPersonales extends JPanel implements IVistaModificaDatosPersonales{
	private JTextField textFieldNyA;
	private JTextField textFieldUserName;
	private JTextField textField;
	private JButton btnConfirmar;
	private ActionListener actionListener;

	/**
	 * Create the panel.
	 */
	public VistaModificaDatosPersonales() {
		setBorder(new TitledBorder(null, "Modifica Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNyA = new JLabel("Nombre y Apellido");
		panel.add(lblNyA);
		
		textFieldNyA = new JTextField();
		panel.add(textFieldNyA);
		textFieldNyA.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblUserName = new JLabel("Usuario");
		panel_1.add(lblUserName);
		
		textFieldUserName = new JTextField();
		panel_1.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblPassword = new JLabel("Contraseña");
		panel_2.add(lblPassword);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand("CONFIRMA");
		panel_3.add(btnConfirmar);

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
	public void addActionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
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

}
