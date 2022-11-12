package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class VistaOperario extends JPanel implements IVistaOperario {

	JButton btnGestionMesa;
	JButton btnGestionMozo;
	JButton btnGestionProducto;
	JButton btnGestionPromociones;
	JButton btnModificarOperario;
	JButton btnCerrarSesion;
	private ActionListener actionListener;

	/**
	 * Create the panel.
	 */
	public VistaOperario() {
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Operario",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));

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

		btnGestionPromociones = new JButton("Gestion Promociones");
		btnGestionPromociones.setActionCommand("GESTION_PROMOCIONES");
		panel_3.add(btnGestionPromociones);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		btnModificarOperario = new JButton("Modificar Datos Personales");
		btnModificarOperario.setActionCommand("MODIFICAR");
		panel_5.add(btnModificarOperario);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setActionCommand("CERRAR_SESION");
		panel_6.add(btnCerrarSesion);

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnGestionMesa.addActionListener(actionListener);
		this.btnGestionMozo.addActionListener(actionListener);
		this.btnGestionProducto.addActionListener(actionListener);
		this.btnGestionPromociones.addActionListener(actionListener);
		this.btnModificarOperario.addActionListener(actionListener);
		this.actionListener = actionListener;

	}

}
