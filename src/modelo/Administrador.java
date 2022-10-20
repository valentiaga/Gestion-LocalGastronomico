package modelo;

import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.NyAExistente_Exception;

import java.util.GregorianCalendar;

public class Administrador extends Operario
{

    public void agregaMozo(String NyA, GregorianCalendar fecha, int cantHijos, Enumerados.estadoMozo estado) throws NyAExistente_Exception{}
    public void eliminaMozo(String NyA) throws NoExisteMozo_Exception {}
    public void eliminaOperario (String userName)throws NoExisteOperario_Exception{}
    
    public void agregaProducto(String nombre, double precioCosto, double precioVenta, int stockInicial) {}
    public void agregaMesa(int cantSillas, boolean libre) {}
}
