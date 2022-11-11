package vista;

import javax.swing.JPanel;

import modelo.Enumerados;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaModificaMozo extends JPanel implements ItemListener, IVistaModificaMozo{
	private JTextField textFieldNyA;
	private JTextField textFieldCantHijos;

	/**
	 * Create the panel.
	 */
	public VistaModificaMozo() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(Enumerados.estadoMozo.ACTIVO);
		comboBox.addItem(Enumerados.estadoMozo.AUSENTE);
		comboBox.addItem(Enumerados.estadoMozo.DEFRANCO);
		comboBox.addItemListener(this);
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
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JButton btnConfirmar = new JButton("Confirmar");
		panel_5.add(btnConfirmar);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
