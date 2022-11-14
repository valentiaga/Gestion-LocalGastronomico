package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Mesa;
import negocio.Sistema;
import vista.IVistaModificarMesa;
import vista.Ventana;

public class ControladorVistaModificaMesaAdmin implements ActionListener {
	private IVistaModificarMesa vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaModificaMesaAdmin(IVistaModificarMesa vista, Ventana ventana) {
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
			mesa.setCantPax(this.vista.getCantSillas());
			mesa.setEstado(this.vista.getEstado());
			System.out.println(mesa.getEstado()+" "+mesa.getCantPax());
			JOptionPane.showMessageDialog(null, "Confirma.");
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaMesaAdmin());

	}

}
