package prueba;

import controlador.ControladorVistaAdmin;
import controlador.ControladorVistaGestionMesaAdmin;
import controlador.ControladorVistaGestionMesaOp;
import controlador.ControladorVistaGestionMozoAdmin;
import controlador.ControladorVistaGestionMozoOp;
import controlador.ControladorVistaGestionProductoAdmin;
import controlador.ControladorVistaInicial;
import controlador.ControladorVistaModificaMesa;
import controlador.ControladorVistaOperario;
import modelo.Mozo;
import negocio.Sistema;
import vista.Ventana;
import vista.VistaAdmin;
import vista.VistaCambiaContrasena;
import vista.VistaGestionMesaAdmin;
import vista.VistaGestionMesaOp;
import vista.VistaGestionMozoAdmin;
import vista.VistaGestionMozoOp;
import vista.VistaGestionProductoAdmin;
import vista.VistaGestionProductoOp;
import vista.VistaInicial;
import vista.VistaModificarMesa;
import vista.VistaOperario;

public class Prueba {

	public static void main(String[] args) {

		Mozo mozo = new Mozo("Marti", 3);
		Mozo mozo2 = new Mozo("Valen", 0);
		Mozo mozo3 = new Mozo("Pau", 2);

		Sistema.getInstance().getMozos().put("Marti", mozo);
		Sistema.getInstance().getMozos().put("Valen", mozo2);
		Sistema.getInstance().getMozos().put("Pau", mozo3);

		VistaGestionMozoOp vistaMozoOp = new VistaGestionMozoOp();
		VistaGestionMozoAdmin vistaMozoAdmin = new VistaGestionMozoAdmin();
		VistaInicial vistaInicial = new VistaInicial();
		VistaGestionMesaOp vistaMesaOp = new VistaGestionMesaOp();
		VistaGestionMesaAdmin vistaMesaAdmin = new VistaGestionMesaAdmin();
		VistaCambiaContrasena vistaCambiaContra = new VistaCambiaContrasena();
		VistaOperario vistaOp = new VistaOperario();
		VistaAdmin vistaAdmin = new VistaAdmin();
		VistaGestionProductoOp vistaProductoOp = new VistaGestionProductoOp();
		VistaGestionProductoAdmin vistaProductoAdmin = new VistaGestionProductoAdmin();
		VistaModificarMesa vistaModificarMesa = new VistaModificarMesa();
		Sistema.getInstance().seteaAdmin();
		
		Ventana v = new Ventana(vistaInicial, vistaMozoOp, vistaMozoAdmin, vistaMesaOp, vistaMesaAdmin,
				vistaCambiaContra, vistaOp, vistaAdmin, vistaProductoOp, vistaProductoAdmin, vistaModificarMesa);

		ControladorVistaOperario cOperario = new ControladorVistaOperario(vistaOp, v);
		ControladorVistaAdmin cAdmin = new ControladorVistaAdmin(vistaAdmin, v);
		ControladorVistaInicial cInicial = new ControladorVistaInicial(vistaInicial, v);
		ControladorVistaGestionMozoOp cMozoOp = new ControladorVistaGestionMozoOp(vistaMozoOp, v);
		ControladorVistaGestionMozoAdmin cMozoAdmin = new ControladorVistaGestionMozoAdmin(vistaMozoAdmin, v);
		ControladorVistaGestionMesaOp cMesaOp = new ControladorVistaGestionMesaOp(vistaMesaOp, v);
		ControladorVistaGestionMesaAdmin cMesaAdmin = new ControladorVistaGestionMesaAdmin(vistaMesaAdmin, v);
		ControladorVistaGestionProductoAdmin cProductoAdmin = new ControladorVistaGestionProductoAdmin(vistaProductoAdmin, v);
		ControladorVistaModificaMesa cModificaMesa = new ControladorVistaModificaMesa(vistaModificarMesa, v);
	}

}
