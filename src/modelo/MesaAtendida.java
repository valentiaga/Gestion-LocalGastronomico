package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MesaAtendida {

	private GregorianCalendar fecha;
	private Mesa mesa;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private double total;
	private Enumerados.formaDePago formaDePago;							// hay que elegir la forma de pago por ventana cuando se cierra la mesa
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>();
	
	
	public MesaAtendida(Mesa mesa, ArrayList<Pedido> pedidos, double total,
			modelo.Enumerados.formaDePago formaDePago) {
		super();
		this.fecha = new GregorianCalendar();
		this.mesa = mesa;
		this.pedidos = pedidos;
		this.total = total;
		this.formaDePago = formaDePago;
	}
	
	public void agregaPromocion(Promocion promocion) {
		this.promociones.add(promocion);
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Enumerados.formaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(Enumerados.formaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	
}
