package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.IVistaGestionMozoOp;
import vista.Ventana;

public class ControladorVistaGestionMozoOp implements ActionListener {

	private IVistaGestionMozoOp vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;

	private final String MODIFICA = "MODIFICA";
	private final String ESTABLECE = "ESTABLECE";

	
	public ControladorVistaGestionMozoOp(IVistaGestionMozoOp vista, Ventana ventana) {
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
		if (comando.equalsIgnoreCase(MODIFICA)) {
			JOptionPane.showMessageDialog(null, "Modifica.");
		}
		else if (comando.equalsIgnoreCase(ESTABLECE))
			JOptionPane.showMessageDialog(null, "Estados.");
		else if (comando.equalsIgnoreCase("VOLVER"))
			cl.show(contentPane, ventana.getVistaOp());
		
	}

}
