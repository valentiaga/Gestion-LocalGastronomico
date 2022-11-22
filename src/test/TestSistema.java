package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.OperarioInactivo_Exception;
import excepciones.UserNameIncorrecto_Exception;
import modelo.Operario;
import negocio.Sistema;

public class TestSistema
{

	@Before
	public void setUp() throws Exception
	{
		Operario op1 = new Operario("Aureliano", "aureeliano", "abdRty2uo", true);
		Operario op2 = new Operario("Paula", "paulixi", "bnmkloiuy7s", true);
		Sistema.getInstance().getOperariosRegistrados().put(op1.getUserName(), op1);
		Sistema.getInstance().getOperariosRegistrados().put(op2.getUserName(), op2);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLoginCorrecto()
	{
		Operario op = Sistema.getInstance().getOperariosRegistrados().get("aureeliano");
		try
		{
			Sistema.getInstance().login(op.getUserName(), op.getPassword());
			Assert.assertEquals("No se efectuo el logueo correctamente", op,
					Sistema.getInstance().getFuncionalidadOperario().getOperario());
		} catch (UserNameIncorrecto_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (OperarioInactivo_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testLoginUsernameIncorrecto()
	{
		Operario op = Sistema.getInstance().getOperariosRegistrados().get("aureeliano");
		try
		{
			Sistema.getInstance().login("este tp esta tomando demasiado trabajo y me temo que vamos a desaprobar",
					op.getPassword());
			Assert.fail("Deberia lanzarse UserNameIncorrecto_Exception");
		} catch (UserNameIncorrecto_Exception e)
		{

		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("Deberia lanzarse UserNameIncorrecto_Exception");
		} catch (OperarioInactivo_Exception e)
		{
			Assert.fail("Deberia lanzarse UserNameIncorrecto_Exception");
		}
	}

	@Test
	public void testLoginUsernameNull()
	{
		Operario op = Sistema.getInstance().getOperariosRegistrados().get("aureeliano");
		try
		{
			Sistema.getInstance().login(null, op.getPassword());
			Assert.fail("Deberia lanzarse UserNameIncorrecto_Exception");
		} catch (UserNameIncorrecto_Exception e)
		{

		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("Deberia lanzarse UserNameIncorrecto_Exception");
		} catch (OperarioInactivo_Exception e)
		{
			Assert.fail("Deberia lanzarse UserNameIncorrecto_Exception");
		}
	}

	@Test
	public void testLoginPasswordIncorrecta()
	{
		Operario op = Sistema.getInstance().getOperariosRegistrados().get("aureeliano");
		try
		{
			Sistema.getInstance().login(op.getUserName(), "aaaaaaAaa2");
			Assert.fail("Deberia lanzarse ContrasenaIncorrecta_Exception");
		} catch (UserNameIncorrecto_Exception e)
		{

		} catch (ContrasenaIncorrecta_Exception e)
		{

		} catch (OperarioInactivo_Exception e)
		{
			Assert.fail("Deberia lanzarse ContrasenaIncorrecta_Exception");
		}
	}
}
