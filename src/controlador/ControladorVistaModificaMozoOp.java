package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Mozo;
import negocio.Sistema;
import vista.IVistaModificaMozoOp;
import vista.Ventana;

public class ControladorVistaModificaMozoOp implements ActionListener {
	private IVistaModificaMozoOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaMozoOp(IVistaModificaMozoOp vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addAcionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("CONFIRMAR")) {
			Mozo mozo = this.vista.getMozo();
			mozo.setCantHijos(this.vista.getCantHijos());
			mozo.setEstado(this.vista.getEstadoMozo());
			mozo.setNyA(this.vista.getNyA());
			JOptionPane.showMessageDialog(null, "Datos actualizados.");
			cl.show(contentPane, ventana.getVistaGestionMozoOp());
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionMozoOp());
	}

}
