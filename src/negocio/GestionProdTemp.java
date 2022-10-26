package negocio;

import java.util.ArrayList;
import java.util.Calendar;

import modelo.Comanda;
import modelo.Enumerados;
import modelo.MesaAtendida;
import modelo.Mozo;
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
		
		Mozo mozo = comanda.getMesa().getMozo();
		int ultimo = mozo.getMesasAtendidas().size();
		MesaAtendida mesaAtendida = mozo.getMesasAtendidas().get(ultimo);
		PromocionTemporal promoTemp;
		ArrayList<PromocionTemporal> promos = Sistema.getInstance().getPromocionesTemp();
		int diaComanda, diaPromo;
		int horaComanda, horaInicioPromo, horaFinalPromo;
		
		diaComanda = comanda.getFecha().get(Calendar.DAY_OF_WEEK);
		horaComanda = comanda.getFecha().get(Calendar.HOUR_OF_DAY);

		for(int i=0; i < promos.size();i++) { //puede haber mas de una promo temporal aplicable al momento??
			
			promoTemp = promos.get(i);
			diaPromo = promoTemp.getDiasDePromo().ordinal();			//chequear las promos temporales y cargarlas en el array de promos de MesaAtendida
			horaInicioPromo = promoTemp.getHoraInicio();
			horaFinalPromo = promoTemp.getHoraFinal();
			
			if (diaComanda == diaPromo && horaComanda<horaFinalPromo && horaComanda>horaInicioPromo) 
				if (promoTemp.isEsAcumulable()== true || mesaAtendida.getPromociones().isEmpty()) //carga si es acumulable o si estaba vacio
					mesaAtendida.agregaPromocion(promoTemp);
		}
		
		
		
		
	}
}
