package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaModificaMozo;
import vista.IVistaModificarMesa;
import vista.Ventana;

public class ControladorVistaModificaMozoAdmin implements ActionListener {
	private IVistaModificaMozo vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaMozoAdmin(IVistaModificaMozo vista, Ventana ventana) {
		super();
		this.vista = vista;
		this.vista.addAcionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("CONFIRMAR")) 
			JOptionPane.showMessageDialog(null, "Confirma.");
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionMozoAdmin());

	}

}
