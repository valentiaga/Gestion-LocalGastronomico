package vista;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelo.Enumerados;
import modelo.Mozo;

public interface IVistaModificaMozoOp {
	
	void addAcionListener (ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getNyA();
	int getCantHijos();
	Enumerados.estadoMozo getEstadoMozo();
	Mozo getMozo();
	void actualizaComboBox();
	JTextField getTextFieldNyA();
	JTextField getTextFieldCantHijos();
	JComboBox getComboBox();
}
