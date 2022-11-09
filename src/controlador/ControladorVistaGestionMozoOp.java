package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaGestionMozoOp;
import vista.Ventana;

public class ControladorVistaGestionMozoOp implements ActionListener {

	private IVistaGestionMozoOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	public ControladorVistaGestionMozoOp(Ventana ventana, IVistaGestionMozoOp vista) {
		super();
		this.vista = vista;
		this.ventana = ventana;
		this.vista.setActionListener(this);
		this.contentPane = ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 String comando = e.getActionCommand(); 
		 System.out.println("Entre");
		 if (comando.equalsIgnoreCase ("MODIFICA"))
				 JOptionPane.showMessageDialog(null, "Modifica.");
		 else if (comando.equalsIgnoreCase ("ESTABLECE"))
				 JOptionPane.showMessageDialog(null, "Estados.");
	}

}
