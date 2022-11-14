package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.Sistema;
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
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("GESTION_MESA")) 
			cl.show(contentPane, ventana.getVistaMesaAdmin());
		else if (comando.equalsIgnoreCase("GESTION_MOZO"))
			cl.show(contentPane, ventana.getVistaGestionMozoAdmin());
		else if (comando.equalsIgnoreCase("GESTION_PRODUCTO"))
			cl.show(contentPane, ventana.getVistaGestionProductoAdmin());
		else if (comando.equalsIgnoreCase("GESTION_OPERARIO")) {
			cl.show(contentPane, ventana.getVistaRegistraOp());
		}
		else if (comando.equalsIgnoreCase("CERRAR_SESION")) {
			Sistema.getInstance().setFuncionalidadAdmin(null);
			cl.show(contentPane, ventana.getVistaInicial());
		}
	}

}
