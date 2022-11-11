package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VistaAdmin extends JPanel implements IVistaAdmin {

	private JButton btnCerrarSesion;
	private JButton btnGestionMesa;
	private JButton btnGestionMozo;
	private JButton btnGestionProducto;
	private JButton btnGestionarOperario;
	private ActionListener actionListener;
	/**
	 * Create the panel.
	 */
	public VistaAdmin() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		btnGestionMesa = new JButton("Gestion Mesa");
		btnGestionMesa.setActionCommand("GESTION_MESA");
		panel_1.add(btnGestionMesa);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		btnGestionMozo = new JButton("Gestion Mozo");
		btnGestionMozo.setActionCommand("GESTION_MOZO");
		panel_4.add(btnGestionMozo);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		btnGestionProducto = new JButton("Gestion Producto");
		btnGestionProducto.setActionCommand("GESTION_PRODUCTO");
		panel_2.add(btnGestionProducto);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		btnGestionarOperario = new JButton("Gestion Operario");
		btnGestionarOperario.setActionCommand("GESTION_OPERARIO");
		panel_3.add(btnGestionarOperario);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setActionCommand("CERRAR_SESION");
		panel_5.add(btnCerrarSesion);

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnGestionarOperario.addActionListener(actionListener);
		this.btnGestionMesa.addActionListener(actionListener);
		this.btnGestionMozo.addActionListener(actionListener);
		this.btnGestionProducto.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

}
