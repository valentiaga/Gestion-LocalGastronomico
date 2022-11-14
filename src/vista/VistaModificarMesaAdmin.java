package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Enumerados.estadoMesa;
import modelo.Enumerados.estadoMozo;

public class VistaModificarMesaAdmin extends JPanel implements IVistaModificarMesa, ItemListener{
	private JTextField textFieldCantSillas;
	private JButton btnVolver;
	private JButton btnConfirma;
	private ActionListener actionListener;
	private JComboBox comboBoxEstado;
	/**
	 * Create the panel.
	 */
	public VistaModificarMesaAdmin() {
		setBorder(new TitledBorder(null, "Modificar Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel lblCantidadSillas = new JLabel("Cantidad de Sillas");
		panel_5.add(lblCantidadSillas);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		textFieldCantSillas = new JTextField();
		panel_6.add(textFieldCantSillas);
		textFieldCantSillas.setColumns(10);
		
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JLabel lblEstado = new JLabel("Estado");
		panel_7.add(lblEstado);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		comboBoxEstado = new JComboBox<String>();
		panel_8.add(comboBoxEstado);
		comboBoxEstado.setEditable(true);
		comboBoxEstado.addItem( Enumerados.estadoMesa.LIBRE);
		comboBoxEstado.addItem( Enumerados.estadoMesa.OCUPADA);
		comboBoxEstado.addItemListener(this);
		
		JPanel panel_9 = new JPanel();
		add(panel_9);
		
		btnConfirma = new JButton("Confirma");
		btnConfirma.setActionCommand("CONFIRMA");
		panel_9.add(btnConfirma);
		
		JPanel panel_10 = new JPanel();
		add(panel_10);
		
		btnVolver = new JButton("Volver");
		panel_10.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnConfirma.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCantSillas() {
		int cantSillas = -1;
		try {
			cantSillas = Integer.parseInt(this.textFieldCantSillas.getText());
		} catch (NumberFormatException e2) {
		}
		return cantSillas;
	}

	@Override
	public estadoMesa getEstado() {
		//System.out.println((estadoMesa) this.comboBoxEstado.getSelectedItem());
		return (estadoMesa) this.comboBoxEstado.getSelectedItem();
	}
	

}
