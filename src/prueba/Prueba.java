package prueba;

import controlador.ControladorVistaGestionMozoOp;
import modelo.Mozo;
import negocio.Sistema;
import vista.IVistaGestionMozoOp;
import vista.Ventana;
import vista.VistaGestionMozoOp;

public class Prueba {

	public static void main(String[] args) {
		
		Mozo mozo = new Mozo("Marti", 3);
		Mozo mozo2 = new Mozo("Valen", 0);
		Mozo mozo3 = new Mozo("Pau", 2);
		
		Sistema.getInstance().getMozos().put("Marti", mozo);
		Sistema.getInstance().getMozos().put("Valen", mozo2);
		Sistema.getInstance().getMozos().put("Pau", mozo3);

		Ventana v = new Ventana(new VistaGestionMozoOp());
		IVistaGestionMozoOp vista = new VistaGestionMozoOp();
		ControladorVistaGestionMozoOp c = new ControladorVistaGestionMozoOp(v, vista);
		
	}

}
