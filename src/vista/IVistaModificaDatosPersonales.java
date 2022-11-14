package vista;

import java.awt.event.ActionListener;

public interface IVistaModificaDatosPersonales {
	
	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getNyA();
    String getUserName();
    String getPassword();
    boolean getActivo();
    
}
