package util;

/**
 * Enumerados utilizados en los mensajes de los cuadros de diálogo modal
 * para poder realizar test GUI.
 */
public enum Mensajes 
{

	PRECIO_INVALIDO("Ninguno de los precios puede ser negativo."),
	ACTUALIZA_DATOS("Datos actualizados.");
	
	private String valor;

    private Mensajes(String valor)
    {
	this.valor = valor;
    }

    public String getValor()
    {
	return valor;
    }

    public void setValor(String valor)
    {
	this.valor = valor;
    }
    

}
