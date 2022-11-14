package vista;

import java.awt.CardLayout;
import java.awt.HeadlessException;
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
	private VistaModificaMozo vistaModificaMozoAdmin;
	private VistaAltaMozo vistaAltaMozo;
	private VistaAgregaProducto vistaAgregaProducto;
	private VistaAgregaProducto vistaAgregaProductoPromocion;
	private VistaModificaDatosPersonales vistaModificaDatosPersonales;
	private VistaModificaProducto vistaModificaProducto;
	private VistaModificaProductoPromocion vistaModificaProductoPromocion;
	private VistaModificaPromocionTemporal vistaModificaPromocionTemporal;
	private VistaRegistrarOperario vistaRegistraOp;


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
	 * @param vistaModificaMesaOp 
	 */

	
	public JPanel getContentPane() {
		return this.contentPane;
	}

	public Ventana(VistaInicial vistaInicial, VistaGestionMozoOp vistaGestionMozoOp,
			VistaGestionMozoAdmin vistaGestionMozoAdmin, VistaGestionMesaOp vistaGestionMesaOp,
			VistaGestionMesaAdmin vistaGestionMesaAdmin, VistaGestionPromociones vistaGestionPromociones,
			VistaCambiaContrasena vistaCambiaContrasena, VistaOperario vistaOp, VistaAdmin vistaAdmin,
			VistaGestionProductoOp vistaGestionProductoOp, VistaGestionProductoAdmin vistaGestionProductoAdmin,
			VistaModificarMesaAdmin vistaModificaMesa, VistaModificarMesaOp vistaModificaMesaOp,
			VistaModificaMozo vistaModificaMozoAdmin, VistaAltaMozo vistaAltaMozo,
			VistaAgregaProducto vistaAgregaProducto, VistaAgregaProducto vistaAgregaProductoPromocion,
			VistaModificaDatosPersonales vistaModificaDatosPersonales, VistaModificaProducto vistaModificaProducto,
			VistaModificaProductoPromocion vistaModificaProductoPromocion,
			VistaModificaPromocionTemporal vistaModificaPromocionTemporal, VistaRegistrarOperario vistaRegistraOp)
			throws HeadlessException {
		super();
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
		this.vistaAltaMozo = vistaAltaMozo;
		this.vistaAgregaProducto = vistaAgregaProducto;
		this.vistaAgregaProductoPromocion = vistaAgregaProductoPromocion;
		this.vistaModificaDatosPersonales = vistaModificaDatosPersonales;
		this.vistaModificaProducto = vistaModificaProducto;
		this.vistaModificaProductoPromocion = vistaModificaProductoPromocion;
		this.vistaModificaPromocionTemporal = vistaModificaPromocionTemporal;
		this.vistaRegistraOp = vistaRegistraOp;
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 354);
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		
//		Sistema.getInstance().setFuncionalidadAdmin(new FuncionalidadAdmin(Administrador.getInstance()));
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(vistaOp, "vistaOp");
		contentPane.add(vistaAdmin, "vistaAdmin");
		contentPane.add(vistaGestionMesaOp, "vistaMesaOp");
		contentPane.add(vistaInicial, "vistaInicial");
		contentPane.add(vistaGestionMozoAdmin, "vistaGestionMozoAdmin");
		contentPane.add(vistaGestionMozoOp, "vistaGestionMozoOp");
		contentPane.add(vistaGestionMesaAdmin, "vistaMesaAdmin");
		contentPane.add(vistaCambiaContrasena, "vistaCambiaContrasena");
		contentPane.add(vistaGestionProductoAdmin, "vistaGestionProductoAdmin");
		contentPane.add(vistaGestionProductoOp, "vistaGestionProductoOp");
		contentPane.add(vistaModificaMesa, "vistaModificaMesa");
		contentPane.add(vistaModificaMesaOp, "vistaModificaMesaOp");
		contentPane.add(vistaModificaMozoAdmin, "vistaModificaMozoAdmin");
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
		
	}

	public String getVistaInicial() {
		return "vistaInicial";
	}

	public String getVistaAltaMozo() {
		return "vistaAltaMozo";
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

	public VistaGestionMesaAdmin getVistaMesaaAdmin() {
		return this.vistaGestionMesaAdmin;
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
	
	public String getVistaModificaMozo() {
		return "vistaModificaMozoAdmin";
	}
	


}
