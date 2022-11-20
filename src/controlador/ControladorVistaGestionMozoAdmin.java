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
			System.out.println("Enre");
			cl.show(contentPane, ventana.getVistaModificaMozoAdmin());
		}
		else if (comando.equalsIgnoreCase("ALTA")) {
			cl.show(contentPane, ventana.getVistaAltaMozo());
		}
		else if (comando.equalsIgnoreCase("VOLVER"))
			cl.show(contentPane, ventana.getVistaAdmin());
		else if (comando.equalsIgnoreCase("ELIMINA"))
			try {
				Sistema.getInstance().getFuncionalidadAdmin().eliminaMozo(this.vista.getComboBox().getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Eliminado: "+this.vista.getComboBox().getSelectedItem().toString());
				//this.vista.getComboBox().removeItem(this.vista.getComboBox().getSelectedItem());
				this.ventana.vistaGestionMozoAdmin().actualizaComboBox();
				this.ventana.VistaModificaMozoAdmin().actualizaComboBox();
				this.ventana.VistaModificaMozoOp().actualizaComboBox();
				this.ventana.getVistaGestionMesaAdmin().actualizaComboBox();
				this.ventana.getVistaGestionMesaOp().actualizaComboBox();
			} catch (NoExisteMozo_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(comando.equalsIgnoreCase("ACTUALIZAR_REMUNERACION")) {
			Sistema.getInstance().getFuncionalidadAdmin().modificaRemuneracionBasica(this.vista.getRemuneracionBasica());
			this.vista.ventanaEmergente("Remuneracion actualizada");
		}
		else if(comando.equalsIgnoreCase("MUESTRA_ESTAD")) {
			cl.show(contentPane, ventana.getVistaMostrarEstadisticas());
		}
		
	}

}
