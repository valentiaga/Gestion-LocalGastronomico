package modelo;

public class Promocion {
	
	private boolean activa;
	private Enumerados.diasDePromo diasDePromo;
	
	public Promocion(boolean activa, modelo.Enumerados.diasDePromo diasDePromo) {
		super();
		this.activa = activa;
		this.diasDePromo = diasDePromo;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Enumerados.diasDePromo getDiasDePromo() {
		return diasDePromo;
	}

	public void setDiasDePromo(Enumerados.diasDePromo diasDePromo) {
		this.diasDePromo = diasDePromo;
	}
	
	
}
