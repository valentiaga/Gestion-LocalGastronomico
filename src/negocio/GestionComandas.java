package negocio;

import modelo.Comanda;

public class GestionComandas {
	
	private Comanda comanda;

	
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
	
	public GestionComandas(Comanda comanda) {
		super();
		this.comanda = comanda;
	}
	
	
}
