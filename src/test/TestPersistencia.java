package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cerveceria;
import modelo.Producto;
import persistencia.Persiste;

/*
 * Clase que testea la persistencia
 */
public class TestPersistencia 
{
	Cerveceria cerveceria;
	File archivo = new File ("ArchivoPersistencia.xml");
	
	
	public TestPersistencia() 
	{
	}

	@Before
	public void setUp() throws Exception 
	{
		cerveceria = new Cerveceria();
		if (archivo.exists())
			archivo.delete();
	}

	
	@After
	public void tearDown() throws Exception 
	{
	}

	public void agregaProd(Cerveceria cerveceria)
	{
		try 
		{
			cerveceria.getProductos().put(0, new Producto("Pizza", 10, 20, 10));
			cerveceria.getProductos().put(1, new Producto("Agua", 20, 30, 10));
			cerveceria.getProductos().put(2, new Producto("Papas", 20, 40, 10));
		} catch(Exception e)
		{
			Assert.fail("No debería de lanzar excepción");
		}
		
		
	
	}
}
