package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupada_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.StockInsuficiente_Exception;
import modelo.Enumerados;
import modelo.Mesa;
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
			cl.show(contentPane, ventana.getVistaModificaMesa());
		else if (comando.equalsIgnoreCase("SETEAR"))
			JOptionPane.showMessageDialog(null, "Setear.");
		else if (comando.equalsIgnoreCase("CERRAR")) {
			/*try {
				Sistema.getInstance().getFuncionalidadAdmin().cierraMesa(this.vista.getNroMesa(), null);
				this.vista.limpiarVista();
			} catch (MesaNoOcupadaException e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} // falta ver forma de pago !!!!!!*/
			JOptionPane.showMessageDialog(null, "Cerrar.");
		}
		else if (comando.equalsIgnoreCase("ABRIR_MESA")) {
			try {
				Sistema.getInstance().getFuncionalidadAdmin()
						.abreComanda(Sistema.getInstance().getMesas().get(nroMesa));
				this.vista.ventanaEmergente("Abierta con exito");
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
				Sistema.getInstance().getFuncionalidadAdmin().agregaPedidos(nroMesa, this.vista.getIdProd(), this.vista.getCant());
			} catch (StockInsuficiente_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
	}

}
