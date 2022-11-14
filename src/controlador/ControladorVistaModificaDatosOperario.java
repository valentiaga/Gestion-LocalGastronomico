package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.UserNameRepetido_Exception;
import negocio.Sistema;
import vista.IVistaAdmin;
import vista.IVistaGestionProductoAdmin;
import vista.IVistaModificaDatosPersonales;
import vista.Ventana;

public class ControladorVistaModificaDatosOperario implements ActionListener {

	private IVistaModificaDatosPersonales vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaDatosOperario(IVistaModificaDatosPersonales vista, Ventana ventana) {
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
				Sistema.getInstance().getFuncionalidadOperario().modificaOperario(this.vista.getNyA(), this.vista.getUserName(), this.vista.getPassword());
				JOptionPane.showMessageDialog(null, "Datos actualizados.");
				cl.show(contentPane, ventana.getVistaOp());
			} catch (UserNameRepetido_Exception | ContrasenaIncorrecta_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		
	}
	

}
