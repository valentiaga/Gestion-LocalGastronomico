package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaGestionMozoOp;
import vista.IVistaOperario;
import vista.Ventana;

public class ControladorVistaOperario implements ActionListener {

	private IVistaOperario vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	public ControladorVistaOperario(IVistaOperario vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		System.out.println("hola");
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("GESTION_MESA")) 
			cl.show(contentPane, ventana.getVistaMesaOp());
		else if (comando.equalsIgnoreCase("GESTION_MOZO"))
			cl.show(contentPane, ventana.getVistaGestionMozoOp());
		else if (comando.equalsIgnoreCase("GESTION_PRODUCTO"))
			cl.show(contentPane, ventana.getVistaProductoOp());
		else if (comando.equalsIgnoreCase("GESTION_PROMOCIONES")) 
			JOptionPane.showMessageDialog(null, "promos.");
		else if (comando.equalsIgnoreCase("MODIFICAR")) 
			cl.show(contentPane, ventana.getVistaOp());
		else if (comando.equalsIgnoreCase("CERRAR_SESION")) 
			cl.show(contentPane, ventana.getVistaInicial());
	}

}
