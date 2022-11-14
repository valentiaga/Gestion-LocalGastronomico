package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import excepciones.NoExisteID_Exception;
import excepciones.PromoInvalida_Exception;
import excepciones.PromoRepetida_Exception;
import negocio.Sistema;
import vista.IVistaAgregarPromocionTemporal;
import vista.Ventana;
import vista.VistaAgregarPromocionTemporal;

public class ControladorVistaModificaPromocionTemporal implements ActionListener{
	
	private IVistaAgregarPromocionTemporal vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	
	public ControladorVistaModificaPromocionTemporal(IVistaAgregarPromocionTemporal vista, Ventana ventana) {
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
				Sistema.getInstance().getFuncionalidadOperario().agregaPromocionTemporal(this.vista.getActiva(), this.vista.getDiasDePromo(), this.vista.getNombre(), this.vista.getFormaDePago(), this.vista.getPorcentajeDesc(), this.vista.isAcumulable(), this.vista.getHoraInicio(), this.vista.getHoraFinal());
				this.vista.ventanaEmergente("Promo agregada con exito.");
				this.vista.limpiarVista();
			} catch (PromoRepetida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionPromociones());
	}

}
