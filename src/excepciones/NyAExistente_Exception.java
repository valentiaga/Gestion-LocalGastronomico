package excepciones;

public final class NyAExistente_Exception extends Exception {

	private String NyARepetido;

	public NyAExistente_Exception(String nyARepetido) {
		super();
		NyARepetido = nyARepetido;
	}
	
	
}
