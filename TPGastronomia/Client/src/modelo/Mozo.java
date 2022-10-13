package modelo;

import java.util.GregorianCalendar;

public class Mozo {
    enum Estado{activo,
                deFranco,
                ausente}
    private String NyA;
    private GregorianCalendar fecha;
    private int cantHijos;
    //private String estado; //enum\\
    private  Estado estado;
    
}
