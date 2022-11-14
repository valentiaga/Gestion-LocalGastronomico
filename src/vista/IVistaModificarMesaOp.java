package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;
import modelo.Enumerados.estadoMesa;

public interface IVistaModificarMesaOp {
	estadoMesa getEstado();
	void addActionListener(ActionListener actionListener);
}
