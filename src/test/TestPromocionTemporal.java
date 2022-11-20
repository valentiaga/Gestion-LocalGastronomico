package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.PromocionTemporal;

public class TestPromocionTemporal
{

	// los metodos y sus variantes testeados en la clase padre no se vuelven a
	// testear.

	@Test
	public void ConstructorformaDePagoMERCPAGO()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.MERCPAGO,2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorformaDePagoCTADNI()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.CTADNI,2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.CTADNI,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorformaDePagoEFECTIVO()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.EFECTIVO,2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.EFECTIVO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorformaDePagoTARJETA()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.TARJETA,2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.TARJETA,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorNombreVacio()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"",modelo.Enumerados.formaDePago.MERCPAGO,2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorNombreNull()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,null,modelo.Enumerados.formaDePago.MERCPAGO,2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente",null,promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorPorcentajeDescNegativo()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.MERCPAGO,-2,true,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",-2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorEsAcumulableNegativo()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.MERCPAGO,2,false,3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",false,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}

	@Test
	public void ConstructorHoraInicioNegativa()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.MERCPAGO,2,true,-3,4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",-3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",4,promo.getHoraFinal());
	}
	
	@Test
	public void ConstructorHoraFinalNegativa()
	{
		PromocionTemporal promo = new PromocionTemporal (true,modelo.Enumerados.diasDePromo.DOMINGO,"Navidarks",modelo.Enumerados.formaDePago.MERCPAGO,2,true,3,-4);
		Assert.assertEquals("Nombre registrado incorrectamente","Navidarks",promo.getNombre());
		Assert.assertEquals("FormaDePago registrado incorrectamente",modelo.Enumerados.formaDePago.MERCPAGO,promo.getFormaDePago());
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",2,promo.getPorcentajeDesc());
		Assert.assertEquals("EsAcumulable registrado incorrectamente",true,promo.isEsAcumulable());
		Assert.assertEquals("HoraInicio registrado incorrectamente",3,promo.getHoraInicio());
		Assert.assertEquals("HoraFinal registrado incorrectamente",-4,promo.getHoraFinal());
	}
	
	@Test
	public void testSetEsAcumulable()
	{
		PromocionTemporal promo = new PromocionTemporal();
		promo.setEsAcumulable(false);
		Assert.assertEquals("Nuevo EsAcumulable registrado incorrectamente",false,promo.isEsAcumulable());
	}
	
	@Test
	public void testSetFormaDePago()
	{
		PromocionTemporal promo = new PromocionTemporal();
		promo.setFormaDePago(modelo.Enumerados.formaDePago.EFECTIVO);
		Assert.assertEquals("Nueva formaDePago registrada incorrectamente",modelo.Enumerados.formaDePago.EFECTIVO,promo.getFormaDePago());
	}
	
	@Test
	public void testSetHoraInicio()
	{
		PromocionTemporal promo = new PromocionTemporal();
		promo.setHoraInicio(9);
		Assert.assertEquals("HoraInicio registrado incorrectamente",9,promo.getHoraInicio());
	}
	
	@Test
	public void testSetHoraFinal()
	{
		PromocionTemporal promo = new PromocionTemporal();
		promo.setHoraFinal(8);
		Assert.assertEquals("HoraFinal registrado incorrectamente",8,promo.getHoraFinal());
	}
	
	@Test
	public void testSetNombre()
	{
		PromocionTemporal promo = new PromocionTemporal();
		promo.setNombre("HolaProfe");
		Assert.assertEquals("Nombre registrado incorrectamente","HolaProfe",promo.getNombre());
	}
	
	@Test
	public void testSetPorcentajeDesc()
	{
		PromocionTemporal promo = new PromocionTemporal();
		promo.setPorcentajeDesc(4);
		Assert.assertEquals("PorcentajeDesc registrado incorrectamente",4,promo.getPorcentajeDesc());
	}
}
