package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.IVistaGestionMesaAdmin;
import vista.IVistaGestionMozoOp;
import vista.Ventana;

public class ControladorVistaGestionMesaAdmin implements ActionListener {

	private IVistaGestionMesaAdmin vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionMesaAdmin(IVistaGestionMesaAdmin vista, Ventana ventana) {
		super();
		this.vista = vista;
		//this.vista.addActionListener(this);
		this.ventana = ventana;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
