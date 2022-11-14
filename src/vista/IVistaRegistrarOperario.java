package vista;

import java.awt.event.ActionListener;

public interface IVistaRegistrarOperario {

	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getNyA();
    String getUserName();
    String getPassword();
    boolean getActivo();
}
