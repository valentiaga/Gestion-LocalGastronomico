package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Mozo
{
	private Enumerados.estadoMozo estado;
	private String NyA;
	private GregorianCalendar fecha;
	private int cantHijos;
	private ArrayList <MesaAtendida> mesasAtendidas;
	private double sueldo;

    /**
     * Constructor de cada mozo. <br>
     * Pre: el mozo debe ser mayor a 18 a�os. <br>
     * Pre: la cantidad de hijos debe ser >= 0. <br>
     * @param NyA perteneciente al nombre y apellido del mozo. <br>
     * @param cantHijos cantidad de hijos que tiene el mozo. <br>
     */
    public Mozo(String NyA, int cantHijos) {
        this.estado = Enumerados.estadoMozo.ACTIVO;
        this.NyA = NyA;
        this.fecha = new GregorianCalendar(); //setear fecha actual
        this.cantHijos = cantHijos;
        this.mesasAtendidas = new ArrayList<MesaAtendida>();
        this.sueldo =  Sueldo.calculaSueldo(cantHijos);
    }

	public void setEstado(Enumerados.estadoMozo estado) {
		this.estado = estado;
	}

	public void setNyA(String nyA) {
		NyA = nyA;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}

	public Enumerados.estadoMozo getEstado() {
		return estado;
	}

	public String getNyA() {
		return NyA;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public ArrayList<MesaAtendida> getMesasAtendidas() {
		return mesasAtendidas;
	}

	public double getSueldo() {
		return sueldo;
	}
    
    

}
