package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import excepciones.NoExisteID_Exception;
import excepciones.PromoInvalida_Exception;
import negocio.Sistema;
import vista.IVistaAgregaProductoPromocion;
import vista.Ventana;

public class ControladorVistaModificaProductoPromocion implements ActionListener {

	private IVistaAgregaProductoPromocion vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	public ControladorVistaModificaProductoPromocion(IVistaAgregaProductoPromocion vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("CONFIRMAR")) {
			try {
				Sistema.getInstance().getFuncionalidadOperario().modificaPromocionProd(this.vista.getIdProd(), this.vista.getActiva(), this.vista.getDiasDePromo(), this.vista.isAplica2x1(),this.vista.isAplicaDtoPorCant(),this.vista.getDtoPorCant_CantMinima(), this.vista.getDtoPorCant_PrecioUnitario());
				this.vista.ventanaEmergente("Promo Modificada con exito");
				this.vista.limpiarVista();
			} catch (PromoInvalida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} catch (NoExisteID_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) {
			System.out.println("Entre");
			cl.show(contentPane, ventana.getVistaGestionPromociones());	
			this.vista.limpiarVista();
		}

	}

}
