package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.UserNameRepetido_Exception;
import negocio.Sistema;
import vista.IVistaAdmin;
import vista.IVistaGestionProductoAdmin;
import vista.IVistaModificaDatosPersonales;
import vista.IVistaRegistrarOperario;
import vista.Ventana;

public class ControladorVistaRegistrarOperario implements ActionListener {

	private IVistaRegistrarOperario vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaRegistrarOperario(IVistaRegistrarOperario vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("CONFIRMA")) {
			try {
				Sistema.getInstance().getFuncionalidadAdmin().registraOperario(this.vista.getNyA(), this.vista.getUserName(), this.vista.getPassword(), this.vista.getActivo());
				JOptionPane.showMessageDialog(null, "Operario registrado");
				this.vista.limpiarVista();
				cl.show(contentPane, ventana.getVistaAdmin());
				//System.out.println(Sistema.getInstance().getOperariosRegistrados().get("juanCarlos").getUserName());
			} catch (UserNameRepetido_Exception | ContrasenaIncorrecta_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaAdmin());
	}
	

}
