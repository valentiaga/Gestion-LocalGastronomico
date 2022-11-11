package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaGestionMesaOp;
import vista.IVistaGestionMozoOp;
import vista.Ventana;

public class ControladorVistaGestionMesaOp implements ActionListener {

	private IVistaGestionMesaOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionMesaOp(IVistaGestionMesaOp vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("MODIFICAR")) 
			JOptionPane.showMessageDialog(null, "Modifica.");
		else if (comando.equalsIgnoreCase("SETEAR"))
			JOptionPane.showMessageDialog(null, "Setear.");
		else if (comando.equalsIgnoreCase("CERRAR"))
			JOptionPane.showMessageDialog(null, "Cerrar.");
	}

}
