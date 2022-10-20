package excepciones;

public class NoExisteOperario_Exception extends Exception {
	private String userName;

	public NoExisteOperario_Exception(String userName) {
		super();
		this.userName = userName;
	}
}
