package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Operario;

public class CajaNegraOperario
{

	@Test
	public void testConstructorActivoTrue()
	{
		Operario op = new Operario("Roberto Rodriguez", "RobertoR", "Roberto123", true);
		Assert.assertEquals("NyA registrado incorrectamente","Roberto Rodriguez",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","RobertoR",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","Roberto123",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	
	@Test
	public void testConstructorActivoFalse()
	{
		Operario op = new Operario("Roberto Rodriguez", "RobertoR", "Roberto123", false);
		Assert.assertEquals("NyA registrado incorrectamente","Roberto Rodriguez",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","RobertoR",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","Roberto123",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",false,op.isActivo());
	}
	
	@Test
	public void testConstructorNyAVacio()
	{
		Operario op = new Operario("","RobertoR", "Roberto123", true);
		Assert.assertEquals("NyA registrado incorrectamente","",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","RobertoR",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","Roberto123",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	
	@Test
	public void testConstructorNyANull()
	{
		Operario op = new Operario(null,"RobertoR", "Roberto123", true);
		Assert.assertEquals("NyA registrado incorrectamente",null,op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","RobertoR",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","Roberto123",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	

	@Test
	public void testConstructorUserNameVacio()
	{
		Operario op = new Operario("Roberto Rodriguez", "", "Roberto123", true);
		Assert.assertEquals("NyA registrado incorrectamente","Roberto Rodriguez",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","Roberto123",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	
	@Test
	public void testConstructorUserNameNull()
	{
		Operario op = new Operario("Roberto Rodriguez", null, "Roberto123", true);
		Assert.assertEquals("NyA registrado incorrectamente","Roberto Rodriguez",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente",null,op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","Roberto123",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	
	@Test
	public void testConstructorPasswordVacia()
	{
		Operario op = new Operario("Roberto Rodriguez", "RobertoR", "", true);
		Assert.assertEquals("NyA registrado incorrectamente","Roberto Rodriguez",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","RobertoR",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente","",op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	
	@Test
	public void testConstructorPasswordNull()
	{
		Operario op = new Operario("Roberto Rodriguez", "RobertoR", null, true);
		Assert.assertEquals("NyA registrado incorrectamente","Roberto Rodriguez",op.getNyA());
		Assert.assertEquals("Username registrado incorrectamente","RobertoR",op.getUserName());
		Assert.assertEquals("Password registrado incorrectamente",null,op.getPassword());
		Assert.assertEquals("Activo registrado incorrectamente",true,op.isActivo());
	}
	
	@Test
	public void testSetNyA()
	{
		Operario op = new Operario();
		op.setNyA("Akini Jing");
		Assert.assertEquals("Nuevo NyA registrado incorrectamente","Akini Jing",op.getNyA());
	}
	
	@Test
	public void testSetActivo()
	{
		Operario op = new Operario();
		op.setActivo(false);
		Assert.assertEquals("Nuevo activo registrado incorrectamente",false,op.isActivo());
	}
	
	@Test
	public void testSetPassword()
	{
		Operario op = new Operario();
		op.setPassword("ContraComplicada");
		Assert.assertEquals("Nueva password registrada incorrectamente","ContraComplicada",op.getPassword());
	}
	
	@Test
	public void testSetUserName()
	{
		Operario op = new Operario();
		op.setUserName("aaaaaaaaure");
		Assert.assertEquals("Nueva username registrado incorrectamente","aaaaaaaaure",op.getUserName());
	}

}
