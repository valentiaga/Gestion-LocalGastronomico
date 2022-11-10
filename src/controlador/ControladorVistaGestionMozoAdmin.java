package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.NoExisteMozo_Exception;
import negocio.Sistema;
import vista.IVistaGestionMesaOp;
import vista.IVistaGestionMozoAdmin;
import vista.Ventana;
import vista.VistaGestionMozoAdmin;

public class ControladorVistaGestionMozoAdmin extends ControladorVistaGestionMozoOp implements ActionListener {

	private IVistaGestionMozoAdmin vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionMozoAdmin(IVistaGestionMozoAdmin vista, Ventana ventana) {
		super();
		this.vista = vista;
		//this.vista.addActionListener(this);
		this.ventana = ventana;
	}
	
	public ControladorVistaGestionMozoAdmin() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("ALTA"))
			JOptionPane.showMessageDialog(null, "Alta.");
		else if (comando.equalsIgnoreCase("ELIMINA"))
			try {
				Sistema.getInstance().getFuncionalidadAdmin().eliminaMozo(this.vista.getComboBox().getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Eliminado: "+this.vista.getComboBox().getSelectedItem().toString());
			} catch (NoExisteMozo_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}
