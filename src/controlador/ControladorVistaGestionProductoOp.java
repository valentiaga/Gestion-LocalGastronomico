package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaGestionProductoOp;
import vista.Ventana;

public class ControladorVistaGestionProductoOp implements ActionListener {

	private IVistaGestionProductoOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("MODIFICA")) {
			cl.show(contentPane, ventana.getVistaModificaProducto());
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaOp());
		
	}

}
