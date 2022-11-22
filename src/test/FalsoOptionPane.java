package test;

import java.awt.Component;

import gui.InterfazOptionPanel;
import util.Mensajes;

public class FalsoOptionPane implements InterfazOptionPanel {
    private Mensajes mensaje = null;

    public FalsoOptionPane() {
        super();
    }

    @Override
    public void ShowMessage(Component parent, Mensajes mensaje) {
        this.mensaje = mensaje;
    }

    public Mensajes getMensaje() {
        return mensaje;
    }
}