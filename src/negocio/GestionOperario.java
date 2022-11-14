package negocio;

public class GestionOperario {

	
	public static boolean existeOperario(String userName) {
		return Sistema.getInstance().getOperariosRegistrados().get(userName) != null;
	}
	
	public static void eliminaOperario(String userName) {
		Sistema.getInstance().getOperariosRegistrados().remove(userName);
	}
	
}
