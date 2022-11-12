package modelo;


import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Enumerados.estadoComanda;

public class Comanda 
{
    private GregorianCalendar fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private Enumerados.estadoComanda estado;
    
	public Comanda(Mesa mesa, estadoComanda estado) {
		super();
		this.fecha = new GregorianCalendar();
		this.mesa = mesa;
		this.mesa.setEstado(Enumerados.estadoMesa.OCUPADA);
		this.pedidos = new ArrayList<Pedido>();
		this.estado = estado;
	}
	
	public void setEstado(Enumerados.estadoComanda estado) {
		this.estado = estado;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public Enumerados.estadoComanda getEstado() {
		return estado;
	}
    
	public void agregaPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
}