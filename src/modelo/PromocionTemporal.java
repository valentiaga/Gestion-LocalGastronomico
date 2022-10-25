package modelo;

public class PromocionTemporal extends Promocion
{
	
    private String nombre;
    private Enumerados.formaDePago formaDePago;
    private int porcentajeDesc;
    private boolean esAcumulable;
    private int horaInicio;
    private int horaFinal;
    
    
	public int getPorcentajeDesc() {
		return porcentajeDesc;
	}


	public PromocionTemporal(boolean activa, modelo.Enumerados.diasDePromo diasDePromo, String nombre,
			modelo.Enumerados.formaDePago formaDePago, int porcentajeDesc, boolean esAcumulable, int horaInicio,
			int horaFinal) {
		super(activa, diasDePromo);
		this.nombre = nombre;
		this.formaDePago = formaDePago;
		this.porcentajeDesc = porcentajeDesc;
		this.esAcumulable = esAcumulable;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}


	
    
}
