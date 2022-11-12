package controlador;

import java.awt.CardLayout;
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

public class ControladorVistaGestionMozoAdmin implements ActionListener {

	private IVistaGestionMozoAdmin vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaGestionMozoAdmin(IVistaGestionMozoAdmin vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		CardLayout cl = (CardLayout) contentPane.getLayout();
		if (comando.equalsIgnoreCase("MODIFICA")) 
			JOptionPane.showMessageDialog(null, "Modifica.");
		else if (comando.equalsIgnoreCase("ESTABLECE"))
			JOptionPane.showMessageDialog(null, "Estados.");
		else if (comando.equalsIgnoreCase("ALTA"))
			JOptionPane.showMessageDialog(null, "Alta.");
		else if (comando.equalsIgnoreCase("VOLVER"))
			cl.show(contentPane, ventana.getVistaAdmin());
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
