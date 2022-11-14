package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Enumerados.estadoMozo;
import modelo.Mozo;
import negocio.Sistema;

public class VistaModificaMozoAdmin extends JPanel implements ItemListener, IVistaModificaMozoAdmin{
	private JTextField textFieldNyA;
	private JTextField textFieldCantHijos;
	private JTextField textFieldSueldo;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private JComboBox comboBox;
	private JComboBox<String> comboBoxMozo;
	private JComboBox<String> comboBoxMozo_1;
	private ActionListener actionListener;
	private Mozo mozo;
	/**
	 * Create the panel.
	 */
	public VistaModificaMozoAdmin() {
		setBorder(new TitledBorder(null, "Modifica Mozo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblSeleccionaMozo = new JLabel("Seleccione Mozo");
		panel_7.add(lblSeleccionaMozo);
		lblSeleccionaMozo.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBoxMozo = new JComboBox<String>();
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		comboBoxMozo_1 = new JComboBox<String>();
		panel_8.add(comboBoxMozo_1);
		comboBoxMozo_1.setEditable(true);
		comboBoxMozo_1.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
		comboBoxMozo_1.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
		comboBoxMozo_1.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
		comboBoxMozo_1.addItemListener(this);
		mozo = Sistema.getInstance().getMozos().get(this.comboBoxMozo_1.getSelectedItem().toString());

		
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
		textFieldNyA.setText(mozo.getNyA());
		
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
		textFieldCantHijos.setText(String.valueOf(mozo.getCantHijos()));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		panel_13.add(lblSueldo);
		
		JPanel panel_14 = new JPanel();
		panel_4.add(panel_14);
		
		textFieldSueldo = new JTextField();
		panel_14.add(textFieldSueldo);
		textFieldSueldo.setColumns(10);
		textFieldSueldo.setText(String.valueOf(mozo.getSueldo()));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		JLabel lblNewLabel = new JLabel("Estado");
		panel_15.add(lblNewLabel);
		
		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);
		
		comboBox = new JComboBox();
		panel_16.add(comboBox);
		comboBox.addItem(Enumerados.estadoMozo.ACTIVO);
		comboBox.addItem(Enumerados.estadoMozo.AUSENTE);
		comboBox.addItem(Enumerados.estadoMozo.DEFRANCO);
		comboBox.addItemListener(this);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JPanel panel_17 = new JPanel();
		panel_6.add(panel_17);
		
		btnConfirmar = new JButton("Confirmar");
		panel_17.add(btnConfirmar);
		btnConfirmar.setActionCommand("CONFIRMAR");
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JPanel panel_18 = new JPanel();
		panel_1_1.add(panel_18);
		
		btnVolver = new JButton("Volver");
		panel_18.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		mozo = Sistema.getInstance().getMozos().get(this.comboBoxMozo_1.getSelectedItem().toString());
		textFieldCantHijos.setText(String.valueOf(mozo.getCantHijos()));
		textFieldNyA.setText(mozo.getNyA());
		textFieldSueldo.setText(String.valueOf(mozo.getSueldo()));
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

	@Override
	public estadoMozo getEstadoMozo() {
		return (estadoMozo) this.comboBox.getSelectedItem();
	}

	@Override
	public Mozo getMozo() {
		return this.mozo;
	}

}
