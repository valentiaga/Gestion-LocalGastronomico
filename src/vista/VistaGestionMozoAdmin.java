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
	JButton btnRemuneracion;
	private JTextField textFieldRemuneracionBasica;

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
		panel.setLayout(new GridLayout(6, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		btnAltaMozo = new JButton("Alta Mozo");
		panel_3.add(btnAltaMozo);
		btnAltaMozo.setActionCommand("ALTA");

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_2 = new JPanel();
		panel_5.add(panel_2);

		btnModificaMozo = new JButton("Modificar Mozo");
		panel_2.add(btnModificaMozo);
		btnModificaMozo.setActionCommand("MODIFICA");

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
				
				JPanel panel_4 = new JPanel();
				panel_6.add(panel_4);
		
				comboBox = new JComboBox<String>();
				panel_4.add(comboBox);
				comboBox.setEditable(true);
				comboBox.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
				comboBox.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
				comboBox.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
				comboBox.addItemListener(this);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);

		btnElimina = new JButton("Eliminar Mozo");
		panel_8.add(btnElimina);
		btnElimina.setActionCommand("ELIMINA");
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);
		
		this.btnRemuneracion = new JButton("Actualizar Remuneracion Basica");
		this.btnRemuneracion.setActionCommand("ACTUALIZAR_REMUNERACION");
		panel_11.add(btnRemuneracion);
		
		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		
		textFieldRemuneracionBasica = new JTextField();
		panel_12.add(textFieldRemuneracionBasica);
		textFieldRemuneracionBasica.setColumns(10);
		
		
		

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JPanel panel_14 = new JPanel();
		panel_10.add(panel_14);
		
		JButton btnMostrarEstadisticas = new JButton("Mostrar estadisticas");
		panel_14.add(btnMostrarEstadisticas);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		JPanel panel_9 = new JPanel();
		panel_13.add(panel_9);
		
		JButton btnVolver_1 = new JButton("VOLVER");
		panel_9.add(btnVolver_1);
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
		this.btnRemuneracion.addActionListener(actionListener);
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

	@Override
	public double getRemuneracionBasica() {
	
		return Double.valueOf(this.textFieldRemuneracionBasica.getText());
	}

	
	
	

}
