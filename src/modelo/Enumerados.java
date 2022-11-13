package modelo;

public class Enumerados 
{
	public enum estadoMozo
	{
		ACTIVO,
	    DEFRANCO,
	    AUSENTE;
	}
	
	public enum diasDePromo
	{
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO,
		DOMINGO;
	}
	
	public enum estadoComanda
	{
		ABIERTO,
		CERRADO;
	}
	
	public enum estadoMesa
	{
		LIBRE,
		OCUPADA;
	}
	public enum formaDePago
	{
		EFECTIVO,
		TARJETA,
		MERCPAGO,
		CTADNI;
	}
	
	public enum tipoDeUsuario{
		ADMINISTRADO,
		OPERARIO;
	}
	public enum estadoOperario{
		ACTIVO,
		INACTIVO;
	}
}

