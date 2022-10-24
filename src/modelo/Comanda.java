package modelo;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Comanda 
{
    private GregorianCalendar fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private Enumerados.estadoComanda estado;
}