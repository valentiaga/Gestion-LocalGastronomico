package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Promocion;

public class CajaNegraPromocion
{

	@Test
	public void ConstructorActivaTrue()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.DOMINGO);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.DOMINGO, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructordiasDePromoLUNES()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.LUNES);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.LUNES, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructordiasDePromoMARTES()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.MARTES);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.MARTES, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructordiasDePromoMIERCOLES()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.MIERCOLES);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.MIERCOLES, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructordiasDePromoJUEVES()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.JUEVES);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.JUEVES, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructordiasDePromoVIERNES()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.VIERNES);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.VIERNES, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructordiasDePromoSABADO()
	{
		Promocion promo = new Promocion(true, modelo.Enumerados.diasDePromo.SABADO);
		Assert.assertEquals("Activa registrada incorrectamente",true, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.SABADO, promo.getDiasDePromo());
	}
	
	@Test
	public void ConstructorActivaFalse()
	{
		Promocion promo = new Promocion(false, modelo.Enumerados.diasDePromo.DOMINGO);
		Assert.assertEquals("Activa registrada incorrectamente",false, promo.isActiva());
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.DOMINGO, promo.getDiasDePromo());
	}
	
	@Test
	public void testSetActiva()
	{
		Promocion promo = new Promocion();
		promo.setActiva(false);
		Assert.assertEquals("Nueva activa registrada incorrectamente",false, promo.isActiva());
	}
	
	@Test
	public void testSetDiasDePromo()
	{
		Promocion promo = new Promocion();
		promo.setDiasDePromo(modelo.Enumerados.diasDePromo.MIERCOLES);
		Assert.assertEquals("DiasDePromo registrado incorrectamente",modelo.Enumerados.diasDePromo.MIERCOLES, promo.getDiasDePromo());	}

}
