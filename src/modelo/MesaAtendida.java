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
}
