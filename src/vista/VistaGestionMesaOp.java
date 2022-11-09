package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaGestionMesaOp extends JPanel implements IVistaGestionMesaOp {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VistaGestionMesaOp() {
		setBorder(new TitledBorder(null, "Gestion Mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnModificaMesa = new JButton("Modificar Mesa");
		panel_1.add(btnModificaMesa);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSeteaMozo = new JButton("Setear Mozo");
		panel_2.add(btnSeteaMozo);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCerrarMesa = new JButton("Cerrar Mesa");
		btnCerrarMesa.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_3.add(btnCerrarMesa);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Numero de Mesa");
		panel_6.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);

	}

	@Override
	public void modificaMesa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seteaMozo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cierraMesa() {
		// TODO Auto-generated method stub
		
	}

}
