package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;

public interface IVistaGestionMesaOp {
	int getNroMesa();
	int getIdProd();
	int getCant();
	Enumerados.formaDePago getFormaDePago();
	void addActionListener(ActionListener actionListener);
	void ventanaEmergente(String mensaje);
}
