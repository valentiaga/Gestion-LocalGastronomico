package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados.estadoOperario;

public interface IVistaRegistrarOperario {

	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getNyA();
    String getUserName();
    String getPassword();
    estadoOperario getActivo();
}
