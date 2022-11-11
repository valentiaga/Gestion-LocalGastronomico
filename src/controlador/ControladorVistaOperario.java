package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.IVistaGestionMozoOp;
import vista.IVistaOperario;
import vista.Ventana;

public class ControladorVistaOperario implements ActionListener {

	private IVistaOperario vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	public ControladorVistaOperario(IVistaOperario vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
