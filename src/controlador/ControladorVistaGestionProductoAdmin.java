package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.NoExisteID_Exception;
import excepciones.prodEnUso_Exception;
import negocio.Sistema;
import vista.IVistaAdmin;
import vista.IVistaGestionProductoAdmin;
import vista.Ventana;

public class ControladorVistaGestionProductoAdmin implements ActionListener {

	private IVistaGestionProductoAdmin vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionProductoAdmin(IVistaGestionProductoAdmin vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("MODIFICA")) {
			cl.show(contentPane, ventana.getVistaModificaProducto());
		}
		else if (comando.equalsIgnoreCase("AGREGA"))
			cl.show(contentPane, ventana.getVistaAgregaProducto());
		else if (comando.equalsIgnoreCase("ELIMINA")) {
			try {
				Sistema.getInstance().getFuncionalidadAdmin().eliminaProducto(this.vista.getIdProd());
				this.vista.ventanaEmergente("Eliminado con exito");
			} catch (prodEnUso_Exception | NoExisteID_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaAdmin());
	}
	

}
