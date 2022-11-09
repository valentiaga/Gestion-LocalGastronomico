package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VistaAdmin extends JPanel implements IVistaAdmin {

	/**
	 * Create the panel.
	 */
	public VistaAdmin() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnGestionMesa = new JButton("Gestion Mesa");
		panel_1.add(btnGestionMesa);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnGestionMozo = new JButton("Gestion Mozo");
		panel_4.add(btnGestionMozo);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnGestionProducto = new JButton("Gestion Producto");
		panel_2.add(btnGestionProducto);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnGestionarOperario = new JButton("Gestion Operario");
		panel_3.add(btnGestionarOperario);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		panel_5.add(btnCerrarSesion);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		
		JButton btnGestionProducto_1 = new JButton("Gestion Producto");
		panel_2_1.add(btnGestionProducto_1);

	}

}
