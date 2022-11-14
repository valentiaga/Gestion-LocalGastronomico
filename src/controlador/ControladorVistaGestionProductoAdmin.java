package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
			JOptionPane.showMessageDialog(null, "Modifica");
		}
		else if (comando.equalsIgnoreCase("AGREGA"))
			JOptionPane.showMessageDialog(null, "Alta");
		else if (comando.equalsIgnoreCase("ELIMINA"))
			JOptionPane.showMessageDialog(null, "Elimina");
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaAdmin());
	}
	

}
