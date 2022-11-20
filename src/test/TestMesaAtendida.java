package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import modelo.Enumerados;
import modelo.Mesa;
import modelo.MesaAtendida;
import modelo.Pedido;
import modelo.PromocionProd;
import modelo.PromocionTemporal;

public class TestMesaAtendida
{

	@Test
	public void testConstructorTotalPositivo()
	{
		Mesa mesa = new Mesa();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		MesaAtendida mA = new MesaAtendida(mesa,pedidos,900.0,modelo.Enumerados.formaDePago.CTADNI);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa, mA.getMesa());
		Assert.assertEquals("Total registrado incorrectamente",900.0, mA.getTotal(),0);
		Assert.assertEquals("FormaDePago registrada incorrectamente",Enumerados.formaDePago.CTADNI, mA.getFormaDePago());
	}
	
	@Test
	public void testConstructorFormaDePagoEfectivo()
	{
		Mesa mesa = new Mesa();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		MesaAtendida mA = new MesaAtendida(mesa,pedidos,900.0,modelo.Enumerados.formaDePago.EFECTIVO);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa, mA.getMesa());
		Assert.assertEquals("Total registrado incorrectamente",900.0, mA.getTotal(),0);
		Assert.assertEquals("FormaDePago registrada incorrectamente",Enumerados.formaDePago.EFECTIVO, mA.getFormaDePago());
	}
	
	@Test
	public void testConstructorFormaDePagoMERCPAGO()
	{
		Mesa mesa = new Mesa();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		MesaAtendida mA = new MesaAtendida(mesa,pedidos,900.0,modelo.Enumerados.formaDePago.MERCPAGO);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa, mA.getMesa());
		Assert.assertEquals("Total registrado incorrectamente",900.0, mA.getTotal(),0);
		Assert.assertEquals("FormaDePago registrada incorrectamente",Enumerados.formaDePago.MERCPAGO, mA.getFormaDePago());
	}
	
	@Test
	public void testConstructorFormaDePagoTARJETA()
	{
		Mesa mesa = new Mesa();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		MesaAtendida mA = new MesaAtendida(mesa,pedidos,900.0,modelo.Enumerados.formaDePago.TARJETA);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa, mA.getMesa());
		Assert.assertEquals("Total registrado incorrectamente",900.0, mA.getTotal(),0);
		Assert.assertEquals("FormaDePago registrada incorrectamente",Enumerados.formaDePago.TARJETA, mA.getFormaDePago());
	}

	@Test
	public void testConstructorTotalNegativo()
	{
		Mesa mesa = new Mesa();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		MesaAtendida mA = new MesaAtendida(mesa,pedidos,-900.0,modelo.Enumerados.formaDePago.CTADNI);
		Assert.assertEquals("Mesa registrada incorrectamente",mesa, mA.getMesa());
		Assert.assertEquals("Total registrado incorrectamente",-900.0, mA.getTotal(),0);
		Assert.assertEquals("FormaDePago registrada incorrectamente",Enumerados.formaDePago.CTADNI, mA.getFormaDePago());
	}
	
	@Test
	public void testConstructorMesaNull()
	{
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		MesaAtendida mA = new MesaAtendida(null,pedidos,900.0,modelo.Enumerados.formaDePago.CTADNI);
		Assert.assertEquals("Mesa registrada incorrectamente",null, mA.getMesa());
		Assert.assertEquals("Total registrado incorrectamente",900.0, mA.getTotal(),0);
		Assert.assertEquals("FormaDePago registrada incorrectamente",Enumerados.formaDePago.CTADNI, mA.getFormaDePago());
	}
	
	@Test
	public void testSetMesa()
	{
		MesaAtendida mA = new MesaAtendida();
		Mesa mesa = new Mesa();
		mA.setMesa(mesa);
		Assert.assertEquals("Nueva mesa registrada incorrectamente",mesa, mA.getMesa());
	}
	
	@Test
	public void testSetFecha()
	{
		MesaAtendida mA = new MesaAtendida();
		GregorianCalendar gc = new GregorianCalendar();
		mA.setFecha(gc);
		Assert.assertEquals("Nueva fecha registrada incorrectamente",gc, mA.getFecha());
	}
	
	@Test
	public void testSetFormaDePago()
	{
		MesaAtendida mA = new MesaAtendida();
		mA.setFormaDePago(Enumerados.formaDePago.EFECTIVO);
		Assert.assertEquals("Nueva formaDePago registrada incorrectamente",Enumerados.formaDePago.EFECTIVO, mA.getFormaDePago());
	}
	
	@Test
	public void testSetPedidos()
	{
		MesaAtendida mA = new MesaAtendida();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		mA.setPedidos(pedidos);
		Assert.assertEquals("Nuevos pedidos registrados incorrectamente",pedidos, mA.getPedidos());
	}
	
	@Test
	public void testSetPromociones()
	{
		MesaAtendida mA = new MesaAtendida();
		ArrayList<PromocionProd> proms = new ArrayList<PromocionProd>();
		mA.setPromociones(proms);
		Assert.assertEquals("Nuevas promociones registradas incorrectamente",proms, mA.getPromociones());
	}
	
	@Test
	public void testSetPromocioneTemporal()
	{
		MesaAtendida mA = new MesaAtendida();
		PromocionTemporal promo = new PromocionTemporal();
		mA.setPromoTemp(promo);
		Assert.assertEquals("Nueva promocionTemporal registrada incorrectamente",promo, mA.getPromoTemp());
	}
	
	@Test
	public void testSetTotal()
	{
		MesaAtendida mA = new MesaAtendida();
		mA.setTotal(43.57);
		Assert.assertEquals("Nuevo total registrado incorrectamente",43.57, mA.getTotal(),0);
	}
}
