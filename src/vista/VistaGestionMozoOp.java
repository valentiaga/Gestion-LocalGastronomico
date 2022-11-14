package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorVistaGestionMozoOp;
import negocio.Sistema;

public class VistaGestionMozoOp extends JPanel implements IVistaGestionMozoOp, ItemListener {
	ActionListener actionListener;
	JButton btnModificaMozo;
	private JButton btnVolver;

	@Override
	public void addActionListener(ActionListener actionListener) { 
		this.actionListener = actionListener;
		this.btnModificaMozo.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
	}
	/**
	 * Create the panel.
	 */
	public VistaGestionMozoOp() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gestion Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnModificaMozo = new JButton("Modificar Mozo");
		btnModificaMozo.setActionCommand("MODIFICA");
		panel_2.add(btnModificaMozo);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnVolver = new JButton("Volver");
		panel_5.add(btnVolver);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
	}
	


	
	
}
