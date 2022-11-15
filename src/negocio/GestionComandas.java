package negocio;

import java.util.ArrayList;

import modelo.Comanda;
import modelo.Enumerados;
import modelo.MesaAtendida;
import modelo.Pedido;
import modelo.PromocionProd;

public class GestionComandas {
	
	private static ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
	/**
	 * No es posible crear una nueva comanda si el local
	no tiene mesas habilitadas
	la mesa asociada debe tener un mozo activo asociado
	no tiene mozos activos
	al menos 2 productos están en promoción activa
	la lista de productos no puede estar vacía
	La mesa debe estar en estado libre
	Al momento de agregar un PEDIDO la cantidad solicitada no puede superar al stock del producto
	Al momento de guardar la comanda, el estado de la mesa debe pasar a ocupada
	Al momento de guardar la comanda se debe descontar del stock la cantidad pedida de cada producto.
	 * @param comanda
	 */
	
	public static boolean contieneProd(int idProd) {
		
		boolean bool = false;
		int i = 0,j = 0;
		
		while( bool == false && i < comandas.size() ) {
			while(bool == false && j < comandas.get(i).getPedidos().size()) {
				if(comandas.get(i).getPedidos().get(i).getProducto().getIdProd() == idProd && comandas.get(i).getEstado()==Enumerados.estadoComanda.ABIERTO)
					bool = true;
				j++;
			}
			i++;
		}
		return bool;
	}
	
	public static double totalComandaSinDescuento(Comanda comanda) {
		double total = 0;
		
		for(int i = 0 ; i< comanda.getPedidos().size(); i++) {
			total += comanda.getPedidos().get(i).getCant() * comanda.getPedidos().get(i).getProducto().getPrecioVenta();
		}
		
		return total;
	}
	
	public static void totalComandaConDescuento (MesaAtendida mesa, Comanda comanda) {
		double descuento = 0;
		double total = 0;
		int cantActual =0;
		ArrayList <PromocionProd> promos = mesa.getPromociones();
		PromocionProd promoActual;
		Pedido pedidoActual;
		for (int i = 0; i<promos.size(); i++) {
			promoActual = promos.get(i);
			for (int j = 0; j<comanda.getPedidos().size(); j++) {
				//System.out.println("Entre");
				pedidoActual = comanda.getPedidos().get(j);
				cantActual = pedidoActual.getCant();
				if (pedidoActual.getProducto().getNombre().equals(pedidoActual.getProducto().getNombre())) {
					System.out.println("Entre1");
					if (promoActual.isAplica2x1()) {
						System.out.println("Entre2");
						if (cantActual>1)//si hay uno solo no se aplica dto
							if (cantActual % 2 == 0)
								descuento += cantActual * pedidoActual.getProducto().getPrecioVenta()*0.5;
							else { //capaz tiene 5 productos pero se aplica 2x1 solo a 4
								cantActual --;
								descuento += cantActual * pedidoActual.getProducto().getPrecioVenta()*0.5;
							}
					}
					else if (promoActual.isAplicaDtoPorCant() && pedidoActual.getCant()>=promoActual.getDtoPorCant_CantMinima()) { //que descuento se pone???? me tiene mal
						descuento += cantActual * (pedidoActual.getProducto().getPrecioVenta() - promoActual.getDtoPorCant_PrecioUnitario());
					}
				}
			}
		}
		total = totalComandaSinDescuento(comanda);
		System.out.println("Total sin desc"+total);
		total -= descuento;
		if (mesa.getPromoTemp()!=null) {
			//System.out.println("Descuento"+mesa.getPromoTemp().getPorcentajeDesc());
			total = total * (1-(double)(mesa.getPromoTemp().getPorcentajeDesc())/100);
		}
		mesa.setTotal(total);
		//System.out.println(descuento);
		//System.out.println(total);
	}
	
}
