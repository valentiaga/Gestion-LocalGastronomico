package vista;

import java.awt.event.ActionListener;

public interface IVistaModificaProducto {
	
	    String getNombre();
	    float getPrecioCosto();
	    float getPrecioVenta();
	    int getStockInicial();
	    int getIdProd();
	    void addAcionListener (ActionListener actionListener);
	    void limpiarVista();
		void ventanaEmergente(String mensaje);
}
