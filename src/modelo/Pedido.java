package modelo;

public class Pedido
{
    private Producto producto;
    private int cant;
  //cant debe ser > 0]
    
	public Pedido(Producto producto, int cant) {
		super();
		this.producto = producto;
		this.cant = cant;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public int getCant() {
		return cant;
	}

	@Override
	public String toString() {
		return "Pedido [producto=" + producto.getNombre() + ", cant=" + cant + "]";
	}
   
    
    
    
}
