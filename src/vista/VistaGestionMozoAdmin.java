package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorVistaGestionMozoAdmin;
import controlador.ControladorVistaGestionMozoOp;
import negocio.Sistema;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VistaGestionMozoAdmin extends JPanel implements ItemListener, IVistaGestionMozoAdmin {

	JComboBox comboBox;
	ActionListener actionListener;
	JButton btnModificaMozo;
	JButton btnElimina;
	JButton btnAltaMozo;
	JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public VistaGestionMozoAdmin() {
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Gestion Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAltaMozo = new JButton("Alta Mozo");
		btnAltaMozo.setActionCommand("ALTA");
		panel_1.add(btnAltaMozo);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		btnModificaMozo = new JButton("Modificar Mozo");
		panel_5.add(btnModificaMozo);
		btnModificaMozo.setActionCommand("MODIFICA");

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
				comboBox = new JComboBox<String>();
				panel_6.add(comboBox);
				comboBox.setEditable(true);
				comboBox.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
				comboBox.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
				comboBox.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
				comboBox.addItemListener(this);

		btnElimina = new JButton("Eliminar Mozo");
		btnElimina.setActionCommand("ELIMINA");
		panel_6.add(btnElimina);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");

		btnVolver = new JButton("VOLVER");
		panel_7.add(btnVolver);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == comboBox) {
			String seleccionado = (String) comboBox.getSelectedItem();
			// JOptionPane.showMessageDialog(null, "Ha seleccionado "+seleccionado);
			// comboBox.setSelectedItem(comboBox.getSelectedItem());
		}

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnModificaMozo.addActionListener(actionListener);
		this.btnAltaMozo.addActionListener(actionListener);
		this.btnElimina.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}
	

	public JComboBox getComboBox() {
		return comboBox;
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
	public String getNombreMozo() {
		return this.comboBox.getSelectedItem().toString();
	}

	

	

}
