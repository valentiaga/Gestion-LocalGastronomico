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


	public String getNombre() {
		return nombre;
	}


	public Enumerados.formaDePago getFormaDePago() {
		return formaDePago;
	}


	public void setFormaDePago(Enumerados.formaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}


	public boolean isEsAcumulable() {
		return esAcumulable;
	}


	public void setEsAcumulable(boolean esAcumulable) {
		this.esAcumulable = esAcumulable;
	}


	public int getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}


	public int getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}


	public void setPorcentajeDesc(int porcentajeDesc) {
		this.porcentajeDesc = porcentajeDesc;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
    
}
