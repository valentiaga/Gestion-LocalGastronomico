package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupada_Exception;
import excepciones.NoExisteMesa_Exception;
import modelo.Comanda;
import modelo.Mesa;
import negocio.Sistema;
import vista.IVistaGestionMesaAdmin;
import vista.Ventana;

public class ControladorVistaGestionMesaAdmin implements ActionListener {

	private IVistaGestionMesaAdmin vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionMesaAdmin(IVistaGestionMesaAdmin vista, Ventana ventana) {
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
		if (comando.equalsIgnoreCase("MODIFICA")) 
			cl.show(contentPane, ventana.getVistaModificaMesa());
		else if (comando.equalsIgnoreCase("AGREGA")) {
			try {
				Sistema.getInstance().getFuncionalidadAdmin().abreComanda(Sistema.getInstance().getMesas().get(this.vista.getNroMesa()), this.vista.getCantPax());
			} catch (NoExisteMesa_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} //fijarse bien esto
			JOptionPane.showMessageDialog(null, "Agrega.");
		}
		else if (comando.equalsIgnoreCase("ELIMINA")) {
			try {
				Sistema.getInstance().getFuncionalidadAdmin().eliminaMesa(this.vista.getNroMesa());
				JOptionPane.showMessageDialog(null, "Elimina.");
			} catch (MesaOcupada_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} catch (NoExisteMesa_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaAdmin());
		else if (comando.equalsIgnoreCase("CERRAR")) {
			//Mesa mesaActual = Sistema.getInstance().getMesas().get(this.vista.getNroMesa());
			//Comanda comandaActual = Sistema.getInstance().getComandas().get(this.vista.getNroMesa());
			try {
				Sistema.getInstance().getFuncionalidadAdmin().cierraMesa(this.vista.getNroMesa(), null);
			} catch (MesaNoOcupadaException e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} //falta ver forma de pago !!!!!!
			JOptionPane.showMessageDialog(null, "Cerrar.");
		}
		else if (comando.equalsIgnoreCase("SETEAR")) 
			JOptionPane.showMessageDialog(null, "Setea.");

	}

}
