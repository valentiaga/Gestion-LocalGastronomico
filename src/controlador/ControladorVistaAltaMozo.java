package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaAdmin;
import vista.IVistaAltaMozo;
import vista.IVistaGestionProductoAdmin;
import vista.IVistaModificaDatosPersonales;
import vista.IVistaRegistrarOperario;
import vista.Ventana;

public class ControladorVistaAltaMozo implements ActionListener {

	private IVistaAltaMozo vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaAltaMozo(IVistaAltaMozo vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addAcionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("MODIFICA")) 
			JOptionPane.showMessageDialog(null, "Modifica");
		else if (comando.equalsIgnoreCase("AGREGA"))
			JOptionPane.showMessageDialog(null, "Alta");
		else if (comando.equalsIgnoreCase("ELIMINA"))
			JOptionPane.showMessageDialog(null, "Elimina");
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaAdmin());
	}
	

}
