package negocio;

import java.util.ArrayList;

import modelo.Comanda;
import modelo.MesaAtendida;
import modelo.Mozo;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;

public class GestionProdTemp {
	
	private PromocionTemporal promocionTemporal;

	public GestionProdTemp(PromocionTemporal promocionTemporal) {
		super();
		this.promocionTemporal = promocionTemporal;
	}
	
	public PromocionTemporal productoPromocionTemporal () {
		//verificar si esta en promo
		return null;
	}
	
	public static void cargaPromosTemp(Comanda comanda) {
		
//		Mozo mozo = comanda.getMesa().getMozo();
//		int ultimo = mozo.getMesasAtendidas().size();
//		MesaAtendida mesaAtendida = mozo.getMesasAtendidas().get(ultimo);
//		PromocionTemporal promoTemp;
//		ArrayList<PromocionTemporal> promos = Sistema.getInstance().getPromocionesTemp();
//		
//		for(int i=0; i < promos.size();i++) {	
//			
//			promos.get(i).getDiasDePromo();			//chequear las promos temporales y cargarlas en el array de promos de MesaAtendida
//			promos.get(i).getHoraInicio();
//			promos.get(i).getHoraFinal();
//			
//		}
		
	}
}
