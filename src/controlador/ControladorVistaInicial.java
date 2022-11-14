package controlador;

import java.awt.CardLayout;
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

public class ControladorVistaInicial implements ActionListener {
	private IVistaInicial vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	public ControladorVistaInicial(IVistaInicial vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		CardLayout cl = (CardLayout) contentPane.getLayout();
		if (comando.equalsIgnoreCase("ACEPTAR")) {

			try {
				Sistema.getInstance().login(vista.getUsuario(), vista.getContrasena());
				if (Sistema.getInstance().getFuncionalidadOperario() != null) {
					cl.show(contentPane, ventana.getVistaOp());
				}
				else
					cl.show(contentPane, ventana.getVistaAdmin());
				this.vista.limpiarVista();
			} catch (UserNameIncorrecto_Exception e1) {
				vista.ventanaEmergente("Usuario NO existe");
				vista.limpiarVista();
			} catch (ContrasenaIncorrecta_Exception e1) {
				vista.ventanaEmergente("Contrasena erronea");
				vista.limpiarVista();
			} catch (OperarioInactivo_Exception e1) {
				vista.ventanaEmergente("Operario en estado Inactivo");
				vista.limpiarVista();
			}

		}

	}

}
