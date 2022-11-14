package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import negocio.Sistema;
import vista.IVistaModificaDatosPersonales;
import vista.IVistaModificaProducto;
import vista.Ventana;

public class ControladorVistaModificaProducto implements ActionListener {

	private IVistaModificaProducto vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	public ControladorVistaModificaProducto(IVistaModificaProducto vista, Ventana ventana) {
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
			try {
				if (Sistema.getInstance().getFuncionalidadOperario() != null) {
				Sistema.getInstance().getFuncionalidadOperario().modificaProducto(
						this.vista.getIdProd(), this.vista.getNombre(),
						this.vista.getPrecioCosto(), this.vista.getPrecioVenta(), this.vista.getStockInicial());
				JOptionPane.showMessageDialog(null, "Datos actualizados.");
				cl.show(contentPane, ventana.getVistaGestionProductoOp());
				}
				else {
					Sistema.getInstance().getFuncionalidadAdmin().modificaProducto(
							this.vista.getIdProd(), this.vista.getNombre(),
							this.vista.getPrecioCosto(), this.vista.getPrecioVenta(), this.vista.getStockInicial());
					JOptionPane.showMessageDialog(null, "Datos actualizados.");
					cl.show(contentPane, ventana.getVistaGestionProductoAdmin());
				}
				this.vista.limpiarVista();
			} catch (precioInvalido_Exception | prodEnUso_Exception | NoExisteID_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) {
			if (Sistema.getInstance().getFuncionalidadOperario() != null) 
				cl.show(contentPane, ventana.getVistaGestionProductoOp());	
			else
				cl.show(contentPane, ventana.getVistaGestionProductoAdmin());
			this.vista.limpiarVista();
		}

	}

}
