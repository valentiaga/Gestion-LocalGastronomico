package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VistaModificaMozoOp extends JPanel implements ItemListener, IVistaModificaMozoOp, KeyListener {

	private JTextField textFieldNyA;
	private JTextField textFieldCantHijos;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private JComboBox<String> comboBoxMozo;
	private ActionListener actionListener;
	private JComboBox comboBox;
	private Mozo mozo;

	/**
	 * Create the panel.
	 */
	public VistaModificaMozoOp() {
		setBorder(new TitledBorder(null, "Modifica Mozo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblSeleccionaMozo = new JLabel("Seleccione Mozo");
		panel_1.add(lblSeleccionaMozo);
		lblSeleccionaMozo.setHorizontalAlignment(SwingConstants.CENTER);

		comboBoxMozo = new JComboBox<String>();
		comboBoxMozo.addKeyListener(this);
		comboBoxMozo.setEditable(true);
		HashMap<String, Mozo> mozos = Sistema.getInstance().getMozos();
		String nombre = "";
		for (HashMap.Entry<String, Mozo> entry : mozos.entrySet()) {
			nombre = entry.getKey();// mozos.get(entry.getKey());
			this.comboBoxMozo.addItem(nombre);
		}
		comboBoxMozo.addItemListener(this);
		panel_1.add(comboBoxMozo);
		comboBoxMozo.setEditable(true);
		//mozo = Sistema.getInstance().getMozos().get(this.comboBoxMozo.getSelectedItem().toString());
comboBoxMozo.setSelectedItem(null);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JLabel lblNyA = new JLabel("Nombre y apellido");
		panel_2.add(lblNyA);

		textFieldNyA = new JTextField();
		textFieldNyA.setEditable(false);
		textFieldNyA.addKeyListener(this);
		panel_2.add(textFieldNyA);
		textFieldNyA.setColumns(10);
		textFieldNyA.setText("");

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JLabel lblCantHijos = new JLabel("Cantidad  de hijos");
		panel_3.add(lblCantHijos);

		textFieldCantHijos = new JTextField();
		textFieldCantHijos.addKeyListener(this);
		panel_3.add(textFieldCantHijos);
		textFieldCantHijos.setColumns(10);
		textFieldCantHijos.setText("");

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JLabel lblNewLabel = new JLabel("Estado");
		panel_5.add(lblNewLabel);

		comboBox = new JComboBox();
		panel_5.add(comboBox);
		comboBox.addItem(Enumerados.estadoMozo.ACTIVO);
		comboBox.addItem(Enumerados.estadoMozo.AUSENTE);
		comboBox.addItem(Enumerados.estadoMozo.DEFRANCO);
		comboBox.addItemListener(this);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(true);
		panel_6.add(btnConfirmar);
		btnConfirmar.setActionCommand("CONFIRMAR");

		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnVolver = new JButton("Volver");
		panel_1_1.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");

		this.comboBox.setName("jComboBoxEstados");
		this.comboBoxMozo.setName("jComboBoxMozos");
		this.textFieldCantHijos.setName("jTextFieldCantHijos");
		this.textFieldNyA.setName("jTextFieldNyA");
		this.btnConfirmar.setName("jBtnConfirmar");
		this.btnVolver.setName("jBtnVolver");
	}
	
	
	@Override
	public JComboBox getComboBox() {
		return comboBox;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if (this.comboBoxMozo.getSelectedItem() != null) {
			mozo = Sistema.getInstance().getMozos().get(this.comboBoxMozo.getSelectedItem().toString());
			textFieldCantHijos.setText(String.valueOf(mozo.getCantHijos()));
			textFieldNyA.setText(mozo.getNyA());
			this.btnConfirmar.setEnabled(true);
		}
	}

	@Override
	public void addAcionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
		System.out.println(this.textFieldNyA.getText());
	}

	@Override
	public String getNyA() {
		return this.textFieldNyA.getText();
	}

	@Override
	public int getCantHijos() {
		int cantHijos = -1;
		try {
			cantHijos = Integer.parseInt(this.textFieldCantHijos.getText());
		} catch (NumberFormatException e2) {
		}
		return cantHijos;
	}

	@Override
	public void limpiarVista() {
		this.textFieldCantHijos.setText("");
		this.textFieldNyA.setText("");
		this.comboBox.setSelectedItem(null);
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
	public JTextField getTextFieldNyA() {
		return textFieldNyA;
	}
	@Override
	public JTextField getTextFieldCantHijos() {
		return textFieldCantHijos;
	}

	@Override
	public Mozo getMozo() {
		// TODO Auto-generated method stub
		return Sistema.getInstance().getMozos().get(this.comboBoxMozo.getSelectedItem().toString());
	}

	@Override
	public void actualizaComboBox() {
		HashMap<String, Mozo> mozos = Sistema.getInstance().getMozos();
		String nombre = "";
		this.comboBoxMozo.removeAllItems();
		for (HashMap.Entry<String, Mozo> entry : mozos.entrySet()) {
			nombre = entry.getKey();// mozos.get(entry.getKey());
			this.comboBoxMozo.addItem(nombre);
		}
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean cond = this.getCantHijos()>=0 && this.getNyA().length()>0;
		this.btnConfirmar.setEnabled(cond);
	}
	public void keyTyped(KeyEvent e) {
	}

	
	
	
}
