package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.OperarioInactivo_Exception;
import excepciones.UserNameIncorrecto_Exception;
import negocio.Sistema;
import vista.IVistaInicial;
import vista.Ventana;

public class ControladorVistaInicial implements ActionListener{
	private IVistaInicial vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaInicial(IVistaInicial vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("ACEPTAR")) {
			JOptionPane.showMessageDialog(null, "ACEPTARs");
			try {
				Sistema.getInstance().login(vista.getUsuario(), vista.getContrasena());
			} catch (UserNameIncorrecto_Exception | ContrasenaIncorrecta_Exception | OperarioInactivo_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
