package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import modelo.Comanda;
import modelo.Enumerados.estadoComanda;
import modelo.Mesa;
import modelo.Pedido;

public class CajaNegraComanda
{

	@Test
	public void testConstructorEstadoAbierto()
	{
		Mesa mesa = new Mesa();
		Comanda com = new Comanda(mesa,estadoComanda.ABIERTO);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa,com.getMesa());
		Assert.assertEquals("Estado registrado incorrectamente",estadoComanda.ABIERTO,com.getEstado());
	}
	
	@Test
	public void testConstructorEstadoCerrado()
	{
		Mesa mesa = new Mesa();
		Comanda com = new Comanda(mesa,estadoComanda.CERRADO);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa,com.getMesa());
		Assert.assertEquals("Estado registrado incorrectamente",estadoComanda.CERRADO,com.getEstado());
	}
	
	@Test
	public void testConstructorMesaNull()
	{
		Comanda com = new Comanda(null,estadoComanda.CERRADO);
		Assert.assertEquals("Mesa registrada incorrectamente",null,com.getMesa());
		Assert.assertEquals("Estado registrado incorrectamente",estadoComanda.CERRADO,com.getEstado());
	}
	
	@Test
	public void testSetMesa()
	{
		Comanda com = new Comanda();
		Mesa mesa = new Mesa();
		com.setMesa(mesa);
		Assert.assertEquals("Nueva mesa registrada incorrectamente",mesa,com.getMesa());
	}
	
	@Test
	public void testSetEstado()
	{
		Comanda com = new Comanda();
		com.setEstado(estadoComanda.CERRADO);
		Assert.assertEquals("Nuevo estado registrado incorrectamente",estadoComanda.CERRADO,com.getEstado());
	}

	@Test
	public void testSetFecha()
	{
		Comanda com = new Comanda();
		GregorianCalendar gc = new GregorianCalendar();
		com.setFecha(gc);
		Assert.assertEquals("Nueva fecha registrada incorrectamente",gc,com.getFecha());
	}
	
	
	@Test
	public void testSetPedidos()
	{
		Comanda com = new Comanda();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		com.setPedidos(pedidos);
		Assert.assertEquals("Nuevos pedidos registrados incorrectamente",pedidos,com.getPedidos());
	}
	
	
}
