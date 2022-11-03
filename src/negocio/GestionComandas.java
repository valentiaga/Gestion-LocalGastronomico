package negocio;

import java.util.ArrayList;

import modelo.Comanda;
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
				if(comandas.get(i).getPedidos().get(i).getProducto().getIdProd() == idProd)
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
				pedidoActual = comanda.getPedidos().get(j);
				if (pedidoActual.getProducto()==promoActual.getProducto()) {
					if (promoActual.isAplica2x1()) {
						cantActual = pedidoActual.getCant();
						if (cantActual>1)
							if (cantActual % 2 == 0)
								total += cantActual * pedidoActual.getProducto().getPrecioVenta()*0.5;
							else { //capaz tiene 5 productos pero se aplica 2x1 solo a 4
								cantActual --;
								total += cantActual * pedidoActual.getProducto().getPrecioVenta()*0.5 + pedidoActual.getProducto().getPrecioVenta();
							}
						else //solo hay un producto
							total += comanda.getPedidos().get(i).getCant() * comanda.getPedidos().get(i).getProducto().getPrecioVenta();
					}
					else if (promoActual.isAplicaDtoPorCant() && pedidoActual.getCant()>=promoActual.getDtoPorCant_CantMinima()) { //que descuento se pone???? me tiene mal
						total += pedidoActual.getCant() * promoActual.getDtoPorCant_PrecioUnitario();
					}
				}
				else
					total += comanda.getPedidos().get(i).getCant() * comanda.getPedidos().get(i).getProducto().getPrecioVenta();
			}
		}
		if (mesa.getPromoTemp()!=null)
			total = total * (1-mesa.getPromoTemp().getPorcentajeDesc());
		mesa.setTotal(total);
	}
	
}
