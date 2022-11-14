package vista;

import java.awt.event.ActionListener;

public interface IVistaModificaProducto {
	
	    int getidProd();
	    String getNombre();
	    double getPrecioCosto();
	    double getPrecioVenta();
	    int getStockInicial();
	    void addAcionListener (ActionListener actionListener);
	    void limpiarVista();
		void ventanaEmergente(String mensaje);
}
