package gui;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MiOptionPane implements InterfaceOptionPanel {

	
	public MiOptionPane() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMessage(Component parent, String mensaje) {
		JOptionPane.showMessageDialog(parent, mensaje);
	}

}
