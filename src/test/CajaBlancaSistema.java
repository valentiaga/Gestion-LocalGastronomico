package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.OperarioInactivo_Exception;
import excepciones.UserNameIncorrecto_Exception;
import modelo.Administrador;
import modelo.Operario;
import negocio.Sistema;

/**
 * 
 * ACA SE CUBREN LAS LINEAS DE Sistema QUE NO FUERON CUBIERTAS EN
 * CajaNegraSistema
 *
 */

public class CajaBlancaSistema
{
	Operario op;
	Operario adm; // tengo que poner operario en vez de administrador porque le pusieron un
					// constructor vacio al admin!!!!

	@Before
	public void setUp() throws Exception
	{
		this.op = new Operario("Aureliano", "aureeliano", "abdRty2uo", true);
		this.adm = new Operario("Paula", "ADMIN", "bnmkloiuy7s", true);
		op.setActivo(false);
		Sistema.getInstance().getOperariosRegistrados().put(op.getUserName(), op);
		Sistema.getInstance().getOperariosRegistrados().put(adm.getUserName(), adm);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLoginOperarioInactivo()
	{
		try
		{
			Sistema.getInstance().login(this.op.getUserName(), this.op.getPassword());
			Assert.fail("Deberia lanzarse OperarioInactivo_Exception");
		} catch (UserNameIncorrecto_Exception e)
		{
			Assert.fail("Deberia lanzarse OperarioInactivo_Exception");
		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("Deberia lanzarse OperarioInactivo_Exception");
		} catch (OperarioInactivo_Exception e)
		{

		}
	}

	@Test
	public void testLoginSupuestoAdministradorQueEnRealidadNoLoEsPorqueSeLesCantoPonerConstructorVacio()
	{
		try
		{
			Sistema.getInstance().login(this.adm.getUserName(), this.adm.getPassword());
			Assert.assertEquals("Administrador logueado incorrectamente",this.adm, Sistema.getInstance().getFuncionalidadAdmin().getOperario());
		} catch (UserNameIncorrecto_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (OperarioInactivo_Exception e)
		{

		}
	}

}
