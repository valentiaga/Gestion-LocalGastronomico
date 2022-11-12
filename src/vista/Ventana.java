package vista;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Administrador;
import negocio.FuncionalidadAdmin;
import negocio.Sistema;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private ActionListener actionListener;
	private VistaInicial vistaInicial;
	private VistaGestionMozoOp vistaGestionMozoOp;
	private VistaGestionMozoAdmin vistaGestionMozoAdmin;
	private VistaGestionMesaOp vistaMesaOp;
	private VistaGestionMesaAdmin vistaMesaAdmin;
	private VistaCambiaContrasena vistaCambiaContrasena;
	private VistaOperario vistaOp;
	private VistaAdmin vistaAdmin;
	private VistaGestionProductoOp vistaProductoOp;
	private VistaGestionProductoAdmin vistaProductoAdmin;
	private VistaModificarMesa vistaModificaMesa;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Ventana(VistaInicial vistaInicial, VistaGestionMozoOp vistaMozoOp, VistaGestionMozoAdmin vistaMozoAdmin, VistaGestionMesaOp vistaMesaOp, VistaGestionMesaAdmin vistaMesaAdmin, VistaCambiaContrasena vistaCambiaContrasena, VistaOperario vistaOp, VistaAdmin vistaAdmin, VistaGestionProductoOp vistaProductoOp, VistaGestionProductoAdmin vistaProductoAdmin, VistaModificarMesa vistaModificaMesa) {
		this.vistaGestionMozoOp = vistaMozoOp;
		this.vistaGestionMozoAdmin = vistaMozoAdmin;
		this.vistaAdmin = vistaAdmin;
		this.vistaCambiaContrasena = vistaCambiaContrasena;
		this.vistaInicial = vistaInicial;
		this.vistaMesaAdmin = vistaMesaAdmin;
		this.vistaMesaOp = vistaMesaOp;
		this.vistaOp = vistaOp;
		this.vistaProductoAdmin = vistaProductoAdmin;
		this.vistaProductoOp = vistaProductoOp;
		this.vistaModificaMesa = vistaModificaMesa;
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 354);
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		
//		Sistema.getInstance().setFuncionalidadAdmin(new FuncionalidadAdmin(Administrador.getInstance()));
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(vistaAdmin, "vistaAdmin");
		contentPane.add(vistaMesaOp, "vistaMesaOp");
		contentPane.add(vistaInicial, "vistaInicial");
		contentPane.add(vistaOp, "vistaOp");
		contentPane.add(vistaMozoAdmin, "vistaGestionMozoAdmin");
		contentPane.add(vistaMozoOp, "vistaGestionMozoOp");
		contentPane.add(vistaMesaAdmin, "vistaMesaAdmin");
		contentPane.add(vistaCambiaContrasena, "vistaCambiaContrasena");
		contentPane.add(vistaProductoAdmin, "vistaProductoAdmin");
		contentPane.add(vistaProductoOp, "vistaProductoOp");
		contentPane.add(vistaModificaMesa, "vistaModificaMesa");
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}

	public String getVistaInicial() {
		return "vistaInicial";
	}

	public String getVistaGestionMozoOp() {
		return "vistaGestionMozoOp";
	}

	public String getVistaGestionMozoAdmin() {
		return "vistaGestionMozoAdmin";
	}

	public String getVistaMesaOp() {
		return "vistaMesaOp";
	}

	public String getVistaMesaAdmin() {
		return "vistaMesaAdmin";
	}

	public String getVistaCambiaContrasena() {
		return "vistaCambiaContrasena";
	}

	public String getVistaOp() {
		return "vistaOp";
	}

	public String getVistaAdmin() {
		return "vistaAdmin";
	}

	public String getVistaProductoOp() {
		return "vistaProductoOp";
	}

	public String getVistaProductoAdmin() {
		return "vistaProductoAdmin";
	}

	public String getVistaModificaMesa() {
		return "vistaModificaMesa";
	}
	
	
	


}
