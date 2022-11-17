package testGUI;

import java.awt.Component;

import gui.InterfaceOptionPanel;

public class FalsoOptionPane implements InterfaceOptionPanel {

	private String mensaje = null;
	
	
	public String getMensaje() {
		return mensaje;
	}


	@Override
	public void showMessage(Component parent, String mensaje) {
		this.mensaje = mensaje;

	}

}
