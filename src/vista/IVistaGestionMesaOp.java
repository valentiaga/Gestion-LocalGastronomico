package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;
import modelo.Mozo;

public interface IVistaGestionMesaOp {
	int getNroMesa();
	int getIdProd();
	int getCant();
	Enumerados.formaDePago getFormaDePago();
	void addActionListener(ActionListener actionListener);
	void ventanaEmergente(String mensaje);
	void actualizaComboBox();
	Mozo getMozo();
}
