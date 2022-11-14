package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import excepciones.NoExisteID_Exception;
import excepciones.PromoInvalida_Exception;
import negocio.Sistema;
import vista.IVistaAgregaProductoPromocion;
import vista.IVistaGestionProductoOp;
import vista.Ventana;

public class ControladorVistaAgregaProductoPromocion implements ActionListener{
	
	private IVistaAgregaProductoPromocion vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("MODIFICA")) {
			try {
				Sistema.getInstance().getFuncionalidadOperario().modificaPromocionProd(this.vista.getIdProm(), this.vista.getActiva(), this.vista.getDiasDePromo(), this.vista.isAplica2x1(),this.vista.isAplicaDtoPorCant(),this.vista.getDtoPorCant_CantMinima(), this.vista.getDtoPorCant_PrecioUnitario());
			} catch (PromoInvalida_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoExisteID_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cl.show(contentPane, ventana.getVistaGestionPromociones());
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionPromociones());
	}

}
