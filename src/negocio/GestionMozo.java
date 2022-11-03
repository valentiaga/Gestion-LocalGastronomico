package negocio;

public class GestionMozo {

	
	public static boolean existeMozo(String userName) {
		return Sistema.getInstance().getOperariosRegistrados().get(userName) != null;
	}
	
	public static void eliminaMozo(String userName) {
		Sistema.getInstance().getOperariosRegistrados().remove(userName);
	}
	
}
