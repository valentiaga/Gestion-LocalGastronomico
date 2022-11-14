package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.CantHijosInvalida_Exception;
import excepciones.EdadInvalida_Exception;
import excepciones.NyARepetido_Exception;
import excepciones.precioInvalido_Exception;
import modelo.Producto;
import negocio.Sistema;
import vista.IVistaAgregaProducto;
import vista.Ventana;

public class ControladorVistaAgregaProducto implements ActionListener {

	private IVistaAgregaProducto vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaAgregaProducto(IVistaAgregaProducto vista, Ventana ventana) {
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
				Sistema.getInstance().getFuncionalidadAdmin().agregaProducto(this.vista.getNombre(), this.vista.getPrecioCosto(), this.vista.getPrecioVenta(), this.vista.getStockInicial());
				JOptionPane.showMessageDialog(null, "Producto agregado con exito.");
				this.vista.limpiarVista();
				//System.out.println(Sistema.getInstance().getMozos().get("Juan Carlos").getNyA());
			} catch (precioInvalido_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionProductoAdmin());
	}
	

}
