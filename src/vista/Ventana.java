package vista;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ventana extends JFrame {

	private JPanel contentPane;
	private ActionListener actionListener;
	private VistaInicial vistaInicial;
	private VistaGestionMozoOp vistaGestionMozoOp;
	private VistaGestionMozoAdmin vistaGestionMozoAdmin;
	private VistaGestionMesaOp vistaGestionMesaOp;
	private VistaGestionMesaAdmin vistaGestionMesaAdmin;
	private VistaGestionPromociones vistaGestionPromociones;
	private VistaCambiaContrasena vistaCambiaContrasena;
	private VistaOperario vistaOp;
	private VistaAdmin vistaAdmin;
	private VistaGestionProductoOp vistaGestionProductoOp;
	private VistaGestionProductoAdmin vistaGestionProductoAdmin;
	private VistaModificarMesaAdmin vistaModificaMesa;
	private VistaModificarMesaOp vistaModificaMesaOp;
	private VistaModificaMozoAdmin vistaModificaMozoAdmin;
	private VistaModificaMozoOp vistaModificaMozoOp;
	private VistaAltaMozo vistaAltaMozo;
	private VistaAgregaProducto vistaAgregaProducto;
	private VistaAgregaProductoPromocion vistaAgregaProductoPromocion;
	private VistaModificaDatosPersonales vistaModificaDatosPersonales;
	private VistaModificaProducto vistaModificaProducto;
	private VistaModificaProductoPromocion vistaModificaProductoPromocion;
	private VistaModificaPromocionTemporal vistaModificaPromocionTemporal;
	private VistaRegistrarOperario vistaRegistraOp;
	private VistaAgregarPromocionTemporal vistaAgregaPromoTemp;
	private VistaMostrarEstadisticas vistaMostrarEstadisticas;
	
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Ventana frame = new Ventana();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 * 
	 * @param vistaModificaMesaOp
	 */
	public Ventana(VistaInicial vistaInicial, VistaGestionMozoOp vistaGestionMozoOp,
			VistaGestionMozoAdmin vistaGestionMozoAdmin, VistaGestionMesaOp vistaGestionMesaOp,
			VistaGestionMesaAdmin vistaGestionMesaAdmin, VistaGestionPromociones vistaGestionPromociones,
			VistaCambiaContrasena vistaCambiaContrasena, VistaOperario vistaOp, VistaAdmin vistaAdmin,
			VistaGestionProductoOp vistaGestionProductoOp, VistaGestionProductoAdmin vistaGestionProductoAdmin,
			VistaModificarMesaAdmin vistaModificaMesa, VistaModificarMesaOp vistaModificaMesaOp,
			VistaModificaMozoAdmin vistaModificaMozoAdmin, VistaAltaMozo vistaAltaMozo,
			VistaAgregaProducto vistaAgregaProducto, VistaAgregaProductoPromocion vistaAgregaProductoPromocion,
			VistaModificaDatosPersonales vistaModificaDatosPersonales, VistaModificaProducto vistaModificaProducto,
			VistaModificaProductoPromocion vistaModificaProductoPromocion,
			VistaModificaPromocionTemporal vistaModificaPromocionTemporal, VistaRegistrarOperario vistaRegistraOp,
			VistaModificaMozoOp vistaModificaMozoOp, VistaAgregarPromocionTemporal vistaAgregaPromoTemp, VistaMostrarEstadisticas vistaMostrarEstadisticas) {
		this.vistaInicial = vistaInicial;
		this.vistaGestionMozoOp = vistaGestionMozoOp;
		this.vistaGestionMozoAdmin = vistaGestionMozoAdmin;
		this.vistaGestionMesaOp = vistaGestionMesaOp;
		this.vistaGestionMesaAdmin = vistaGestionMesaAdmin;
		this.vistaGestionPromociones = vistaGestionPromociones;
		this.vistaCambiaContrasena = vistaCambiaContrasena;
		this.vistaOp = vistaOp;
		this.vistaAdmin = vistaAdmin;
		this.vistaGestionProductoOp = vistaGestionProductoOp;
		this.vistaGestionProductoAdmin = vistaGestionProductoAdmin;
		this.vistaModificaMesa = vistaModificaMesa;
		this.vistaModificaMesaOp = vistaModificaMesaOp;
		this.vistaModificaMozoAdmin = vistaModificaMozoAdmin;
		this.vistaModificaMozoOp = vistaModificaMozoOp;
		this.vistaAltaMozo = vistaAltaMozo;
		this.vistaAgregaProducto = vistaAgregaProducto; 
		this.vistaAgregaProductoPromocion = vistaAgregaProductoPromocion;
		this.vistaModificaDatosPersonales = vistaModificaDatosPersonales;
		this.vistaModificaProducto = vistaModificaProducto;
		this.vistaModificaProductoPromocion = vistaModificaProductoPromocion;
		this.vistaModificaPromocionTemporal = vistaModificaPromocionTemporal;
		this.vistaRegistraOp = vistaRegistraOp;
		this.vistaAgregaPromoTemp = vistaAgregaPromoTemp;
		this.vistaMostrarEstadisticas = vistaMostrarEstadisticas;

		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 354);
		this.contentPane = new JPanel();
		setContentPane(contentPane);

		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(vistaInicial, "vistaInicial");
		contentPane.add(vistaOp, "vistaOp");
		contentPane.add(vistaAdmin, "vistaAdmin");
		contentPane.add(vistaGestionMesaOp, "vistaMesaOp");
		contentPane.add(vistaGestionMozoAdmin, "vistaGestionMozoAdmin");
		contentPane.add(vistaGestionMozoOp, "vistaGestionMozoOp");
		contentPane.add(vistaGestionMesaAdmin, "vistaMesaAdmin");
		contentPane.add(vistaCambiaContrasena, "vistaCambiaContrasena");
		contentPane.add(vistaGestionProductoAdmin, "vistaGestionProductoAdmin");
		contentPane.add(vistaGestionProductoOp, "vistaGestionProductoOp");
		contentPane.add(vistaModificaMesa, "vistaModificaMesa");
		contentPane.add(vistaModificaMesaOp, "vistaModificaMesaOp");
		contentPane.add(vistaModificaMozoAdmin, "vistaModificaMozoAdmin");
		contentPane.add(vistaModificaMozoOp, "vistaModificaMozoOp");
		contentPane.add(vistaAltaMozo, "vistaAltaMozo");
		contentPane.add(vistaRegistraOp, "vistaRegistraOp");
		contentPane.add(vistaModificaPromocionTemporal, "vistaModificaPromocionTemporal");
		contentPane.add(vistaModificaProductoPromocion, "vistaModificaProductoPromocion");
		contentPane.add(vistaModificaProducto, "vistaModificaProducto");
		contentPane.add(vistaModificaDatosPersonales, "vistaModificaDatosPersonales");
		contentPane.add(vistaAgregaProductoPromocion, "vistaAgregaProductoPromocion");
		contentPane.add(vistaAgregaProducto, "vistaAgregaProducto");
		contentPane.add(vistaAltaMozo, "vistaAltaMozo");
		contentPane.add(vistaGestionProductoAdmin, "vistaGestionProductoAdmin");
		contentPane.add(vistaGestionProductoOp, "vistaGestionProductoOp");
		contentPane.add(vistaGestionPromociones, "vistaGestionPromociones");
		contentPane.add(vistaAgregaProductoPromocion, "vistaAgregaProductoPromocion");
		contentPane.add(vistaAgregaPromoTemp, "vistaAgregaPromoTemp");
		contentPane.add(vistaMostrarEstadisticas, "vistaMostrarEstadisticas");
	}

	public JPanel getContentPane() {
		return this.contentPane;
	}
	public VistaGestionMozoAdmin VistaGestionMozoAdmin() {
		return this.vistaGestionMozoAdmin;
	}
	public VistaModificaMozoAdmin VistaModificaMozoAdmin() {
		return this.vistaModificaMozoAdmin;
	}
	public VistaModificaMozoOp VistaModificaMozoOp() {
		return this.vistaModificaMozoOp;
	}
	
	
	public String getVistaMostrarEstadisticas() {
		return "vistaMostrarEstadisticas";
	}
	public String getVistaGestionProductoAdmin() {
		return "vistaGestionProductoAdmin";
	}
	public String getVistaAgregarPromocionTemporal() {
		return "vistaAgregaPromoTemp";
	}
	public VistaModificaDatosPersonales obtieneVistaModificaDatos() {
		return vistaModificaDatosPersonales;
	}
	
	public String getVistaGestionProductoOp() {
		return "vistaGestionProductoOp";
	}
	
	public String getVistaModificaProducto() {
		return "vistaModificaProducto";
	}
	public String getVistaInicial() {
		return "vistaInicial";
	}

	public String getVistaAltaMozo() {
		return "vistaAltaMozo";
	}

	public String getVistaAgregaProducto() {
		return "vistaAgregaProducto";
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

	public String getVistaModificaDatosPersonales() {
		return "vistaModificaDatosPersonales";
	}
	public VistaGestionMesaAdmin getVistaMesaaAdmin() {
		return this.vistaGestionMesaAdmin;
	}

	public VistaGestionMesaOp getVistaMesaaOp() {
		return this.vistaGestionMesaOp;
	}
	

	public String getVistaOp() {
		return "vistaOp";
	}

	public String getVistaAdmin() {
		return "vistaAdmin";
	}


	public String getVistaModificaMesa() {
		return "vistaModificaMesa";
	}

	public String getVistaModificaMozoAdmin() {
		return "vistaModificaMozoAdmin";
	}

	public String getVistaModificaMozoOp() {
		return "vistaModificaMozoOp";
	}

	public String getVistaRegistraOp() {
		return "vistaRegistraOp";
	}

	public String getVistaModificaMesaOp() {
		return "vistaModificaMesaOp";
	}
	public String getVistaAgregaProductoPromocion() {
		return "vistaAgregaProductoPromocion";
	}
	
	public VistaGestionMozoAdmin vistaGestionMozoAdmin() {
		return this.vistaGestionMozoAdmin;
	}

	public VistaGestionMozoOp vistaGestionMozoOp() {
		return this.vistaGestionMozoOp;
	}

	public VistaGestionMesaOp getVistaGestionMesaOp() {
		return vistaGestionMesaOp;
	}

	public VistaGestionMesaAdmin getVistaGestionMesaAdmin() {
		return vistaGestionMesaAdmin;
	}

	public VistaAgregaProducto getVistaAgregaaProducto() {
		return vistaAgregaProducto;
	}

	public VistaAgregaProductoPromocion getVistaAgregaaProductoPromocion() {
		return vistaAgregaProductoPromocion;
	}

	public String getVistaModificaProductoPromocion() {
		return "vistaModificaProductoPromocion";
	}

	public String getVistaModificaPromocionTemporal() {
		return "vistaModificaPromocionTemporal";
	}

	public String getVistaModificaaProducto() {
		return "vistaModificaProducto";
	}
	
	public String getVistaGestionPromociones() {
		return "vistaGestionPromociones";
	}
	
	

}
