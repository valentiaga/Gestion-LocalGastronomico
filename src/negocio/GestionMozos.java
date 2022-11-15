package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modelo.Cerveceria;
import modelo.MesaAtendida;
import modelo.Mozo;

public class GestionMozos {
	private HashMap<String, Mozo> mozos = Sistema.getInstance().getMozos();

	public String mejorVendedor() {
		double maxVolumenVentas = 0, volumenVentas = 0;
		String vendedor = "";
		ArrayList<MesaAtendida> mesasAtendidas;
		for (HashMap.Entry<String, Mozo> entry : mozos.entrySet()) {

			mesasAtendidas = mozos.get(entry.getKey()).getMesasAtendidas();

			for (int i = 0; i < mesasAtendidas.size(); i++) {
				volumenVentas += mesasAtendidas.get(i).getTotal();
			}
			if (volumenVentas > maxVolumenVentas) {
				maxVolumenVentas = volumenVentas;
				vendedor = entry.getKey();
			}
		}

		return vendedor;
	}

	public String peorVendedor() {

		double minVolumenVentas = 0, volumenVentas = 0;
		String vendedor = "";
		ArrayList<MesaAtendida> mesasAtendidas;
		
		for (HashMap.Entry<String, Mozo> entry : mozos.entrySet()) {

			mesasAtendidas = mozos.get(entry.getKey()).getMesasAtendidas();

			for (int i = 0; i < mesasAtendidas.size(); i++) {
				volumenVentas += mesasAtendidas.get(i).getTotal();
			}
			if (volumenVentas < minVolumenVentas) {
				minVolumenVentas = volumenVentas;
				vendedor = entry.getKey();
			}
		}

		return vendedor;
	}

	public double consumoPromedioPorMesa(Mozo mozo) {
		double consumoProm = 0;
		int cantMesas = 0;
		ArrayList<MesaAtendida> mesasAtendidas = mozo.getMesasAtendidas();
		
		for (int i = 0; i < mesasAtendidas.size(); i++) {
			consumoProm += mesasAtendidas.get(i).getTotal();
			cantMesas++;
		}
		
		if(cantMesas > 0)
			consumoProm = consumoProm/cantMesas;
		
		return consumoProm;
	}
}
