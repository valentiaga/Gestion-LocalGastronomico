package prueba;

import java.io.IOException;

import controlador.ControladorVistaAdmin;
import controlador.ControladorVistaGestionMesaAdmin;
import controlador.ControladorVistaGestionMesaOp;
import controlador.ControladorVistaGestionMozoAdmin;
import controlador.ControladorVistaGestionMozoOp;
import controlador.ControladorVistaGestionProductoAdmin;
import controlador.ControladorVistaInicial;
import controlador.ControladorVistaModificaMesaAdmin;
import controlador.ControladorVistaModificaMesaOp;
import controlador.ControladorVistaModificaMozoAdmin;
import controlador.ControladorVistaModificaMozoOp;
import controlador.ControladorVistaOperario;
import excepciones.CantComensalesInvalida_Exception;
import excepciones.precioInvalido_Exception;
import modelo.Administrador;
import modelo.Mozo;
import negocio.FuncionalidadAdmin;
import negocio.Sistema;
import persistencia.Persiste;
import vista.Ventana;
import vista.VistaAdmin;
import vista.VistaAgregaProducto;
import vista.VistaAltaMozo;
import vista.VistaCambiaContrasena;
import vista.VistaGestionMesaAdmin;
import vista.VistaGestionMesaOp;
import vista.VistaGestionMozoAdmin;
import vista.VistaGestionMozoOp;
import vista.VistaGestionProductoAdmin;
import vista.VistaGestionProductoOp;
import vista.VistaInicial;
import vista.VistaModificaDatosPersonales;
import vista.VistaModificaMozoAdmin;
import vista.VistaModificaMozoOp;
import vista.VistaModificaOp;
import vista.VistaModificaProducto;
import vista.VistaModificaProductoPromocion;
import vista.VistaModificaPromocionTemporal;
import vista.VistaModificarMesaAdmin;
import vista.VistaModificarMesaOp;
import vista.VistaOperario;
import vista.VistaRegistrarOperario;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			Persiste.getInstancia().leer();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
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
		VistaModificarMesaAdmin vistaModificarMesa = new VistaModificarMesaAdmin();
		VistaModificarMesaOp vistaModificaMesaOp = new VistaModificarMesaOp();
		VistaModificaMozoAdmin vistaModificaMozoAdmin = new VistaModificaMozoAdmin();
		VistaModificaMozoOp vistaModificaMozoOp = new VistaModificaMozoOp();
		VistaAltaMozo vistaAltaMozo = new VistaAltaMozo();
		VistaAgregaProducto vistaAgregaProducto = new  VistaAgregaProducto();
		VistaAgregaProducto vistaAgregaProductoPromocion = new VistaAgregaProducto();
		VistaModificaDatosPersonales vistaModificaDatosPersonales= new  VistaModificaDatosPersonales();
		VistaModificaProducto vistaModificaProducto = new VistaModificaProducto();
		VistaModificaProductoPromocion vistaModificaProductoPromocion = new VistaModificaProductoPromocion();
		VistaModificaPromocionTemporal vistaModificaPromocionTemporal = new VistaModificaPromocionTemporal();
		VistaRegistrarOperario vistaRegistraOp = new VistaRegistrarOperario();
		VistaModificaOp vistaModificaOp = new VistaModificaOp();
		
		Sistema.getInstance().seteaAdmin();
		Sistema.getInstance().setFuncionalidadAdmin(new FuncionalidadAdmin(Administrador.getInstance()));
		try {
			Sistema.getInstance().getFuncionalidadAdmin().agregaProducto("Pizza", 10, 20, 10);
		} catch (precioInvalido_Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Sistema.getInstance().getFuncionalidadAdmin().agregaMesa(4);
			Sistema.getInstance().getFuncionalidadAdmin().agregaMesa(5);
			//System.out.println(Sistema.getInstance().getMesas().get(0).getCantPax());
		} catch (CantComensalesInvalida_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Ventana v = new Ventana(vistaInicial, vistaMozoOp, vistaMozoAdmin, vistaMesaOp, vistaMesaAdmin, vistaCambiaContra, vistaOp, vistaAdmin, vistaProductoOp, vistaProductoAdmin, vistaModificarMesa, vistaModificaMesaOp, vistaModificaMozoAdmin, vistaAltaMozo);


		Ventana v = new Ventana(vistaInicial, vistaMozoOp, vistaMozoAdmin, vistaMesaOp, vistaMesaAdmin, null,
				vistaCambiaContra, vistaOp, vistaAdmin, vistaProductoOp, vistaProductoAdmin, vistaModificarMesa,
				vistaModificaMesaOp, vistaModificaMozoAdmin, vistaAltaMozo, vistaAgregaProducto,
				vistaAgregaProductoPromocion, vistaModificaDatosPersonales, vistaModificaProducto,
				vistaModificaProductoPromocion, vistaModificaPromocionTemporal, vistaRegistraOp, vistaModificaMozoOp, vistaModificaOp);
		
		ControladorVistaOperario cOperario = new ControladorVistaOperario(vistaOp, v);
		ControladorVistaAdmin cAdmin = new ControladorVistaAdmin(vistaAdmin, v);
		ControladorVistaInicial cInicial = new ControladorVistaInicial(vistaInicial, v);
		ControladorVistaGestionMozoOp cMozoOp = new ControladorVistaGestionMozoOp(vistaMozoOp, v);
		ControladorVistaGestionMozoAdmin cMozoAdmin = new ControladorVistaGestionMozoAdmin(vistaMozoAdmin, v);
		ControladorVistaGestionMesaOp cMesaOp = new ControladorVistaGestionMesaOp(vistaMesaOp, v);
		ControladorVistaGestionMesaAdmin cMesaAdmin = new ControladorVistaGestionMesaAdmin(vistaMesaAdmin, v);
		ControladorVistaGestionProductoAdmin cProductoAdmin = new ControladorVistaGestionProductoAdmin(
				vistaProductoAdmin, v);
		ControladorVistaModificaMesaAdmin cModificaMesa = new ControladorVistaModificaMesaAdmin(vistaModificarMesa, v);
		ControladorVistaModificaMesaOp cModificaMesaOp = new ControladorVistaModificaMesaOp(vistaModificaMesaOp, v);
		ControladorVistaModificaMozoAdmin cModificaMozoAdmin = new ControladorVistaModificaMozoAdmin(
				vistaModificaMozoAdmin, v);
		ControladorVistaModificaMozoOp cModificaMozoOp = new ControladorVistaModificaMozoOp(vistaModificaMozoOp, v);
	}

}
