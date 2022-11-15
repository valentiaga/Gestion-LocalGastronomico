package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.EstadoIncorrecto_Exception;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupada_Exception;
import excepciones.MozoInactivo_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.StockInsuficiente_Exception;
import negocio.Sistema;
import vista.IVistaGestionMesaOp;
import vista.Ventana;

public class ControladorVistaGestionMesaOp implements ActionListener {

	private IVistaGestionMesaOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionMesaOp(IVistaGestionMesaOp vista, Ventana ventana) {
		super();
		this.ventana = ventana;
		this.vista = vista;
		this.vista.addActionListener(this);
		this.contentPane = this.ventana.getContentPane();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		Integer nroMesa = this.vista.getNroMesa();
		
		if (comando.equalsIgnoreCase("MODIFICAR")) 
			cl.show(contentPane, ventana.getVistaModificaMesaOp());
		else if (comando.equalsIgnoreCase("SETEAR")) {
			try {
				Sistema.getInstance().getFuncionalidadOperario().setMesaMozo(this.vista.getNroMesa(), this.vista.getMozo());
				JOptionPane.showMessageDialog(null, "Seteada.");
			} catch (EstadoIncorrecto_Exception | NoExisteMesa_Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("CERRAR")) {
			try {
				Sistema.getInstance().getFuncionalidadOperario().cierraMesa(this.vista.getNroMesa(), this.vista.getFormaDePago());
				//this.vista.limpiarVista();
				JOptionPane.showMessageDialog(null, "Cerrar.");
			} catch (MesaNoOcupadaException e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} // falta ver forma de pago !!!!!!*/
		}
		else if (comando.equalsIgnoreCase("ABRIR_MESA")) {
			try {
				try {
					Sistema.getInstance().getFuncionalidadOperario()
							.abreComanda(Sistema.getInstance().getMesas().get(nroMesa));
					this.vista.ventanaEmergente("Abierta con exito");
				} catch (MozoInactivo_Exception e1) {
					this.vista.ventanaEmergente(e1.getMessage());
				}
			} catch (MesaOcupada_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} catch (NoExisteMesa_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		} 
		else if (comando.equalsIgnoreCase("VOLVER")) {
			cl.show(contentPane, ventana.getVistaOp());
		}
		else if (comando.equalsIgnoreCase("AGREGA_PEDIDO")) { 
			try {
				Sistema.getInstance().getFuncionalidadOperario().agregaPedidos(nroMesa, this.vista.getIdProd(), this.vista.getCant());
				this.vista.ventanaEmergente("Pedido agregado con exito");
			} catch (StockInsuficiente_Exception | NoExisteID_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
	}

}
