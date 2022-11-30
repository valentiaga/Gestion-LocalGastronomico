package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Producto;
import modelo.PromocionProd;

public class CajaNegraPromocionProd
{

	// los metodos y sus variantes testeados en la clase padre no se vuelven a
	// testear.
	@Test
	public void Constructor()
	{
		Producto prod = new Producto();
		PromocionProd promo = new PromocionProd(true, modelo.Enumerados.diasDePromo.DOMINGO, prod, true, true, 4, 0.7);
		Assert.assertEquals("Producto registrado incorrectamente",prod,promo.getProducto());
		Assert.assertEquals("Aplica2x1 registrado incorrectamente",true,promo.isAplica2x1());
		Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente",true,promo.isAplicaDtoPorCant());
		Assert.assertEquals("DtoPorCant_CantMinima registrada incorrectamente",4,promo.getDtoPorCant_CantMinima());
		Assert.assertEquals("DtoPorCant_PrecioUnitario registrada incorrectamente",0.7,promo.getDtoPorCant_PrecioUnitario(),0);	
	}
	
	@Test
	public void ConstructorProductoNull()
	{
		PromocionProd promo = new PromocionProd(true, modelo.Enumerados.diasDePromo.DOMINGO, null, true, true, 4, 0.7);
		Assert.assertEquals("Producto registrado incorrectamente",null,promo.getProducto());
		Assert.assertEquals("Aplica2x1 registrado incorrectamente",true,promo.isAplica2x1());
		Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente",true,promo.isAplicaDtoPorCant());
		Assert.assertEquals("DtoPorCant_CantMinima registrada incorrectamente",4,promo.getDtoPorCant_CantMinima());
		Assert.assertEquals("DtoPorCant_PrecioUnitario registrada incorrectamente",0.7,promo.getDtoPorCant_PrecioUnitario(),0);	
	}
	
	@Test
	public void ConstructorAplica2x1False()
	{
		Producto prod = new Producto();
		PromocionProd promo = new PromocionProd(true, modelo.Enumerados.diasDePromo.DOMINGO, prod, false, true, 4, 0.7);
		Assert.assertEquals("Producto registrado incorrectamente",prod,promo.getProducto());
		Assert.assertEquals("Aplica2x1 registrado incorrectamente",false,promo.isAplica2x1());
		Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente",true,promo.isAplicaDtoPorCant());
		Assert.assertEquals("DtoPorCant_CantMinima registrada incorrectamente",4,promo.getDtoPorCant_CantMinima());
		Assert.assertEquals("DtoPorCant_PrecioUnitario registrada incorrectamente",0.7,promo.getDtoPorCant_PrecioUnitario(),0);	
	}
	
	@Test
	public void ConstructorAplicaDtoPorCantFalse()
	{
		Producto prod = new Producto();
		PromocionProd promo = new PromocionProd(true, modelo.Enumerados.diasDePromo.DOMINGO, prod, true, false, 4, 0.7);
		Assert.assertEquals("Producto registrado incorrectamente",prod,promo.getProducto());
		Assert.assertEquals("Aplica2x1 registrado incorrectamente",true,promo.isAplica2x1());
		Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente",false,promo.isAplicaDtoPorCant());
		Assert.assertEquals("DtoPorCant_CantMinima registrada incorrectamente",4,promo.getDtoPorCant_CantMinima());
		Assert.assertEquals("DtoPorCant_PrecioUnitario registrada incorrectamente",0.7,promo.getDtoPorCant_PrecioUnitario(),0);	
	}
	
	@Test
	public void ConstructorDtoPorCant_CantMinimaNegativa()
	{
		Producto prod = new Producto();
		PromocionProd promo = new PromocionProd(true, modelo.Enumerados.diasDePromo.DOMINGO, prod, true, true, -4, 0.7);
		Assert.assertEquals("Producto registrado incorrectamente",prod,promo.getProducto());
		Assert.assertEquals("Aplica2x1 registrado incorrectamente",true,promo.isAplica2x1());
		Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente",true,promo.isAplicaDtoPorCant());
		Assert.assertEquals("DtoPorCant_CantMinima registrada incorrectamente",-4,promo.getDtoPorCant_CantMinima());
		Assert.assertEquals("DtoPorCant_PrecioUnitario registrada incorrectamente",0.7,promo.getDtoPorCant_PrecioUnitario(),0);	
	}
	
	@Test
	public void ConstructorDtoPorCant_PrecioUnitarioNegativo()
	{
		Producto prod = new Producto();
		PromocionProd promo = new PromocionProd(true, modelo.Enumerados.diasDePromo.DOMINGO, prod, true, true, 4, -0.7);
		Assert.assertEquals("Producto registrado incorrectamente",prod,promo.getProducto());
		Assert.assertEquals("Aplica2x1 registrado incorrectamente",true,promo.isAplica2x1());
		Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente",true,promo.isAplicaDtoPorCant());
		Assert.assertEquals("DtoPorCant_CantMinima registrada incorrectamente",4,promo.getDtoPorCant_CantMinima());
		Assert.assertEquals("DtoPorCant_PrecioUnitario registrado incorrectamente",-0.7,promo.getDtoPorCant_PrecioUnitario(),0);	
	}

	@Test
	public void testSetAplica2x1()
	{
		PromocionProd promo = new PromocionProd();
		promo.setAplica2x1(false);
		Assert.assertEquals("Nuevo aplica2x1 registrado incorrectamente",false,promo.isAplica2x1());

	}
	
	@Test
	public void testSetDtoPorCant()
	{
		PromocionProd promo = new PromocionProd();
		promo.setAplicaDtoPorCant(false);
		Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente",false,promo.isAplicaDtoPorCant());
	}
	
	@Test
	public void testSetDtoPorCant_CantMinima()
	{
		PromocionProd promo = new PromocionProd();
		promo.setDtoPorCant_CantMinima(8);
		Assert.assertEquals("Nueva DtoPorCant_CantMinima registrada incorrectamente",8,promo.getDtoPorCant_CantMinima());
	}
	
	@Test
	public void testSetDtoPorCant_PrecioUnitario()
	{
		PromocionProd promo = new PromocionProd();
		promo.setDtoPorCant_PrecioUnitario(90.);
		Assert.assertEquals("Nuevo DtoPorCant_PrecioUnitario registrado incorrectamente",90.,promo.getDtoPorCant_PrecioUnitario(),0);
	}
	
	@Test
	public void testSetIdProm()
	{
		PromocionProd promo = new PromocionProd();
		promo.setIdProm(23);
		Assert.assertEquals("Nuevo idProm registrado incorrectamente",23,promo.getIdProm());
	}
	
	@Test
	public void testSetProducto()
	{
		Producto prod = new Producto(); 
		PromocionProd promo = new PromocionProd();
		promo.setProducto(prod);
		Assert.assertEquals("Nuevo producto registrado incorrectamente",prod,promo.getProducto());
	}
}
