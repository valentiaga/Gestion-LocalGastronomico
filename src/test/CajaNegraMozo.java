package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import modelo.Enumerados;
import modelo.MesaAtendida;
import modelo.Mozo;

public class CajaNegraMozo
{

	@Test
	public void testConstructor()
	{
		Mozo mozo = new Mozo("Aureliano",3);
		Assert.assertEquals("NyA registrado incorrectamente","Aureliano",mozo.getNyA());
		Assert.assertEquals("CantHijos registrado incorrectamente",3,mozo.getCantHijos());
	}
	
	@Test
	public void testConstructorNombreVacio()
	{
		Mozo mozo = new Mozo("",3);
		Assert.assertEquals("NyA registrado incorrectamente","",mozo.getNyA());
		Assert.assertEquals("CantHijos registrado incorrectamente",3,mozo.getCantHijos());
	}
	
	@Test
	public void testConstructorNombreNull()
	{
		Mozo mozo = new Mozo(null,3);
		Assert.assertEquals("NyA registrado incorrectamente",null,mozo.getNyA());
		Assert.assertEquals("CantHijos registrado incorrectamente",3,mozo.getCantHijos());
	}
	
	@Test
	public void testSetCantHijos()
	{
		Mozo mozo = new Mozo();
		mozo.setCantHijos(2);
		Assert.assertEquals("Nueva cantHijos registrada incorrectamente",2,mozo.getCantHijos());
	}
	
	@Test
	public void testSetEstado()
	{
		Mozo mozo = new Mozo();
		mozo.setEstado(Enumerados.estadoMozo.AUSENTE);
		Assert.assertEquals("Nuevo estado registrada incorrectamente",Enumerados.estadoMozo.AUSENTE,mozo.getEstado());
	}
	
	@Test
	public void testSetFecha()
	{
		Mozo mozo = new Mozo();
		GregorianCalendar gc = new GregorianCalendar();
		mozo.setFecha(gc);
		Assert.assertEquals("Nueva fecha registrada incorrectamente",gc,mozo.getFecha());
	}
	

	
	@Test
	public void testSetMesasAtendidas()
	{
		Mozo mozo = new Mozo();
		ArrayList<MesaAtendida> mAs = new ArrayList<MesaAtendida>();
		mozo.setMesasAtendidas(mAs);
		Assert.assertEquals("Nuevas mesasAtendidas registradas incorrectamente",mAs,mozo.getMesasAtendidas());
	}
	
	@Test
	public void testSetNyA()
	{
		Mozo mozo = new Mozo();
		mozo.setNyA("Nombre feo");
		Assert.assertEquals("Nuevo nyA registradas incorrectamente","Nombre feo",mozo.getNyA());
	}
	
	@Test
	public void testSetSueldo()
	{
		Mozo mozo = new Mozo();
		mozo.setSueldo(764.67);
		Assert.assertEquals("Nuevo sueldo registrado incorrectamente",764.67,mozo.getSueldo(),0);
	}

}
