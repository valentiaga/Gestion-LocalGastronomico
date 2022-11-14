package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
			JOptionPane.showMessageDialog(null, "Modifica");
			cl.show(contentPane, ventana.getVistaAdmin());
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaAdmin());
	}
	

}
