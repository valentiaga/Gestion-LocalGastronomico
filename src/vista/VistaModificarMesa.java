package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSeparator;

public class VistaModificarMesa extends JPanel {
	private JTextField textFieldNroMesa;
	private JTextField textFieldCantSillas;
	private JTextField textFieldEstado;

	/**
	 * Create the panel.
	 */
	public VistaModificarMesa() {
		setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Nro de Mesa");
		panel_3.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		textFieldNroMesa = new JTextField();
		panel_4.add(textFieldNroMesa);
		textFieldNroMesa.setColumns(10);
		
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
		
		textFieldEstado = new JTextField();
		panel_8.add(textFieldEstado);
		textFieldEstado.setColumns(10);

	}

}
