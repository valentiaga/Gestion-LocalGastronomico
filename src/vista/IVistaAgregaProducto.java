package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados.diasDePromo;

public interface IVistaAgregaProducto {

	    String getNombre();
	    float getPrecioCosto();
	    float getPrecioVenta();
	    int getStockInicial();
	    void addAcionListener (ActionListener actionListener);
	    void limpiarVista();
		void ventanaEmergente(String mensaje);
}
