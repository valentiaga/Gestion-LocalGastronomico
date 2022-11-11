package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.IVistaAdmin;
import vista.IVistaGestionMesaAdmin;
import vista.Ventana;

public class ControladorVistaAdmin implements ActionListener {

	private IVistaAdmin vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaAdmin(IVistaAdmin vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
