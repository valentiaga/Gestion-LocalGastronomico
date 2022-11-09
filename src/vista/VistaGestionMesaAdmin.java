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

public class VistaGestionMesaAdmin extends VistaGestionMesaOp {
	public VistaGestionMesaAdmin() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(80);
		add(panel);
		
		JButton btnNewButton = new JButton("Cosas de Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
	}

}
