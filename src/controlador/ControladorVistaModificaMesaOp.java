package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import modelo.Mesa;
import negocio.Sistema;
import vista.IVistaModificarMesaOp;
import vista.Ventana;

public class ControladorVistaModificaMesaOp implements ActionListener {
	private IVistaModificarMesaOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaMesaOp(IVistaModificarMesaOp vista, Ventana ventana) {
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
		if (comando.equalsIgnoreCase("CONFIRMA")) {
			Mesa mesa = Sistema.getInstance().getMesas().get(this.ventana.getVistaMesaaAdmin().getNroMesa());
			mesa.setEstado(this.vista.getEstado());
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaMesaOp());
	}
}