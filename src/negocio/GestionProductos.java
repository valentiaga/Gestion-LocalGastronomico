package negocio;

import modelo.Producto;

public class GestionProductos {
	
	public static boolean existeProducto(int idProd) {
		return Sistema.getInstance().getProductos().get(idProd) != null;
	}
	
	public static void eliminaProducto(int idProd) {
		Sistema.getInstance().getProductos().remove(idProd);
	}

}
