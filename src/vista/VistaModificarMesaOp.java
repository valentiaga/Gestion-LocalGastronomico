package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Enumerados.estadoMesa;
import negocio.Sistema;
import javax.swing.JComboBox;

public class VistaModificarMesaOp extends JPanel implements IVistaModificarMesaOp, ItemListener{
	private JButton btnVolver;
	private JButton btnConfirma;
	private ActionListener actionListener;
	private JComboBox comboBoxEstado;
	/**
	 * Create the panel.
	 */
	public VistaModificarMesaOp() {
		setBorder(new TitledBorder(null, "Modificar Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 0, 0));
		
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
	public estadoMesa getEstado() {
		return (estadoMesa) this.comboBoxEstado.getSelectedItem();
	}

}
