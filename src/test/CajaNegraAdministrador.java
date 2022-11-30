package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Administrador;

public class CajaNegraAdministrador
{

	@Test
	public void testConstructor()
	{
		Administrador adm = new Administrador();
		Assert.assertEquals("Nombre registrado incorrectamente",null,adm.getNyA());
		Assert.assertEquals("Username registrado incorrectamente",null,adm.getUserName());
		Assert.assertEquals("Password registrado incorrectamente",null,adm.getPassword());
	}
	
	@Test
	public void testSetNyA()
	{
		Administrador adm = new Administrador();
		adm.setNyA("Aureliano");
		Assert.assertEquals("Nuevo nombre registrado incorrectamente","Aureliano",adm.getNyA());
	}
	
	@Test
	public void testSetUserName()
	{
		Administrador adm = new Administrador();
		adm.setUserName("aureeliano");
		Assert.assertEquals("Nuevo username registrado incorrectamente","aureeliano",adm.getUserName());
	}
	
	@Test
	public void testSetPassword()
	{
		Administrador adm = new Administrador();
		adm.setPassword("ahreee");
		Assert.assertEquals("Nueva password registrado incorrectamente","ahreee",adm.getPassword());
		
	}

}
