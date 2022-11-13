package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.CantHijosInvalida_Exception;
import excepciones.EdadInvalida_Exception;
import excepciones.NoExisteMozo_Exception;
import modelo.Enumerados;
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
		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("MODIFICA")) {
			cl.show(contentPane, ventana.getVistaModificaMozo());
			JOptionPane.showMessageDialog(null, "Modifica.");
		}
		else if (comando.equalsIgnoreCase("ESTABLECE"))
			JOptionPane.showMessageDialog(null, "Estados.");
		else if (comando.equalsIgnoreCase("ALTA")) {
			try {
				Sistema.getInstance().getFuncionalidadAdmin().agregaMozo(this.vista.getNyA(), null, this.vista.getCantHijos(), Enumerados.estadoMozo.ACTIVO);
				JOptionPane.showMessageDialog(null, "Alta.");
			} catch (EdadInvalida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} catch (CantHijosInvalida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER"))
			cl.show(contentPane, ventana.getVistaAdmin());
		else if (comando.equalsIgnoreCase("ELIMINA"))
			try {
				Sistema.getInstance().getFuncionalidadAdmin().eliminaMozo(this.vista.getComboBox().getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Eliminado: "+this.vista.getComboBox().getSelectedItem().toString());
				this.vista.getComboBox().removeItem(this.vista.getComboBox().getSelectedItem());
			} catch (NoExisteMozo_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}
