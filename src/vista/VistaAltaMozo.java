package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Enumerados.estadoMozo;

public class VistaAltaMozo extends JPanel implements ItemListener, IVistaAltaMozo{
	
	private JTextField textFieldNyA;
	private JTextField textFieldCantHijos;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ActionListener actionListener;
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public VistaAltaMozo () {
		setBorder(new TitledBorder(null, "Alta Mozo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblNewLabel = new JLabel("Estado");
		panel_7.add(lblNewLabel);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		panel_8.add(comboBox);
		comboBox.addItem(Enumerados.estadoMozo.ACTIVO);
		comboBox.addItem(Enumerados.estadoMozo.AUSENTE);
		comboBox.addItem(Enumerados.estadoMozo.DEFRANCO);
		comboBox.addItemListener(this);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		JLabel lblNyA = new JLabel("Nombre y apellido");
		panel_9.add(lblNyA);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		
		textFieldNyA = new JTextField();
		panel_10.add(textFieldNyA);
		textFieldNyA.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		JLabel lblCantHijos = new JLabel("Cantidad  de hijos");
		panel_11.add(lblCantHijos);
		
		JPanel panel_12 = new JPanel();
		panel_3.add(panel_12);
		
		textFieldCantHijos = new JTextField();
		panel_12.add(textFieldCantHijos);
		textFieldCantHijos.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		
		JPanel panel_20 = new JPanel();
		panel_13.add(panel_20);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento");
		panel_20.add(lblFecha);
		
		JPanel panel_14 = new JPanel();
		panel_4.add(panel_14);
		panel_14.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_14.add(panel_17);
		
		JPanel panel_21 = new JPanel();
		panel_17.add(panel_21);
		
		JLabel lblNewLabel_1 = new JLabel("Dia");
		panel_21.add(lblNewLabel_1);
		
		JPanel panel_26 = new JPanel();
		panel_17.add(panel_26);
		
		textFieldDia = new JTextField();
		panel_26.add(textFieldDia);
		textFieldDia.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		panel_14.add(panel_18);
		
		JPanel panel_22 = new JPanel();
		panel_18.add(panel_22);
		
		JLabel lblNewLabel_2 = new JLabel("Mes");
		panel_22.add(lblNewLabel_2);
		
		JPanel panel_25 = new JPanel();
		panel_18.add(panel_25);
		
		textFieldMes = new JTextField();
		panel_25.add(textFieldMes);
		textFieldMes.setColumns(10);
		
		JPanel panel_19 = new JPanel();
		panel_14.add(panel_19);
		
		JPanel panel_23 = new JPanel();
		panel_19.add(panel_23);
		
		JLabel lblNewLabel_3 = new JLabel("Año");
		panel_23.add(lblNewLabel_3);
		
		JPanel panel_24 = new JPanel();
		panel_19.add(panel_24);
		
		textFieldAnio = new JTextField();
		panel_24.add(textFieldAnio);
		textFieldAnio.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		btnConfirmar = new JButton("Confirmar");
		panel_15.add(btnConfirmar);
		btnConfirmar.setActionCommand("CONFIRMAR");
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JPanel panel_16 = new JPanel();
		panel_6.add(panel_16);
		
		btnVolver = new JButton("Volver");
		panel_16.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");

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
	public void limpiarVista() {
		this.textFieldAnio.setText("");
		this.textFieldCantHijos.setText("");
		this.textFieldDia.setText("");
		this.textFieldMes.setText("");
		this.textFieldNyA.setText("");
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);		
	}

	@Override
	public int getDiaNacimiento() {
		int diaNac=-1;
		try {
			diaNac = Integer.parseInt(this.textFieldDia.getText());
		}
		catch (NumberFormatException e2) {
		}
		return diaNac;
	}

	@Override
	public int getMesNacimiento() {
		int mesNac=-1;
		try {
			mesNac = Integer.parseInt(this.textFieldMes.getText());
		}
		catch (NumberFormatException e2) {
		}
		return mesNac;
	}

	@Override
	public int getAnioNacimiento() {
		int anioNac=-1;
		try {
			anioNac = Integer.parseInt(this.textFieldAnio.getText());
		}
		catch (NumberFormatException e2) {
		}
		return anioNac;
	}

	@Override
	public GregorianCalendar fechaNacimiento() {
		return new GregorianCalendar(this.getAnioNacimiento(), this.getMesNacimiento(), this.getDiaNacimiento());
	}

	@Override
	public estadoMozo getEstado() {
		// TODO Auto-generated method stub
		return (estadoMozo) this.comboBox.getSelectedItem();
	}



}
