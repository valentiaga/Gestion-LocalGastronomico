package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Administrador;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.MesaAtendida;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;
import negocio.Sistema;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

public class TestPersistencia
{

	private IPersistencia persistencia = new PersistenciaXML();
	private String nombre = "testPersistencia.xml";
	private Administrador adm;
	private Comanda comanda;
	private Mesa mesa;
	private MesaAtendida mesaAt;
	private Mozo mozo;
	private Operario op;
	private Producto prod;
	private PromocionProd promP;
	private PromocionTemporal promT;

	@Before
	public void setUp() throws Exception
	{
		this.adm = new Administrador();
		this.comanda = new Comanda();
		this.mesa = new Mesa();
		this.mesaAt = new MesaAtendida();
		this.mozo = new Mozo();
		this.op = new Operario();
		this.prod = new Producto();
		this.promP = new PromocionProd();
		this.promT = new PromocionTemporal();
		File archivo = new File(nombre);
		if (archivo.exists())
			archivo.delete();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	public void vaciarSistema()
	{

	}

	@Test
	public void testCrearArchivo()
	{
		Object obj = new Object();
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(obj);
			persistencia.cerrarOutput();
			File archivo = new File(nombre);
			Assert.assertTrue("Deberia existir el archivo" + nombre, archivo.exists());
		} catch (IOException e)
		{
			Assert.fail("No debería lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testDespersistirSinArchivo()
	{
		
		try
		{
			persistencia.abrirInput(nombre);
			Administrador admAux = (Administrador) persistencia.leer();
			persistencia.cerrarInput();
			Assert.fail("Deberia lanzar FileNotFoundException");
		} catch (FileNotFoundException e)
		{
			
		} catch (ClassNotFoundException e)
		{
			Assert.fail("Deberia lanzar FileNotFoundException");
		} catch (IOException e)
		{
			Assert.fail("Deberia lanzar FileNotFoundException");
		}
	}

	@Test
	public void testAdministradorVacioArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.adm);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Administrador admAux = (Administrador) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", admAux, this.adm);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAdministradorConDatos()
	{
		this.adm.setActivo(true); 
		this.adm.setNyA("Lexie Liu");
		this.adm.setPassword("abnmklop1U");
		this.adm.setUserName("usernamepiolita");
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.adm);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Administrador admAux = (Administrador) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberían ser iguales", admAux, this.adm);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	
	@Test
	public void testComandaVaciaArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.comanda);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Comanda comandaAux = (Comanda) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", comandaAux, this.comanda);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testComandaConDatos()
	{
		this.comanda.setEstado(Enumerados.estadoComanda.CERRADO);
		this.comanda.setMesa(this.mesa);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.comanda);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Comanda comandaAux = (Comanda) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberían ser iguales", comandaAux, this.comanda);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testMesaVaciaArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.mesa);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Mesa mesaAux = (Mesa) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", mesaAux, this.mesa);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testMesaConDatos()
	{
		this.mesa.setCantPax(3);
		this.mesa.setComanda(this.comanda);
		this.mesa.setEstado(Enumerados.estadoMesa.OCUPADA);
		this.mesa.setMozo(this.mozo);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.mesa);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Mesa mesaAux = (Mesa) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberían ser iguales", mesaAux, this.mesa);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	

	@Test
	public void testMesaAtendidaConDatos()
	{
		this.mesaAt.setFormaDePago(Enumerados.formaDePago.EFECTIVO);
		this.mesaAt.setMesa(this.mesa);
		this.mesaAt.setTotal(7895.78);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.mesaAt);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			MesaAtendida mesaAtAux = (MesaAtendida) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberían ser iguales", mesaAtAux, this.mesaAt);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testMesaAtendidaVaciaArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.mesaAt);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			MesaAtendida mesaAtAux = (MesaAtendida) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", mesaAtAux, this.mesaAt);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testMozoVacioArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.mozo);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Mozo mozoAux = (Mozo) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberían ser iguales", mozoAux, this.mozo);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testMozoConDatos()
	{
		this.mozo.setCantHijos(0);
		this.mozo.setEstado(Enumerados.estadoMozo.DEFRANCO);
		this.mozo.setNyA("Jose");
		this.mozo.setSueldo(56000.);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.mozo);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Mozo mozoAux = (Mozo) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberían ser iguales", mozoAux, this.mozo);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testOperarioVacioArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.op);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Operario opAux = (Operario) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", opAux, this.op);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testOperarioConDatos()
	{
		this.op.setActivo(false);
		this.op.setNyA("yasutaka nakata");
		this.op.setPassword("klopui4Unm");
		this.op.setUserName("ystk.nkt");
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.op);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Operario opAux = (Operario) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian ser iguales", opAux, this.op);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testProductoVacioArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.prod);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Producto prodAux = (Producto) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", prodAux, this.prod);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testProductoConDatos()
	{
		this.prod.setNombre("Rasta Flora");
		this.prod.setPrecioCosto(45.9);
		this.prod.setPrecioVenta(100.0);
		this.prod.setStockInicial(4);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.prod);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			Producto prodAux = (Producto) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian ser iguales", prodAux, this.prod);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPromocionProdVaciaArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.promP);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			PromocionProd promPAux = (PromocionProd) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", promPAux, this.promP);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPromocionProdConDatos()
	{
		this.promP.setActiva(false);
		this.promP.setAplica2x1(false);
		this.promP.setAplicaDtoPorCant(true);
		this.promP.setDiasDePromo(Enumerados.diasDePromo.LUNES);
		this.promP.setDtoPorCant_CantMinima(7);
		this.promP.setDtoPorCant_PrecioUnitario(300.8);
		this.promP.setProducto(this.prod);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.promP);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			PromocionProd promPAux = (PromocionProd) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian ser iguales", promPAux, this.promP);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPromocionTemporalVacioArchivo()
	{
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.promT);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			PromocionTemporal promTAux = (PromocionTemporal) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian estar vacíos", promTAux, this.promT);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPromocionTemporalConDatos()
	{
		this.promT.setActiva(true);
		this.promT.setDiasDePromo(Enumerados.diasDePromo.DOMINGO);
		this.promT.setEsAcumulable(false);
		this.promT.setFormaDePago(Enumerados.formaDePago.MERCPAGO);
		this.promT.setHoraFinal(14);
		this.promT.setHoraInicio(9);
		this.promT.setNombre("quiero terminar con estoooo");
		this.promT.setPorcentajeDesc(7);
		try
		{
			persistencia.abrirOutput(nombre);
			persistencia.escribir(this.promT);
			persistencia.cerrarOutput();
			persistencia.abrirInput(nombre);
			PromocionTemporal promTAux = (PromocionTemporal) persistencia.leer();
			persistencia.cerrarInput();
			Assert.assertEquals("Los objetos deberian ser iguales", promTAux, this.promT);
		} catch (FileNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ClassNotFoundException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (IOException e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
}
