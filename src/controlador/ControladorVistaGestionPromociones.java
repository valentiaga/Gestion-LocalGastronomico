package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import excepciones.PromoInvalida_Exception;
import negocio.FuncionalidadOperario;
import negocio.Sistema;
import vista.IVistaGestionPromociones;
import vista.Ventana;

public class ControladorVistaGestionPromociones implements ActionListener {

	private IVistaGestionPromociones vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionPromociones(IVistaGestionPromociones vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FuncionalidadOperario op = Sistema.getInstance().getFuncionalidadOperario();
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("AGREGA_PROMO")) {
			cl.show(contentPane, ventana.getVistaAgregaProductoPromocion());
		}
		else if (comando.equalsIgnoreCase("MODIF_PROMO"))
			cl.show(contentPane, ventana.getVistaModificaProductoPromocion());
		else if (comando.equalsIgnoreCase("ELIM_PROMO")) {
			try {
				op.eliminaPromocionProd(this.vista.getIdElim());
				this.vista.ventanaEmergente("Eliminada con exito");
			} catch (PromoInvalida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("AGREGA_PROMO_TEMP")) {
			cl.show(contentPane, ventana.getVistaAgregarPromocionTemporal());
		}
		else if (comando.equalsIgnoreCase("MODIF_PROMO_TEMP")) {
			cl.show(contentPane, ventana.getVistaModificaPromocionTemporal());
		}
		else if (comando.equalsIgnoreCase("ELIM_PROMO_TEMP")) {
			try {
				Sistema.getInstance().getFuncionalidadOperario().eliminaPromocionTemporal(this.vista.getNameElim());
				this.vista.ventanaEmergente("Promo elimianda con exito.");
			} catch (PromoInvalida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaOp());
	}
	

}
