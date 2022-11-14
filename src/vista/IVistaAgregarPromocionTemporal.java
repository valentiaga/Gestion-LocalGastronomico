package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;

public interface IVistaAgregarPromocionTemporal {

	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	
	boolean getActiva();
	Enumerados.diasDePromo getDiasDePromo();		
	String getNombre();									
    Enumerados.formaDePago getFormaDePago();
    int getPorcentajeDesc();
    boolean isAcumulable();
    int getHoraInicio();
    int getHoraFinal();
}
