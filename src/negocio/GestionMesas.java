package negocio;

public class GestionMesas {

	public static boolean existeMesa(int nroMesa) {
		return Sistema.getInstance().getMesas().get(nroMesa) != null;
	}
	
	public static void eliminaMesa(int nroMesa) {
		Sistema.getInstance().getMesas().remove(nroMesa);
	}
}
