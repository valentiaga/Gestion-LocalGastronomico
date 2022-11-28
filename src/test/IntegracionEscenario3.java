package test;

import static org.junit.Assert.*;

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

public class IntegracionEscenario3
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
		 * CON PRODUCTO CON PROMOCIÓN
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
		PromocionProd promprod1 = new PromocionProd(true, modelo.Enumerados.diasDePromo.MIERCOLES, prod1, true, true, 2,
				0.1);
		Sistema.getInstance().getPromocionProds().put(promprod1.getIdProm(), promprod1);
		/**
		 * 
		 * 
		 * 
		 * CON PRODUCTO SIN PROMOCIÓN
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
		Sistema.getInstance().getPromocionProds().put(promprod1.getIdProm(), promprod1);
	}

	@After
	public void tearDown() throws Exception
	{
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

}
