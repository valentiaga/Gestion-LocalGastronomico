package test;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.MesaNoOcupadaException;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;
import negocio.FuncionalidadOperario;
import negocio.Sistema;

public class IntegracionEscenario1
{

	FuncionalidadOperario fO;
	Mesa MesaConPromProd;
	Mesa MesaSinPromProd;
	Mesa MesaLibre;

	@Before
	public void setUp() throws Exception
	{
		/**
		 * 
		 * 
		 *      
		 *      CON PRODUCTO CON PROMOCIÓN
		 * 
		 * 
		 */
		this.fO = new FuncionalidadOperario();
		Producto prod1 = new Producto("Rata ahumada", 2, 230, 1);
		Sistema.getInstance().getProductos().put(prod1.getIdProd(), prod1);
		this.MesaConPromProd = new Mesa(10);
		Mozo mozo = new Mozo("nombre", 3);
		Sistema.getInstance().getMozos().put("nombre", mozo);
		this.MesaConPromProd.setMozo(mozo);
		this.MesaConPromProd.setEstado(Enumerados.estadoMesa.OCUPADA);
		Sistema.getInstance().getMesas().put(this.MesaConPromProd.getNroMesa(), this.MesaConPromProd);
		Comanda com = new Comanda(this.MesaConPromProd, Enumerados.estadoComanda.ABIERTO);
		ArrayList<Pedido> peds = new ArrayList<Pedido>();
		Pedido ped = new Pedido(prod1, 2);
		peds.add(ped);
		com.setPedidos(peds);
		Sistema.getInstance().getComandas().add(com);
		this.MesaConPromProd.setComanda(com);// al parecer en este programa decidieron hacer doble referencia entre mesa
												// y
		// comanda!!
		PromocionTemporal promotemp1 = new PromocionTemporal(true, Enumerados.diasDePromo.SABADO, "dia del arquero",
				Enumerados.formaDePago.TARJETA, 5, true, 1, 24);
		Sistema.getInstance().getPromocionesTemp().add(promotemp1);
		com.getFecha().set(Calendar.DAY_OF_WEEK, promotemp1.getDiasDePromo().ordinal() + 2);
		promotemp1.setHoraInicio(com.getFecha().get(Calendar.HOUR_OF_DAY));
		PromocionProd promprod1 = new PromocionProd(true, modelo.Enumerados.diasDePromo.MIERCOLES, prod1, true, true, 2,
				0.1);
		Sistema.getInstance().getPromocionProds().put(promprod1.getIdProm(), promprod1);
		/**
		 * 
		 * 
		 *      
		 *      CON PRODUCTO SIN PROMOCIÓN
		 * 
		 * 
		 */
		Producto prod2 = new Producto("aire enlatado mmmm que rico", 2, 230, 1);
		Sistema.getInstance().getProductos().put(prod2.getIdProd(), prod2);
		this.MesaSinPromProd = new Mesa(3);
		this.MesaSinPromProd.setMozo(mozo);
		this.MesaSinPromProd.setEstado(Enumerados.estadoMesa.OCUPADA);
		Sistema.getInstance().getMesas().put(this.MesaSinPromProd.getNroMesa(), this.MesaSinPromProd);
		Comanda com2 = new Comanda(this.MesaSinPromProd, Enumerados.estadoComanda.ABIERTO);
		ArrayList<Pedido> peds2 = new ArrayList<Pedido>();
		Pedido ped2 = new Pedido(prod2, 2);
		peds2.add(ped2);
		com2.setPedidos(peds2);
		Sistema.getInstance().getComandas().add(com2);
		this.MesaSinPromProd.setComanda(com2);// al parecer en este programa decidieron hacer doble referencia entre
												// mesa y
		// comanda!!
		com2.getFecha().set(Calendar.DAY_OF_WEEK, promotemp1.getDiasDePromo().ordinal() + 2);
		promotemp1.setHoraInicio(com2.getFecha().get(Calendar.HOUR_OF_DAY));
		Sistema.getInstance().getPromocionProds().put(promprod1.getIdProm(), promprod1);
		/**
		 * 
		 * 
		 *
		 *      CON MESA LIBRE 
		 * 
		 * 
		 */
		this.MesaLibre = new Mesa(9);
		Sistema.getInstance().getMesas().put(this.MesaLibre.getNroMesa(), this.MesaLibre);
	}

	@After
	public void tearDown() throws Exception
	{
		// necesito hacer esto porque Sistema es Singleton entonces acumula en las
		// colecciones a pesar de usar Before en vez de BeforeClass
		Sistema.getInstance().getMozos().clear();
		Sistema.getInstance().getOperariosRegistrados().clear();
		Sistema.getInstance().getProductos().clear();
		Sistema.getInstance().getComandas().clear();
		Sistema.getInstance().getMesas().clear();
		Sistema.getInstance().getPromocionProds().clear();
		Sistema.getInstance().getPromocionesTemp().clear();
		// De igual manera necesito hacer esto porque siguienteIdProd, SiguienteNroMesa
		// y SigIdProm son static
		Producto.setSiguienteIdProd(0);
		Mesa.setSiguienteNroMesa(0);
		PromocionProd.setSigIdProm(0);
	}

	@Test
	public void testCierraMesaConPromProd()
	{
		try
		{
			this.fO.cierraMesa(this.MesaConPromProd.getNroMesa(), Enumerados.formaDePago.CTADNI);
		} catch (MesaNoOcupadaException e)
		{
			Assert.fail("No debería lanzar ninguna excepción.");
		}
	}

	@Test
	public void testCierraMesaSinPromProd()
	{
		try
		{
			this.fO.cierraMesa(this.MesaSinPromProd.getNroMesa(), Enumerados.formaDePago.EFECTIVO);
		} catch (MesaNoOcupadaException e)
		{
			Assert.fail("No debería lanzar ninguna excepción.");
		}
	}

	@Test
	public void testCierraMesaFueraDelSistema()
	{
		try
		{
			Mesa MesaFueraDelSistema = new Mesa(3);
			this.fO.cierraMesa(MesaFueraDelSistema.getNroMesa(), Enumerados.formaDePago.MERCPAGO);
			Assert.fail("Debería lanzar MesaNoOcupadaException");
		} catch (MesaNoOcupadaException e)
		{

		}
	}

	@Test
	public void testCierraMesaLibre()
	{
		try
		{
			this.fO.cierraMesa(this.MesaLibre.getNroMesa(), Enumerados.formaDePago.TARJETA);
			Assert.fail("Debería lanzar MesaNoOcupadaException");
		} catch (MesaNoOcupadaException e)
		{

		}
	}

	@Test
	public void testCierraMesaFormaDePagoNull()
	{
		try
		{
			this.fO.cierraMesa(this.MesaConPromProd.getNroMesa(), null);
		} catch (MesaNoOcupadaException e)
		{
			Assert.fail("No debería lanzar ninguna excepción.");
		}
	}

}
