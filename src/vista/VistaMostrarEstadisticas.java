package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Mozo;
import negocio.Sistema;

public class VistaMostrarEstadisticas extends JPanel implements ItemListener, IVistaMostrarEstadisticas{
	
	private ActionListener actionListener;
	private JComboBox comboBoxMozo;
	private JButton btnConfirmar;
	private JButton btnVolver;
	private Mozo mozo;
	
	/**
	 * Create the panel.
	 */
	public VistaMostrarEstadisticas() {
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
		comboBoxMozo.setEditable(true);
		comboBoxMozo.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
		comboBoxMozo.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
		comboBoxMozo.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
		comboBoxMozo.addItemListener(this);
		panel_1.add(comboBoxMozo);
		comboBoxMozo.setEditable(true);
		mozo = Sistema.getInstance().getMozos().get(this.comboBoxMozo.getSelectedItem().toString());
		
		//btnConfirmar.setActionCommand("CONFIRMAR");
		
		
		//btnVolver.setActionCommand("VOLVER");
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
