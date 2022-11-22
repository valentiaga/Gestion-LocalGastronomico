package test;

import java.awt.Component;

import gui.InterfazOptionPanel;
import util.Mensajes;

public class FalsoOptionPane implements InterfazOptionPanel {
    private String mensaje = null;

    public FalsoOptionPane() {
        super();
    }

    @Override
    public void ShowMessage(Component parent, String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}