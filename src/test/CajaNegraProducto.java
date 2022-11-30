package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Producto;

public class CajaNegraProducto
{

	@Test
	public void Constructor()
	{
		Producto prod = new Producto("Guiso de fideos mmmm que rico",70.,75.,8);
		Assert.assertEquals("Nombre registrado incorrectamente","Guiso de fideos mmmm que rico",prod.getNombre());
		Assert.assertEquals("PrecioCosto registrado incorrectamente",70.,prod.getPrecioCosto(),0);
		Assert.assertEquals("PrecioVenta registrado incorrectamente",75.,prod.getPrecioVenta(),0);
		Assert.assertEquals("StockInicial registrado incorrectamente",8,prod.getStockInicial());
	}
	
	@Test
	public void ConstructorNombreVacio()
	{
		Producto prod = new Producto("",70.,75.,8);
		Assert.assertEquals("Nombre registrado incorrectamente","",prod.getNombre());
		Assert.assertEquals("PrecioCosto registrado incorrectamente",70.,prod.getPrecioCosto(),0);
		Assert.assertEquals("PrecioVenta registrado incorrectamente",75.,prod.getPrecioVenta(),0);
		Assert.assertEquals("StockInicial registrado incorrectamente",8,prod.getStockInicial());
	}
	
	@Test
	public void ConstructorNombreNull()
	{
		Producto prod = new Producto(null,70.,75.,8);
		Assert.assertEquals("Nombre registrado incorrectamente",null,prod.getNombre());
		Assert.assertEquals("PrecioCosto registrado incorrectamente",70.,prod.getPrecioCosto(),0);
		Assert.assertEquals("PrecioVenta registrado incorrectamente",75.,prod.getPrecioVenta(),0);
		Assert.assertEquals("StockInicial registrado incorrectamente",8,prod.getStockInicial());
	}
	
	@Test
	public void ConstructorPrecioCostoNegativo()
	{
		Producto prod = new Producto("Guiso de fideos mmmm que rico",-70.,75.,8);
		Assert.assertEquals("Nombre registrado incorrectamente","Guiso de fideos mmmm que rico",prod.getNombre());
		Assert.assertEquals("PrecioCosto registrado incorrectamente",-70.,prod.getPrecioCosto(),0);
		Assert.assertEquals("PrecioVenta registrado incorrectamente",75.,prod.getPrecioVenta(),0);
		Assert.assertEquals("StockInicial registrado incorrectamente",8,prod.getStockInicial());
	}
	
	@Test
	public void ConstructorPrecioVentaNegativo()
	{
		Producto prod = new Producto("Guiso de fideos mmmm que rico",70.,-75.,8);
		Assert.assertEquals("Nombre registrado incorrectamente","Guiso de fideos mmmm que rico",prod.getNombre());
		Assert.assertEquals("PrecioCosto registrado incorrectamente",70.,prod.getPrecioCosto(),0);
		Assert.assertEquals("PrecioVenta registrado incorrectamente",-75.,prod.getPrecioVenta(),0);
		Assert.assertEquals("StockInicial registrado incorrectamente",8,prod.getStockInicial());
	}
	
	@Test
	public void ConstructorStockInicialNegativo()
	{
		Producto prod = new Producto("Guiso de fideos mmmm que rico",70.,75.,-8);
		Assert.assertEquals("Nombre registrado incorrectamente","Guiso de fideos mmmm que rico",prod.getNombre());
		Assert.assertEquals("PrecioCosto registrado incorrectamente",70.,prod.getPrecioCosto(),0);
		Assert.assertEquals("PrecioVenta registrado incorrectamente",75.,prod.getPrecioVenta(),0);
		Assert.assertEquals("StockInicial registrado incorrectamente",-8,prod.getStockInicial());
	}
	
	@Test 
	public void testSetIdProd()
	{
		Producto prod = new Producto();
		prod.setIdProd(17);
		Assert.assertEquals("Nuevo IdProd registrado incorrectamente",17,prod.getIdProd());
	}
	
	@Test 
	public void testSetNombre()
	{
		Producto prod = new Producto();
		prod.setNombre("morcilla vegana");
		Assert.assertEquals("Nuevo nombre registrado incorrectamente","morcilla vegana",prod.getNombre());
	}
	
	@Test 
	public void testSetPrecioCosto()
	{
		Producto prod = new Producto();
		prod.setPrecioCosto(83.);
		Assert.assertEquals("Nuevo precioCosto registrado incorrectamente",83.,prod.getPrecioCosto(),0);
	}
	
	@Test 
	public void testSetPrecioVenta()
	{
		Producto prod = new Producto();
		prod.setPrecioVenta(87.);
		Assert.assertEquals("Nuevo precioVenta registrado incorrectamente",87.,prod.getPrecioVenta(),0);
	}
	
	@Test 
	public void testSetStockInicial()
	{
		Producto prod = new Producto();
		prod.setStockInicial(90);
		Assert.assertEquals("Nuevo StockInicial registrado incorrectamente",90,prod.getStockInicial());
	}

}
