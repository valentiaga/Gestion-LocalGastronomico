package modelo;

import modelo.Enumerados.estadoMesa;

public class Mesa
{
    private static int siguienteNroMesa = 0; //el 0 es la barra
    private int nroMesa;
    private int cantPax;
    private Enumerados.estadoMesa estado;
    private Mozo mozo;
    
	public Mesa(int cantPax) {
		super();
		this.nroMesa = siguienteNroMesa++;
		this.cantPax = cantPax;
		this.estado = estado.LIBRE;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public int getCantPax() {
		return cantPax;
	}

	public Enumerados.estadoMesa getEstado() {
		return estado;
	}

	public void setCantPax(int cantPax) {
		this.cantPax = cantPax;
	}

	public void setEstado(Enumerados.estadoMesa estado) {
		this.estado = estado;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}
    
    
    
}

