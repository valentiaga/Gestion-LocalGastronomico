package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.MesaOcupada_Exception;
import excepciones.MozoInactivo_Exception;
import excepciones.NoExisteMesa_Exception;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Producto;
import modelo.PromocionProd;
import negocio.FuncionalidadOperario;
import negocio.Sistema;

public class CajaNegraFuncionalidadOperarioNingunMozoActivo
{

	private FuncionalidadOperario fO;

	@Before
	public void setUp() throws Exception
	{
		this.fO = new FuncionalidadOperario();
		Mesa mesa1 = new Mesa(3);
		Mesa mesa2 = new Mesa(4);
		Sistema.getInstance().getMesas().put(mesa1.getNroMesa(), mesa1);
		Sistema.getInstance().getMesas().put(mesa2.getNroMesa(), mesa2);
		Mozo mozo1 = new Mozo("Salome", 1);
		Mozo mozo2 = new Mozo("Quimey", 7);
		mozo1.setEstado(Enumerados.estadoMozo.DEFRANCO);
		mozo2.setEstado(Enumerados.estadoMozo.AUSENTE);
		Sistema.getInstance().getMozos().put("Salome", mozo1);
		Sistema.getInstance().getMozos().put("Quimey", mozo2);
	}

	@After
	public void tearDown() throws Exception
	{
		// necesito hacer esto porque Sistema es Singleton entonces acumula en las
		// colecciones a pesar de usar Before en vez de BeforeClass
		Sistema.getInstance().getMozos().clear();
		Sistema.getInstance().getMesas().clear();
		// De igual manera necesito hacer esto porque SiguienteNroMesa es static
		Mesa.setSiguienteNroMesa(0);
	}

	@Test
	public void testAbreComandaMesaNingunMozoActivo()
	{
		Mesa mesa = Sistema.getInstance().getMesas().get(0);
		try
		{
			this.fO.abreComanda(mesa);
			Assert.fail("Deberia lanzar MozoInactivo_Exception");
		} catch (MesaOcupada_Exception e)
		{
			Assert.fail("Deberia lanzar MozoInactivo_Exception");
		} catch (MozoInactivo_Exception e)
		{
			
		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("Deberia lanzar MozoInactivo_Exception");
		}
	}

}
