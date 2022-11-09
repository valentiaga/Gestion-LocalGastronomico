package vista;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaGestionMesaAdmin extends VistaGestionMesaOp {
	private JTextField textField;
	public VistaGestionMesaAdmin() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		add(panel);
		
		JButton btnEliminaMesa = new JButton("Elimina Mesa");
		panel.add(btnEliminaMesa);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_5.add(panel_4);
		
		JLabel lblCantSillas = new JLabel("Ingresar Cantidad de sillas");
		panel_4.add(lblCantSillas);
		
		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_3.add(textField);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAgregaMesa = new JButton("Agrega Mesa");
		panel_2.add(btnAgregaMesa);
	}

}
