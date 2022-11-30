package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;

public class CajaNegraMesa
{

	@Test
	public void testConstructorPaxPositivo()
	{
		Mesa mesa = new Mesa(4);
		int pax = mesa.getCantPax();
		Assert.assertEquals("Pax registrado incorrectamente",pax,mesa.getCantPax());
	}
	
	@Test
	public void testConstructorPaxNegativo()
	{
		Mesa mesa = new Mesa(-4);
		int pax = mesa.getCantPax();
		Assert.assertEquals("Pax registrado incorrectamente",pax,mesa.getCantPax());
	}
	
	@Test
	public void testSetCantPax()
	{
		Mesa mesa = new Mesa();
		mesa.setCantPax(8);
		Assert.assertEquals("Nuevo pax registrado incorrectamente",8,mesa.getCantPax());
	}
	
	@Test
	public void testSetComanda()
	{
		Mesa mesa = new Mesa();
		Comanda com = new Comanda();
		mesa.setComanda(com);
		Assert.assertEquals("Nueva comanda registrada incorrectamente",com,mesa.getComanda());
	}
	
	@Test
	public void testSetEstado()
	{
		Mesa mesa = new Mesa();
		mesa.setEstado(Enumerados.estadoMesa.OCUPADA);
		Assert.assertEquals("Nuevo estado registrado incorrectamente",Enumerados.estadoMesa.OCUPADA,mesa.getEstado());
	}
	
	@Test
	public void testSetMozo()
	{
		Mesa mesa = new Mesa();
		Mozo mozo = new Mozo();
		mesa.setMozo(mozo);
		Assert.assertEquals("Nuevo mozo registrado incorrectamente",mozo,mesa.getMozo());
	}
	
	@Test
	public void testSetNroMesa()
	{
		Mesa mesa = new Mesa();
		mesa.setNroMesa(-23);
		Assert.assertEquals("Nuevo nroMesa registrado incorrectamente",-23,mesa.getNroMesa());
	}

}
