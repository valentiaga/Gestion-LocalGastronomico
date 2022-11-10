package prueba;

import controlador.ControladorVistaGestionMozoAdmin;
import controlador.ControladorVistaGestionMozoOp;
import modelo.Mozo;
import negocio.Sistema;
import vista.IVistaGestionMozoAdmin;
import vista.IVistaGestionMozoOp;
import vista.Ventana;
import vista.VistaAdmin;
import vista.VistaCambiaContrasena;
import vista.VistaGestionMesaAdmin;
import vista.VistaGestionMesaOp;
import vista.VistaGestionMozoAdmin;
import vista.VistaGestionMozoOp;
import vista.VistaInicial;
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
		VistaInicial vistaIncial = new VistaInicial();
		VistaGestionMesaOp vistaMesaOp = new VistaGestionMesaOp();
		VistaGestionMesaAdmin vistaMesaAdmin = new VistaGestionMesaAdmin();
		VistaCambiaContrasena vistaCambiaContra = new VistaCambiaContrasena();
		VistaOperario vistaOp = new VistaOperario();
		VistaAdmin vistaAdmin = new VistaAdmin();

		Ventana v = new Ventana(vistaIncial, vistaMozoOp, vistaMozoAdmin, vistaMesaOp, vistaMesaAdmin,
				vistaCambiaContra, vistaOp, vistaAdmin);

		/**
		 * ME DI CUENTA QUE NO ME RECONOCE LOS CONSTRUCTORES ESTOS, COMO Q YA SE VE LA
		 * VENTANA EN LA DECLARACION DE VENTANA. POR ESO NO ANDA EL SET ACTIONLISTENER y
		 * tambien toma la vista como nula ya que nunca se inicializo. Anda igual los
		 * botones pq le puse el conrolador a manopla con contructor vacio.
		 **/
		ControladorVistaGestionMozoOp cMozoOp = new ControladorVistaGestionMozoOp(vistaMozoOp, v);
		// ControladorVistaGestionMozoAdmin cMozoAdmin = new ControladorVistaGestionMozoAdmin(vistaMozoAdmin, v);
	}

}
