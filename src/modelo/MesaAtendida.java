package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MesaAtendida {

	private GregorianCalendar fecha;
	private Mesa mesa;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private double total;
	private Enumerados.formaDePago formaDePago;
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>();
	
	
	public MesaAtendida(GregorianCalendar fecha, Mesa mesa, ArrayList<Pedido> pedidos, double total,
			modelo.Enumerados.formaDePago formaDePago, ArrayList<Promocion> promociones) {
		super();
		this.fecha = fecha;
		this.mesa = mesa;
		this.pedidos = pedidos;
		this.total = total;
		this.formaDePago = formaDePago;
		this.promociones = promociones;
	}
	
	
}
