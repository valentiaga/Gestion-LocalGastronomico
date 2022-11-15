package negocio;

import java.util.ArrayList;

import modelo.Comanda;
import modelo.MesaAtendida;
import modelo.Mozo;
import modelo.Pedido;
import modelo.PromocionProd;

public class GestionProdPromo {

//	private PromocionProd promocionProd;
//
//	public GestionProdPromo(PromocionProd promocionProd) {
//		super();
//		this.promocionProd = promocionProd;
//	}
	
	public static void cargaPromosProd (Comanda comanda) {
		
		Mozo mozo = comanda.getMesa().getMozo();
		int ultimo = mozo.getMesasAtendidas().size()-1;
		MesaAtendida mesaAtendida = mozo.getMesasAtendidas().get(ultimo); 
		ArrayList<Pedido> pedidos = mesaAtendida.getPedidos();
		PromocionProd promo;
		
		for(int i = 0; i < pedidos.size(); i++) {
			promo = Sistema.getInstance().getPromocionProds().get(pedidos.get(i).getProducto().getIdProd());
			if(promo != null) {
				mesaAtendida.agregaPromocion(promo);
				//System.out.println(promo.getIdProm());
			}
		}
	}
	
	 public double calculaDescuento(PromocionProd promocionProd) {
		 return 0;
	 }
	 
}
