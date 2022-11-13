package vista;

import javax.swing.JPanel;

import modelo.Enumerados;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaModificaMozo extends JPanel implements ItemListener, IVistaModificaMozo{
	private JTextField textFieldNyA;
	private JTextField textFieldCantHijos;
	private JTextField textFieldSueldo;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ActionListener actionListener;
	/**
	 * Create the panel.
	 */
	public VistaModificaMozo() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(Enumerados.estadoMozo.ACTIVO);
		comboBox.addItem(Enumerados.estadoMozo.AUSENTE);
		comboBox.addItem(Enumerados.estadoMozo.DEFRANCO);
		comboBox.addItemListener(this);
		
		JLabel lblNewLabel = new JLabel("Estado");
		panel_1.add(lblNewLabel);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNyA = new JLabel("Nombre y apellido");
		panel_2.add(lblNyA);
		
		textFieldNyA = new JTextField();
		panel_2.add(textFieldNyA);
		textFieldNyA.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblCantHijos = new JLabel("Cantidad  de hijos");
		panel_3.add(lblCantHijos);
		
		textFieldCantHijos = new JTextField();
		panel_3.add(textFieldCantHijos);
		textFieldCantHijos.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		panel_4.add(lblSueldo);
		
		textFieldSueldo = new JTextField();
		panel_4.add(textFieldSueldo);
		textFieldSueldo.setColumns(10);
		
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAcionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}

	@Override
	public String getNyA() {
		// TODO Auto-generated method stub
		return this.textFieldNyA.getText();
	}

	@Override
	public int getCantHijos() {
		int cantHijos=-1;
		try {
			cantHijos = Integer.parseInt(this.textFieldCantHijos.getText());
		}
		catch (NumberFormatException e2) {
		}
		return cantHijos;
	}

	@Override
	public float getSueldo() {
		float sueldo=0;
		try {
			sueldo = Float.parseFloat(this.textFieldSueldo.getText());
		}
		catch (NumberFormatException e2) {
		}
		return sueldo;
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);		
	}

}
