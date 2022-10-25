package modelo;

public class PromocionProd extends Promocion
{
	private static int sigIdProm = 0;
    private int idProm;
    private Producto producto;
    private boolean aplica2x1;
    private boolean aplicaDtoPorCant;
    private int DtoPorCant_CantMinima;
    private double DtoPorCant_PrecioUnitario;
    
    
	public PromocionProd(boolean activa, modelo.Enumerados.diasDePromo diasDePromo, Producto producto,
			boolean aplica2x1, boolean aplicaDtoPorCant, int dtoPorCant_CantMinima, double dtoPorCant_PrecioUnitario) {
		super(activa, diasDePromo);
		this.idProm = sigIdProm++;
		this.producto = producto;
		this.aplica2x1 = aplica2x1;
		this.aplicaDtoPorCant = aplicaDtoPorCant;
		DtoPorCant_CantMinima = dtoPorCant_CantMinima;
		DtoPorCant_PrecioUnitario = dtoPorCant_PrecioUnitario;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public boolean isAplica2x1() {
		return aplica2x1;
	}


	public void setAplica2x1(boolean aplica2x1) {
		this.aplica2x1 = aplica2x1;
	}


	public boolean isAplicaDtoPorCant() {
		return aplicaDtoPorCant;
	}


	public void setAplicaDtoPorCant(boolean aplicaDtoPorCant) {
		this.aplicaDtoPorCant = aplicaDtoPorCant;
	}


	public int getDtoPorCant_CantMinima() {
		return DtoPorCant_CantMinima;
	}


	public void setDtoPorCant_CantMinima(int dtoPorCant_CantMinima) {
		DtoPorCant_CantMinima = dtoPorCant_CantMinima;
	}


	public double getDtoPorCant_PrecioUnitario() {
		return DtoPorCant_PrecioUnitario;
	}


	public void setDtoPorCant_PrecioUnitario(double dtoPorCant_PrecioUnitario) {
		DtoPorCant_PrecioUnitario = dtoPorCant_PrecioUnitario;
	}


	public int getIdProm() {
		return idProm;
	}
    
   

	
	
	
	
}
