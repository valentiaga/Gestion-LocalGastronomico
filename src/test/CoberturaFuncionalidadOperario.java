package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.CantComensalesInvalida_Exception;
import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.PromoInvalida_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
import modelo.PromocionProd;
import negocio.FuncionalidadOperario;
import negocio.Sistema;

public class CoberturaFuncionalidadOperario
{

	FuncionalidadOperario fO;
	Producto prod;

	@Before
	public void setUp() throws Exception
	{
		this.fO = new FuncionalidadOperario(new Operario("Juliana", "juliesx", "loolt4", true));
		Operario op1 = new Operario("Carlos", "ca7l1t05", "hjjjjrt52", true);
		Sistema.getInstance().getOperariosRegistrados().put(op1.getUserName(), op1);
		this.prod = new Producto("pie humano", 2457., 3000., 78);
		Pedido ped = new Pedido(this.prod, 2);
		Mesa mesa = new Mesa(4);
		Mesa mesa2 = new Mesa(4);
		Comanda com = new Comanda(mesa, Enumerados.estadoComanda.ABIERTO);
		com.getPedidos().add(ped);
		mesa.setComanda(com); // increiblemente aplicaron doble referencia entre mesa y comanda
		PromocionProd promprod = new PromocionProd();
		Sistema.getInstance().getProductos().put(this.prod.getIdProd(), this.prod);
		Sistema.getInstance().getMesas().put(mesa.getNroMesa(), mesa);
		Sistema.getInstance().getMesas().put(mesa2.getNroMesa(), mesa2);
		Sistema.getInstance().getComandas().add(com);
		Sistema.getInstance().getPromocionProds().put(promprod.getIdProm(), promprod);

	}

	@After
	public void tearDown() throws Exception
	{
		Sistema.getInstance().getOperariosRegistrados().clear();
		Sistema.getInstance().getProductos().clear();
		Sistema.getInstance().getMesas().clear();
		Sistema.getInstance().getComandas().clear();
		Producto.setSiguienteIdProd(0);
		Mesa.setSiguienteNroMesa(0);
	}

	@Test
	public void testModificaOperario()
	{
		try
		{
			this.fO.modificaOperario("nuevo nombre", "username nuevo", "abnmolytQ5L");
			Assert.assertEquals("Nuevo username registrado incorrectamente", this.fO.getOperario().getUserName(),
					"username nuevo");
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", this.fO.getOperario().getNyA(),
					"nuevo nombre");
			Assert.assertEquals("Nueva password registrado incorrectamente", this.fO.getOperario().getPassword(),
					"abnmolytQ5L");
		} catch (UserNameRepetido_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (ContrasenaIncorrecta_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaProducto()
	{
		try
		{
			this.fO.modificaProducto(this.prod.getIdProd(), "nombre nuevo", 768., 1000., 7);
			Assert.fail("Deberia lanzar prodEnUso_Exception");
		} catch (precioInvalido_Exception e)
		{
			Assert.fail("Deberia lanzar prodEnUso_Exception");
		} catch (prodEnUso_Exception e)
		{

		} catch (NoExisteID_Exception e)
		{
			Assert.fail("Deberia lanzar prodEnUso_Exception");
		}
	}
	
	@Test 
	public void testModificaMesa()
	{
		Mesa mesa = Sistema.getInstance().getMesas().get(1);
		try
		{
			this.fO.modificaMesa(mesa.getNroMesa(), 1, Enumerados.estadoMesa.OCUPADA);
			Assert.fail("Deberia lanzar CantComensalesInvalida_Exception");
		} catch (CantComensalesInvalida_Exception e)
		{

		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("Deberia lanzar CantComensalesInvalida_Exception");
		}
	}
	
	@Test
	public void testAgregaPromocionProd()
	{
		try
		{
			this.fO.agregaPromocionProd(this.prod.getIdProd(), Enumerados.diasDePromo.JUEVES, false, false, 2, 0.15, true);
		Assert.fail("Deberia lanzar PromoInvalida_Exception");
		} catch (PromoInvalida_Exception e)
		{
			
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("Deberia lanzar PromoInvalida_Exception");
		}
	}
	
	@Test
	public void testModificaPromocionProd()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MIERCOLES, false, false, 7, 0.7);
		} catch (PromoInvalida_Exception e)
		{

		} catch (NoExisteID_Exception e)
		{
			Assert.fail("Deberia lanzar PromoInvalida_Exception");
		}
	}
}
