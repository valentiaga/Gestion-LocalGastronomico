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

	JComboBox comboBox;
	ActionListener actionListener;
	JButton btnModificaMozo;
	JButton btnEstableceEstado;

	@Override
	public void addActionListener(ActionListener actionListener) { 
		this.actionListener = actionListener;
		this.btnModificaMozo.addActionListener(actionListener);
		this.btnEstableceEstado.addActionListener(actionListener);
	}
	/**
	 * Create the panel.
	 */
	public VistaGestionMozoOp() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gestion Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSeleccionaMozo = new JLabel("Seleccione Mozo");
		lblSeleccionaMozo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSeleccionaMozo);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
		comboBox.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
		comboBox.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
		comboBox.addItemListener(this);
	
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
					.addGap(50)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
					.addGap(33)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnModificaMozo = new JButton("Modificar Mozo");
		btnModificaMozo.setActionCommand("MODIFICA");
		panel_2.add(btnModificaMozo);		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnEstableceEstado = new JButton("Establecer estados");
		btnEstableceEstado.setActionCommand("ESTABLECE");
		panel_3.add(btnEstableceEstado);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==comboBox) {
            String seleccionado=(String)comboBox.getSelectedItem();
            //JOptionPane.showMessageDialog(null, "Ha seleccionado "+seleccionado);
            //comboBox.setSelectedItem(comboBox.getSelectedItem());
		}
	}


	
	
}
