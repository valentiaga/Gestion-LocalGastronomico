package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.CantHijosInvalida_Exception;
import excepciones.NyARepetido_Exception;
import modelo.Mozo;
import negocio.Sistema;
import vista.IVistaModificaMozoOp;
import vista.Ventana;

public class ControladorVistaModificaMozoOp implements ActionListener {
	private IVistaModificaMozoOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaMozoOp(IVistaModificaMozoOp vista, Ventana ventana) {
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
		
		if (comando.equalsIgnoreCase("CONFIRMAR")) {
			try {
				Sistema.getInstance().getFuncionalidadOperario().modificaMozo(this.vista.getMozo(), this.vista.getEstadoMozo(), this.vista.getCantHijos());
				JOptionPane.showMessageDialog(null, "Datos actualizados.");	
				this.vista.actualizaComboBox();
			} catch (CantHijosInvalida_Exception | NyARepetido_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
		}
		else if (comando.equalsIgnoreCase("VOLVER")) {			
			cl.show(contentPane, ventana.getVistaGestionMozoOp());
			this.vista.getTextFieldCantHijos().setText(String.valueOf(this.vista.getMozo().getCantHijos()));
			this.vista.getTextFieldNyA().setText(this.vista.getMozo().getNyA());
			this.vista.getComboBox().setSelectedItem(this.vista.getMozo().getEstado());
		}
	}

}
