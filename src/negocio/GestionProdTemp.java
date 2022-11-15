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
		int ultimo = mozo.getMesasAtendidas().size()-1;
		MesaAtendida mesaAtendida = mozo.getMesasAtendidas().get(ultimo); 
		PromocionTemporal promoTemp;
		ArrayList<PromocionTemporal> promos = Sistema.getInstance().getPromocionesTemp();
		int diaComanda, diaPromo;
		int horaComanda, horaInicioPromo, horaFinalPromo;
		
		diaComanda = comanda.getFecha().get(Calendar.DAY_OF_WEEK)-2;
		System.out.println("DiaComanda"+diaComanda);
		horaComanda = comanda.getFecha().get(Calendar.HOUR_OF_DAY);
		System.out.println("HoraComanda"+horaComanda);

		for(int i=0; i < promos.size();i++) { 
			
			promoTemp = promos.get(i);
			diaPromo = promoTemp.getDiasDePromo().ordinal();	//chequear que ordinal devuelva desde 1 a 7
			//System.out.println("Diapromo"+diaPromo);
			horaInicioPromo = promoTemp.getHoraInicio();
			horaFinalPromo = promoTemp.getHoraFinal();
			//System.out.println(horaInicioPromo);
			
			if (diaComanda == diaPromo && horaComanda<=horaFinalPromo && horaComanda>=horaInicioPromo) 
				if (promoTemp.isEsAcumulable()== true || mesaAtendida.getPromociones().isEmpty()) //carga si es acumulable o si estaba vacio
					mesaAtendida.setPromoTemp(promoTemp);
		}	
	}
}
