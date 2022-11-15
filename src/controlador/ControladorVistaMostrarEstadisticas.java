package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.IVistaAltaMozo;
import vista.IVistaGestionMesaAdmin;
import vista.IVistaMostrarEstadisticas;
import vista.Ventana;

public class ControladorVistaMostrarEstadisticas implements ActionListener {

	private IVistaMostrarEstadisticas vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaMostrarEstadisticas(IVistaMostrarEstadisticas vista, Ventana ventana) {
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
		
		if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionMozoAdmin());
	}
	
	
}
