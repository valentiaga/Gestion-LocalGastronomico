package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaGestionMesaAdmin;
import vista.IVistaModificarMesa;
import vista.Ventana;

public class ControladorVistaModificaMesa implements ActionListener {
	private IVistaModificarMesa vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaMesa(IVistaModificarMesa vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("CONFIRMA")) 
			JOptionPane.showMessageDialog(null, "Confirma.");
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaMesaAdmin());

	}

}
