package modelo;

public class Producto
{
    private static int siguienteIdProd = 0;
    private int idProd;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;
    
	public Producto(String nombre, double precioCosto, double precioVenta, int stockInicial) {
		super();
		this.idProd = siguienteIdProd++;
		this.nombre = nombre;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.stockInicial = stockInicial;
	}

	public int getIdProd() {
		return idProd;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecioCosto() {
		return precioCosto;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public int getStockInicial() {
		return stockInicial;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setStockInicial(int stockInicial) {
		this.stockInicial = stockInicial;
	}

	@Override
	public String toString() {
		return "Producto [idProd=" + idProd + ", nombre=" + nombre + ", precioCosto=" + precioCosto + ", precioVenta="
				+ precioVenta + ", stockInicial=" + stockInicial + "]";
	}

	
    
    
    /**
     * el producto no puede ser nulo
	 * aplicaDosPorUno y aplicaDtoPorCantidad no pueden ser false ambos al mismo tiempo (ya que no habría promo)

     */
}
