package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.UserNameRepetido_Exception;
import modelo.Enumerados;
import modelo.Operario;
import negocio.FuncionalidadAdmin;
import negocio.Sistema;

/**
 * 
 * ACA SE CUBREN LAS LINEAS DE FuncionalidadAdmin QUE NO FUERON CUBIERTAS EN
 * CajaNegraFuncionalidadAdmin
 *
 */

public class CajaBlancaFuncionalidadAdmin
{
	FuncionalidadAdmin fA;

	@Before
	public void setUp() throws Exception
	{
		this.fA = new FuncionalidadAdmin(new Operario("Valentina", "valus", "marioneta", true));
		Sistema.getInstance().getOperariosRegistrados().put("aureeliano",
				new Operario("Aureliano", "aureeliano", "zimbhalabim", true));
	}

	@After
	public void tearDown() throws Exception
	{
		Sistema.getInstance().getOperariosRegistrados().clear();
	}

	@Test
	public void testRegistraOperario()
	{
		try
		{
			this.fA.registraOperario("Mateo", "aureeliano", "aghjkliuy1A", Enumerados.estadoOperario.ACTIVO);
			Assert.fail("Deberia lanzarse UserNameRepetido_Exception");
		} catch (UserNameRepetido_Exception e)
		{

		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("Deberia lanzarse UserNameRepetido_Exception");
		}
	}

}
