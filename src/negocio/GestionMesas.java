package negocio;

import excepciones.StockInsuficiente_Exception;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;

public class GestionMesas {

	public static boolean existeMesa(int nroMesa) {
		return Sistema.getInstance().getMesas().get(nroMesa) != null;
	}
	
	public static void eliminaMesa(int nroMesa) {
		Sistema.getInstance().getMesas().remove(nroMesa);
	}
	
	public static void agregaPedidos(Mesa mesa, int cant, int idProd) throws StockInsuficiente_Exception {
		Producto producto = null;
		try {
			producto = (Producto) Sistema.getInstance().getProductos().get(idProd).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (producto.getStockInicial()>=cant) {
			Comanda comanda = mesa.getComanda();
			comanda.agregaPedido(new Pedido(producto, cant));
			producto.setStockInicial(producto.getStockInicial()-cant);
		}
		else throw new StockInsuficiente_Exception("No hay suficiente stock. Solo quedan: "+producto.getStockInicial()+" unidades de "+ producto.getNombre());
	}
}
