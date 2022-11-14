package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;
import modelo.Producto;

public interface IVistaAgregaProductoPromocion {

	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	boolean getActiva();
	Enumerados.diasDePromo getDiasDePromo();
	boolean isAplica2x1();
	boolean isAplicaDtoPorCant();
	int getDtoPorCant_CantMinima();
	double getDtoPorCant_PrecioUnitario();
	int getIdProd();
}
