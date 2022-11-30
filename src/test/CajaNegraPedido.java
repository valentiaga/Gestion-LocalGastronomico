package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Pedido;
import modelo.Producto;

public class CajaNegraPedido
{

	@Test
	public void ConstructorCantPositiva()
	{
		Producto prod = new Producto();
		Pedido pedido = new Pedido(prod,3);
		Assert.assertEquals("Producto registrado incorrectamente",prod,pedido.getProducto());
		Assert.assertEquals("Cant registrada incorrectamente",3,pedido.getCant());
	}
	
	@Test
	public void ConstructorCantNegativa()
	{
		Producto prod = new Producto();
		Pedido pedido = new Pedido(prod,-7);
		Assert.assertEquals("Producto registrado incorrectamente",prod,pedido.getProducto());
		Assert.assertEquals("Cant registrada incorrectamente",-7,pedido.getCant());
	}
	
	@Test
	public void ConstructorProductoNull()
	{
		Pedido pedido = new Pedido(null,3);
		Assert.assertEquals("Producto registrado incorrectamente",null,pedido.getProducto());
		Assert.assertEquals("Cant registrada incorrectamente",3,pedido.getCant());
	}
	
	@Test
	public void testSetProducto()
	{
		Pedido pedido = new Pedido(null,3);
		Producto prod = new Producto();
		pedido.setProducto(prod);
		Assert.assertEquals("Nuevo producto registrado incorrectamente",prod,pedido.getProducto());
	}
	
	@Test
	public void testSetCant()
	{
		Pedido pedido = new Pedido(null,3);
		pedido.setCant(9);
		Assert.assertEquals("Cant registrada incorrectamente",9,pedido.getCant());
	}
}
