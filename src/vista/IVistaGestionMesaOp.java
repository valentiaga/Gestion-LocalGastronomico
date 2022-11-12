package vista;

import java.awt.event.ActionListener;

public interface IVistaGestionMesaOp {
	int getNroMesa();
	int getIdProd();
	int getCant();
	void addActionListener(ActionListener actionListener);
	void ventanaEmergente(String mensaje);
}
