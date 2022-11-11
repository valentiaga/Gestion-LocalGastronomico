package controlador;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
		this.ventana = ventana;
		this.vista = vista;
		this.vista.addActionListener(this);
		this.contentPane = this.ventana.getContentPane();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("MODIFICAR")) 
			JOptionPane.showMessageDialog(null, "Modifica.");
		else if (comando.equalsIgnoreCase("SETEAR"))
			JOptionPane.showMessageDialog(null, "Setear.");
		else if (comando.equalsIgnoreCase("CERRAR"))
			JOptionPane.showMessageDialog(null, "Cerrar.");
		else if (comando.equalsIgnoreCase("VOLVER")) {
			cl.show(contentPane, ventana.getVistaOp());
		}
//			JOptionPane.showMessageDialog(null, "vOLVER.");
	}

}
