package test;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.CantComensalesInvalida_Exception;
import excepciones.CantHijosInvalida_Exception;
import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.EstadoIncorrecto_Exception;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupada_Exception;
import excepciones.MozoInactivo_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NyARepetido_Exception;
import excepciones.PromoInvalida_Exception;
import excepciones.PromoRepetida_Exception;
import excepciones.StockInsuficiente_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;
import negocio.FuncionalidadAdmin;
import negocio.FuncionalidadOperario;
import negocio.Sistema;

public class TestFuncionalidadOperarioConDatos
{

	private FuncionalidadOperario fO;
	private Mozo mozo;

	@Before
	public void setUp() throws Exception
	{
		this.fO = new FuncionalidadOperario(new Operario("Aureliano", "aureeliano", "ja!jeji", true));
		this.mozo = new Mozo("Paula", 0);
		Sistema.getInstance().getMozos().put(this.mozo.getNyA(), this.mozo);
		Mozo mozo1 = new Mozo("Mario", 2);
		Mozo mozo2 = new Mozo("Salome", 1);
		Mozo mozo3 = new Mozo("Quimey", 7);
		Sistema.getInstance().getMozos().put("Mario", mozo1);
		Sistema.getInstance().getMozos().put("Salome", mozo2);
		Sistema.getInstance().getMozos().put("Quimey", mozo3);
		Sistema.getInstance().getOperariosRegistrados().put(this.fO.getOperario().getUserName(), this.fO.getOperario());
		Sistema.getInstance().getOperariosRegistrados().put("valus",
				new Operario("Valentina", "valus", "marioneta", false));
		Sistema.getInstance().getOperariosRegistrados().put("aquamarina",
				new Operario("Marina", "aquamarina", "carrrnada12", true));

		Producto prod1 = new Producto("Rata ahumada", 2, 230, 1);
		Producto prod2 = new Producto("Milanesa de cemento", 189, 430, 3);
		Sistema.getInstance().getProductos().put(prod1.getIdProd(), prod1);
		Sistema.getInstance().getProductos().put(prod2.getIdProd(), prod2);
		Comanda com1 = new Comanda();
		ArrayList<Pedido> peds = new ArrayList<Pedido>();
		Pedido ped = new Pedido(prod1, 2);
		peds.add(ped);
		com1.setPedidos(peds);
		com1.setEstado(Enumerados.estadoComanda.ABIERTO);
		Sistema.getInstance().getComandas().add(com1);
		Mesa mesa1 = new Mesa(3);
		Mesa mesa2 = new Mesa(10);
		Mesa mesa3 = new Mesa(7);
		Mesa mesa4 = new Mesa(2);
		Mesa mesa5 = new Mesa(5);
		mesa2.setEstado(Enumerados.estadoMesa.OCUPADA);
		mesa4.setEstado(Enumerados.estadoMesa.OCUPADA);
		mesa1.setMozo(mozo);
		mesa2.setMozo(mozo1);
		Comanda com2 = new Comanda(mesa2, Enumerados.estadoComanda.ABIERTO);
		mesa2.setComanda(com2);// al parecer en este programa decidieron hacer doble referencia entre mesa y
		// comanda!!
		com2.setPedidos(peds);
		Sistema.getInstance().getComandas().add(com2);
		Comanda com3 = new Comanda(mesa5, Enumerados.estadoComanda.ABIERTO);
		Sistema.getInstance().getComandas().add(com3);
		mesa5.setComanda(com3);
		Sistema.getInstance().getMesas().put(mesa1.getNroMesa(), mesa1);
		Sistema.getInstance().getMesas().put(mesa2.getNroMesa(), mesa2);
		Sistema.getInstance().getMesas().put(mesa3.getNroMesa(), mesa3);
		Sistema.getInstance().getMesas().put(mesa4.getNroMesa(), mesa4);
		Sistema.getInstance().getMesas().put(mesa5.getNroMesa(), mesa5);
		PromocionProd promprod1 = new PromocionProd(true, modelo.Enumerados.diasDePromo.MIERCOLES, prod1, true, true, 2,
				0.1);
		PromocionProd promprod2 = new PromocionProd(true, modelo.Enumerados.diasDePromo.SABADO, prod2, false, true, 3,
				0.3);
		Sistema.getInstance().getPromocionProds().put(promprod1.getIdProm(), promprod1);
		Sistema.getInstance().getPromocionProds().put(promprod2.getIdProm(), promprod2);
		PromocionTemporal promotemp1 = new PromocionTemporal(true, Enumerados.diasDePromo.SABADO, "dia del arquero",
				Enumerados.formaDePago.TARJETA, 5, true, 1, 24);
		PromocionTemporal promotemp2 = new PromocionTemporal(true, Enumerados.diasDePromo.MARTES,
				"mis vacaciones (nunca)", Enumerados.formaDePago.CTADNI, 3, true, 1, 7);
		Sistema.getInstance().getPromocionesTemp().add(promotemp1);
		Sistema.getInstance().getPromocionesTemp().add(promotemp2);
	com2.getFecha().set(Calendar.DAY_OF_WEEK, promotemp1.getDiasDePromo().ordinal()+2);
		promotemp1.setHoraInicio(com2.getFecha().get(Calendar.HOUR_OF_DAY));
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
	public void Constructor()
	{
		Operario op = new Operario();
		FuncionalidadOperario fOaux = new FuncionalidadOperario(op);
		Assert.assertEquals("Operario registrado incorrectamente", op, fOaux.getOperario());
	}

	@Test
	public void ConstructorConOperarioNull()
	{
		FuncionalidadAdmin fOaux = new FuncionalidadAdmin();
		Assert.assertEquals("Operario registrado incorrectamente", null, fOaux.getOperario());
	}

	@Test
	public void testEstableceEstadosMozosActivo()
	{
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.ACTIVO, this.mozo.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente", Enumerados.estadoMozo.ACTIVO,
				this.mozo.getEstado());
	}

	@Test
	public void testEstableceEstadosMozosAusente()
	{
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.AUSENTE, this.mozo.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente", Enumerados.estadoMozo.AUSENTE,
				this.mozo.getEstado());
	}

	@Test
	public void testEstableceEstadosMozosDeFranco()
	{
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.DEFRANCO, this.mozo.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente", Enumerados.estadoMozo.DEFRANCO,
				this.mozo.getEstado());
	}

	@Test
	public void testEstableceEstadosMozosInexistente()
	{
		Mozo mozoInexistente = new Mozo("no existe", 6);
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.ACTIVO, mozoInexistente.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente", Enumerados.estadoMozo.ACTIVO,
				mozoInexistente.getEstado());
	}

	@Test
	public void testModificaOperario()
	{
		try
		{
			this.fO.modificaOperario("nuevo nombre", "nuevo username", "nueva password");
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", "nuevo nombre",
					this.fO.getOperario().getNyA());
			Assert.assertEquals("Nuevo username registrado incorrectamente", "nuevo username",
					this.fO.getOperario().getUserName());
			Assert.assertEquals("Nueva password registrada incorrectamente", "nueva password",
					this.fO.getOperario().getPassword());

		} catch (UserNameRepetido_Exception e)
		{
			Assert.fail("No deberia lanzar excepciones");
		} catch (ContrasenaIncorrecta_Exception e) // el contrato nunca menciona cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar excepciones");
		}
	}

	@Test
	public void testModificaOperarioUserNameRepetido()
	{
		try
		{
			this.fO.modificaOperario("nuevo nombre", "valus", "nueva password");
			Assert.fail("Deberia lanzarse UserNameRepetido_Exception");
		} catch (UserNameRepetido_Exception e)
		{

		} catch (ContrasenaIncorrecta_Exception e) // el contrato nunca menciona cuando se lanza esta excepcion
		{
			Assert.fail("Deberia lanzarse UserNameRepetido_Exception");
		}
	}

	@Test
	public void testModificaMozoExistente()
	{
		try
		{
			this.fO.modificaMozo(this.mozo, Enumerados.estadoMozo.AUSENTE, 19);
			Assert.assertEquals("Nuevo estado registrado incorrectamente", Enumerados.estadoMozo.AUSENTE,
					this.mozo.getEstado());
			Assert.assertEquals("Nueva cantHijos registrada incorrectamente", 19, this.mozo.getCantHijos());
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testModificaMozoInexistente()
	{
		try
		{
			Mozo mozoInexistente = new Mozo();
			this.fO.modificaMozo(mozoInexistente, Enumerados.estadoMozo.AUSENTE, 19);
			Assert.assertEquals("Nuevo estado registrado incorrectamente", Enumerados.estadoMozo.AUSENTE,
					mozoInexistente.getEstado());
			Assert.assertEquals("Nueva cantHijos registrada incorrectamente", 19, mozoInexistente.getCantHijos());
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}

	}

	@Test
	public void testModificaMozoNull()
	{
		try
		{
			this.fO.modificaMozo(null, Enumerados.estadoMozo.AUSENTE, 19);
			Assert.assertEquals("Nuevo estado registrado incorrectamente", Enumerados.estadoMozo.AUSENTE, null);
			Assert.assertEquals("Nueva cantHijos registrada incorrectamente", 19, null);
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}

	}

	@Test
	public void testModificaMozoCantHijosInvalida()
	{
		try
		{
			this.fO.modificaMozo(this.mozo, Enumerados.estadoMozo.AUSENTE, -3);
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		} catch (CantHijosInvalida_Exception e)
		{

		} catch (NyARepetido_Exception e)
		{
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		}
	}

	@Test
	public void testModificaMozoNyARepetido()
	{
		try
		{
			this.fO.modificaMozo(this.mozo, Enumerados.estadoMozo.AUSENTE, -3);
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		} catch (CantHijosInvalida_Exception e)
		{

		} catch (NyARepetido_Exception e)
		{
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		}
	}

	@Test
	public void testModificaProducto()
	{
		try
		{
			this.fO.modificaProducto(1, "ninios envolvidos", 1900, 2000, 3);
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", "ninios envolvidos",
					Sistema.getInstance().getProductos().get(1).getNombre());
			Assert.assertEquals("Nuevo precioCosto registrado incorrectamente", 1900,
					Sistema.getInstance().getProductos().get(1).getPrecioCosto(), 0);
			Assert.assertEquals("Nuevo precioVenta registrado incorrectamente", 2000,
					Sistema.getInstance().getProductos().get(1).getPrecioVenta(), 0);
			Assert.assertEquals("Nuevo stockInicial registrado incorrectamente", 3,
					Sistema.getInstance().getProductos().get(1).getStockInicial());

		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testModificaProductoNombreVacio()
	{
		try
		{
			this.fO.modificaProducto(1, "", 1900, 2000, 3);
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", "",
					Sistema.getInstance().getProductos().get(1).getNombre());
			Assert.assertEquals("Nuevo precioCosto registrado incorrectamente", 1900,
					Sistema.getInstance().getProductos().get(1).getPrecioCosto(), 0);
			Assert.assertEquals("Nuevo precioVenta registrado incorrectamente", 2000,
					Sistema.getInstance().getProductos().get(1).getPrecioVenta(), 0);
			Assert.assertEquals("Nuevo stockInicial registrado incorrectamente", 3,
					Sistema.getInstance().getProductos().get(1).getStockInicial());

		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testModificaProductoNombreNull()
	{
		try
		{
			this.fO.modificaProducto(1, null, 1900, 2000, 3);
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", null,
					Sistema.getInstance().getProductos().get(1).getNombre());
			Assert.assertEquals("Nuevo precioCosto registrado incorrectamente", 1900,
					Sistema.getInstance().getProductos().get(1).getPrecioCosto(), 0);
			Assert.assertEquals("Nuevo precioVenta registrado incorrectamente", 2000,
					Sistema.getInstance().getProductos().get(1).getPrecioVenta(), 0);
			Assert.assertEquals("Nuevo stockInicial registrado incorrectamente", 3,
					Sistema.getInstance().getProductos().get(1).getStockInicial());

		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testModificaProductoIdInexistente()
	{
		try
		{
			this.fO.modificaProducto(765, "ninios envolvidos", 2000, 1900, 3);
			Assert.fail("NoExisteID_Exception deberia lanzarse");
		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("NoExisteID_Exception deberia lanzarse");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("NoExisteID_Exception deberia lanzarse");
		} catch (NoExisteID_Exception e)
		{

		}
	}

	@Test
	public void testModificaProductoPrecioCostoMayorAPrecioVenta()
	{
		try
		{
			this.fO.modificaProducto(1, "ninios envolvidos", 2000, 1900, 3);
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", "ninios envolvidos",
					Sistema.getInstance().getProductos().get(1).getNombre());
			Assert.assertEquals("Nuevo precioCosto registrado incorrectamente", 2000,
					Sistema.getInstance().getProductos().get(1).getPrecioCosto(), 0);
			Assert.assertEquals("Nuevo precioVenta registrado incorrectamente", 1900,
					Sistema.getInstance().getProductos().get(1).getPrecioVenta(), 0);
			Assert.assertEquals("Nuevo stockInicial registrado incorrectamente", 3,
					Sistema.getInstance().getProductos().get(1).getStockInicial());

		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testModificaProductoPrecioCostoNegativo()
	{
		try
		{
			this.fO.modificaProducto(1, "ninios envolvidos", -1900, 2000, 3);
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", "ninios envolvidos",
					Sistema.getInstance().getProductos().get(1).getNombre());
			Assert.assertEquals("Nuevo precioCosto registrado incorrectamente", -1900,
					Sistema.getInstance().getProductos().get(1).getPrecioCosto(), 0);
			Assert.assertEquals("Nuevo precioVenta registrado incorrectamente", 2000,
					Sistema.getInstance().getProductos().get(1).getPrecioVenta(), 0);
			Assert.assertEquals("Nuevo stockInicial registrado incorrectamente", 3,
					Sistema.getInstance().getProductos().get(1).getStockInicial());

		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testModificaProductoPrecioVentaNegativo()
	{
		try
		{
			this.fO.modificaProducto(1, "ninios envolvidos", 1900, -2000, 3);
			Assert.assertEquals("Nuevo nombre registrado incorrectamente", "ninios envolvidos",
					Sistema.getInstance().getProductos().get(1).getNombre());
			Assert.assertEquals("Nuevo precioCosto registrado incorrectamente", 1900,
					Sistema.getInstance().getProductos().get(1).getPrecioCosto(), 0);
			Assert.assertEquals("Nuevo precioVenta registrado incorrectamente", -2000,
					Sistema.getInstance().getProductos().get(1).getPrecioVenta(), 0);
			Assert.assertEquals("Nuevo stockInicial registrado incorrectamente", 3,
					Sistema.getInstance().getProductos().get(1).getStockInicial());

		} catch (precioInvalido_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (prodEnUso_Exception e) // el contrato no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testModificaMesa()
	{
		try
		{
			this.fO.modificaMesa(0, 8, Enumerados.estadoMesa.OCUPADA);
			Assert.assertEquals("Nueva cantPax registrada incorrectamente", 8,
					Sistema.getInstance().getMesas().get(0).getCantPax());
			Assert.assertEquals("Nuevo estado registrado incorrectamente", Enumerados.estadoMesa.OCUPADA,
					Sistema.getInstance().getMesas().get(1).getEstado());

		} catch (CantComensalesInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}

	}

	@Test
	public void testModificaMesaCantPaxMenorA2()
	{
		try
		{
			this.fO.modificaMesa(0, 1, Enumerados.estadoMesa.LIBRE);
			Assert.fail("Deberia lanzarse CantComensalesInvalida_Exception");
		} catch (CantComensalesInvalida_Exception e)
		{

		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("Deberia lanzarse CantComensalesInvalida_Exception");
		}

	}

	@Test
	public void testModificaMesaInexistente()
	{
		try
		{
			this.fO.modificaMesa(17, 3, Enumerados.estadoMesa.LIBRE);
			Assert.fail("Deberia lanzarse NoExisteMesa_Exception");
		} catch (CantComensalesInvalida_Exception e)
		{
			Assert.fail("Deberia lanzarse NoExisteMesa_Exception");
		} catch (NoExisteMesa_Exception e)
		{

		}

	}

	@Test
	public void testAgregaPromocionProdLUNES()
	{
		int cant = Sistema.getInstance().getPromocionProds().size();
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.LUNES, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.LUNES,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testAgregaPromocionProdProdInexistente()
	{
		try
		{
			this.fO.agregaPromocionProd(99999, Enumerados.diasDePromo.LUNES, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", null,
					Sistema.getInstance().getPromocionProds().get(2).getProducto());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.LUNES,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdMARTES()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.MARTES, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MARTES,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdMIERCOLES()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.MIERCOLES, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdJUEVES()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.JUEVES, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.JUEVES,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdVIERNES()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.VIERNES, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.VIERNES,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdSABADO()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.SABADO, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.SABADO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdDOMINGO()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.DOMINGO, true, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdAplica2x1False()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.DOMINGO, false, true, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", false,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdAplicaDtoPorCantidadFalse()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.DOMINGO, true, false, 3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", false,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdDtoPorCantidad_CantMinimaNegativa()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.DOMINGO, true, true, -3, 0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", -3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionDtoPorCantidad_PrecioUnitarioNegativo()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.DOMINGO, true, true, 3, -0.5, true);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", -0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPromocionProdActivaFalse()
	{
		try
		{
			this.fO.agregaPromocionProd(0, Enumerados.diasDePromo.DOMINGO, true, true, 3, 0.5, false);
			Assert.assertEquals("Producto registrado incorrectamente", 0,
					Sistema.getInstance().getPromocionProds().get(2).getProducto().getIdProd());
			Assert.assertEquals("DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(2).getDiasDePromo());
			Assert.assertEquals("Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplica2x1());
			Assert.assertEquals("AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(2).isAplicaDtoPorCant());
			Assert.assertEquals("DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_CantMinima());
			Assert.assertEquals("DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.5,
					Sistema.getInstance().getPromocionProds().get(2).getDtoPorCant_PrecioUnitario(), 0);
			Assert.assertEquals("Activa registrado incorrectamente", false,
					Sistema.getInstance().getPromocionProds().get(2).isActiva());

		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no indica cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdLUNES()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.LUNES, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.LUNES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdMARTES()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MARTES, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MARTES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdMIERCOLES()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MIERCOLES, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdJUEVES()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.JUEVES, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.JUEVES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdVIERNES()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.VIERNES, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.VIERNES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdSABADO()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.SABADO, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.SABADO,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdDOMINGO()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.DOMINGO, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdPromoInexistente()
	{
		try
		{
			this.fO.modificaPromocionProd(17, true, Enumerados.diasDePromo.DOMINGO, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdActivaFalse()
	{
		try
		{
			this.fO.modificaPromocionProd(0, false, Enumerados.diasDePromo.MIERCOLES, true, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", false,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdAplica2x1False()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MIERCOLES, false, true, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", false,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdAplicaDtoPorCantidadFalse()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MIERCOLES, true, false, 3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", false,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdDtoPorCantidad_CantMinimaNegativa()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MIERCOLES, true, true, -3, 0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", -3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", 0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testModificaPromocionProdDtoPorCantidad_PrecioUnitarioNegativo()
	{
		try
		{
			this.fO.modificaPromocionProd(0, true, Enumerados.diasDePromo.MIERCOLES, true, true, 3, -0.2);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isActiva());
			Assert.assertEquals("Nuevo DiaDePeromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionProds().get(0).getDiasDePromo());
			Assert.assertEquals("Nuevo Aplica2x1 registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplica2x1());
			Assert.assertEquals("Nuevo AplicaDtoPorCant registrado incorrectamente", true,
					Sistema.getInstance().getPromocionProds().get(0).isAplicaDtoPorCant());
			Assert.assertEquals("Nueva DtoPorCantidad_CantMinima registrada incorrectamente", 3,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_CantMinima());
			Assert.assertEquals("Nuevo DtoPorCantidad_PrecioUnitario registrada incorrectamente", -0.2,
					Sistema.getInstance().getPromocionProds().get(0).getDtoPorCant_PrecioUnitario(), 0);
		} catch (PromoInvalida_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		} catch (NoExisteID_Exception e) // la documentacion no menciona esta excepcion
		{
			Assert.fail("No deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testEliminaPromocionProd()
	{
		int cant = Sistema.getInstance().getPromocionProds().size();
		try
		{
			this.fO.eliminaPromocionProd(0);
			Assert.assertEquals("PromocionProd eliminada incorrectamente", cant - 1,
					Sistema.getInstance().getPromocionProds().size());
		} catch (PromoInvalida_Exception e) // la documentacion no menciona a esta excepcion
		{
			Assert.fail("Ninguna excepción deberia lanzarse");
		}
	}

	@Test
	public void testEliminaPromocionProdInexistente()
	{
		int cant = Sistema.getInstance().getPromocionProds().size();
		try
		{
			this.fO.eliminaPromocionProd(678);
			Assert.assertEquals("PromocionProd eliminada incorrectamente", cant - 1,
					Sistema.getInstance().getPromocionProds().size());
		} catch (PromoInvalida_Exception e) // la documentacion no menciona a esta excepcion
		{
			Assert.fail("Ninguna excepción deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalLUNES()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.LUNES, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.LUNES,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalMARTES()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.MARTES, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.MARTES,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalMIERCOLES()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.MIERCOLES, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalJUEVES()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.JUEVES, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.JUEVES,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalVIERNES()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.VIERNES, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.VIERNES,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalSABADO()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.SABADO, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.SABADO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalDOMINGO()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalActivaFalse()
	{
		try
		{
			this.fO.agregaPromocionTemporal(false, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.CTADNI, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", false,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalNombreVacio()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "", Enumerados.formaDePago.CTADNI, 5,
					true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalNombreNull()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, null, Enumerados.formaDePago.CTADNI,
					5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", null,
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalEFECTIVO()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.EFECTIVO, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.EFECTIVO,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalMERCPAGO()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.MERCPAGO, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.MERCPAGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalTARJETA()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.TARJETA, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalPorcentajeDescNegativo()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.TARJETA, -5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", -5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalEsAcumulableFalse()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.TARJETA, 5, false, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", false,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalHoraInicioNegativa()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.TARJETA, 5, true, -1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", -1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalHoraFinalNegativa()
	{
		try
		{
			this.fO.agregaPromocionTemporal(true, Enumerados.diasDePromo.DOMINGO, "este tp no se termina mas",
					Enumerados.formaDePago.TARJETA, 5, true, 1, -3);
			Assert.assertEquals("Activa registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					Sistema.getInstance().getPromocionesTemp().get(2).getDiasDePromo());
			Assert.assertEquals("Nombre registrado incorrectamente", "este tp no se termina mas",
					Sistema.getInstance().getPromocionesTemp().get(2).getNombre());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					Sistema.getInstance().getPromocionesTemp().get(2).getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5,
					Sistema.getInstance().getPromocionesTemp().get(2).getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true,
					Sistema.getInstance().getPromocionesTemp().get(2).isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", -3,
					Sistema.getInstance().getPromocionesTemp().get(2).getHoraFinal());
		} catch (PromoRepetida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testAgregaPromocionTemporalRepetida()
	{
		try
		{
			// agrego una promocionTemporal con los valores de una promocion ya existente en
			// el sistema
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.agregaPromocionTemporal(promT.isActiva(), promT.getDiasDePromo(), promT.getNombre(),
					promT.getFormaDePago(), promT.getPorcentajeDesc(), promT.isEsAcumulable(), promT.getHoraInicio(),
					promT.getHoraFinal());
			Assert.fail("Deberia lanzarse PromoRepetida_Exception");
		} catch (PromoRepetida_Exception e)
		{

		}
	}

	@Test
	public void testEliminaPromocionTemporalExistente()
	{
		int cant = Sistema.getInstance().getPromocionesTemp().size();
		PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
		try
		{
			this.fO.eliminaPromocionTemporal(promT.getNombre());
			Assert.assertEquals("PromocionTemporal eliminada incorrectamente", cant - 1,
					Sistema.getInstance().getPromocionesTemp().size());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("No se deberia lanzar ninguna excepcion");
		}
	}

	@Test
	public void testEliminaPromocionTemporalInexistente()
	{
		try
		{
			this.fO.eliminaPromocionTemporal("nombre inexistente");
			Assert.fail("Deberia lanzarse PromoInvalida_Exception");
		} catch (PromoInvalida_Exception e)
		{

		}
	}

	@Test
	public void testModificaPromocionTemporalLUNES()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.LUNES,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.LUNES,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalMARTES()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.MARTES,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.MARTES,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalMIERCOLES()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.MIERCOLES,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.MIERCOLES,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalJUEVES()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.JUEVES,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.JUEVES,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalVIERNES()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.VIERNES,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.VIERNES,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalSABADO()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.SABADO,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.SABADO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalDOMINGO()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.CTADNI, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalActivaFalse()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.CTADNI, false, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", false, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.CTADNI,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalEFECTIVO()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.EFECTIVO, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.EFECTIVO,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalMERCPAGO()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.MERCPAGO, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.MERCPAGO,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalTARJETA()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.TARJETA, true, 5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalPorcentajeDescNegativo()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.TARJETA, true, -5, true, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", -5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalEsAcumulableFalse()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.TARJETA, true, 5, false, 1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", false, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalHoraInicioNegativa()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.TARJETA, true, 5, true, -1, 3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", -1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", 3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalHoraFinalNegativa()
	{
		try
		{
			PromocionTemporal promT = Sistema.getInstance().getPromocionesTemp().get(0);
			this.fO.modificaPromocionTemporal(promT.getNombre(), Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.TARJETA, true, 5, true, 1, -3);
			Assert.assertEquals("Activa registrado incorrectamente", true, promT.isActiva());
			Assert.assertEquals("DiasDePromo registrado incorrectamente", Enumerados.diasDePromo.DOMINGO,
					promT.getDiasDePromo());
			Assert.assertEquals("FormaDePago registrado incorrectamente", Enumerados.formaDePago.TARJETA,
					promT.getFormaDePago());
			Assert.assertEquals("PorcentajeDesc registrado incorrectamente", 5, promT.getPorcentajeDesc());
			Assert.assertEquals("EsAcumulable registrado incorrectamente", true, promT.isEsAcumulable());
			Assert.assertEquals("HoraInicio registrado incorrectamente", 1, promT.getHoraInicio());
			Assert.assertEquals("HoraFinal registrado incorrectamente", -3, promT.getHoraFinal());
		} catch (PromoInvalida_Exception e)
		{
			Assert.fail("Ninguna excepcion deberia lanzarse");
		}
	}

	@Test
	public void testModificaPromocionTemporalInexistente()
	{
		try
		{
			this.fO.modificaPromocionTemporal("nombre inexistente", Enumerados.diasDePromo.DOMINGO,
					Enumerados.formaDePago.TARJETA, true, 50, true, 17, 31);
			Assert.fail("Deberia lanzarse PromoInvalida_Exception");
		} catch (PromoInvalida_Exception e)
		{

		}
	}

	@Test
	public void testSetMesaMozo()
	{
		try
		{
			Mesa mesa = Sistema.getInstance().getMesas().get(0);
			this.fO.setMesaMozo(mesa.getNroMesa(), this.mozo);
			Assert.assertEquals("Mozo asociado a mesa incorrectamente", this.mozo, mesa.getMozo());
		} catch (EstadoIncorrecto_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testSetMesaMozoNroMesaIncorrecto()
	{
		try
		{
			this.fO.setMesaMozo(875, this.mozo);
			Assert.fail("Deberia lanzarse NoExisteMesa_Exception");
		} catch (EstadoIncorrecto_Exception e)
		{
			Assert.fail("Deberia lanzarse NoExisteMesa_Exception");
		} catch (NoExisteMesa_Exception e)
		{

		}
	}

	@Test
	public void testSetMesaMozoMozoAusente()
	{
		try
		{
			this.mozo.setEstado(Enumerados.estadoMozo.AUSENTE);
			Mesa mesa = Sistema.getInstance().getMesas().get(0);
			this.fO.setMesaMozo(mesa.getNroMesa(), this.mozo);
			Assert.fail("Deberia lanzarse EstadoIncorrecto_Exception");
		} catch (EstadoIncorrecto_Exception e)
		{

		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("Deberia lanzarse EstadoIncorrecto_Exception");
		}
	}

	@Test
	public void testSetMesaMozoMozoDeFranco()
	{
		try
		{
			this.mozo.setEstado(Enumerados.estadoMozo.DEFRANCO);
			Mesa mesa = Sistema.getInstance().getMesas().get(0);
			this.fO.setMesaMozo(mesa.getNroMesa(), this.mozo);
			Assert.fail("Deberia lanzarse EstadoIncorrecto_Exception");
		} catch (EstadoIncorrecto_Exception e)
		{

		} catch (NoExisteMesa_Exception e) 
		{
			Assert.fail("Deberia lanzarse EstadoIncorrecto_Exception");
		}
	}

	@Test
	public void testCierraMesaOCUAPADA()
	{
		try
		{
			Mesa mesa = Sistema.getInstance().getMesas().get(1);
			this.fO.cierraMesa(mesa.getNroMesa(), Enumerados.formaDePago.CTADNI);
			Assert.fail("deberia lanzarse MesaNoOcupadaException");
		} catch (MesaNoOcupadaException e) //auqnque no tenga sentido, el contrato dice que se lanza cuando la mesa esta ocupada
		{

		}
	}

	@Test
	public void testCierraMesaLIBRE()
	{
		try
		{
			Mesa mesa = Sistema.getInstance().getMesas().get(0);
			this.fO.cierraMesa(mesa.getNroMesa(), Enumerados.formaDePago.CTADNI);

		} catch (MesaNoOcupadaException e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAbreComandaMesaLIBRE()
	{
		int cant = Sistema.getInstance().getComandas().size();
		Mesa mesa = Sistema.getInstance().getMesas().get(2);
		try
		{
			this.fO.abreComanda(mesa);
			Assert.assertEquals("Comanda abierta incorrectamente", cant + 1,
					Sistema.getInstance().getComandas().size());
		} catch (MesaOcupada_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (MozoInactivo_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAbreComandaMesaOCUPADA()
	{
		Mesa mesa = Sistema.getInstance().getMesas().get(3);
		try
		{
			this.fO.abreComanda(mesa);
			Assert.fail("Deberia lanzar MesaOcupada_Exception");
		} catch (MesaOcupada_Exception e)
		{

		} catch (MozoInactivo_Exception e)
		{
			Assert.fail("Deberia lanzar MesaOcupada_Exception");
		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("Deberia lanzar MesaOcupada_Exception");
		}
	}

	@Test
	public void testAbreComandaMesaNull()
	{
		try
		{
			this.fO.abreComanda(null);
			Assert.fail("Deberia lanzar NoExisteMesa_Exception");
		} catch (MesaOcupada_Exception e)
		{
			Assert.fail("Deberia lanzar NoExisteMesa_Exception");
		} catch (MozoInactivo_Exception e)
		{
			Assert.fail("Deberia lanzar NoExisteMesa_Exception");
		} catch (NoExisteMesa_Exception e)
		{

		}
	}

	@Test
	public void testAbreComandaMesaInexistente()
	{
		int cant = Sistema.getInstance().getComandas().size();
		Mesa mesa = new Mesa(5);
		try
		{
			this.fO.abreComanda(mesa);
			Assert.assertEquals("Comanda abierta incorrectamente", cant + 1,
					Sistema.getInstance().getComandas().size());
		} catch (MesaOcupada_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (MozoInactivo_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NoExisteMesa_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPedidos()
	{
		try
		{
			Producto prod = Sistema.getInstance().getProductos().get(0);
			int cant = prod.getStockInicial();
			this.fO.agregaPedidos(1, 1, prod.getIdProd());
			Assert.assertEquals("Pedido agregado incorrectamente", cant - 1, prod.getStockInicial());
		} catch (StockInsuficiente_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAgregaPedidosSuperaStock()
	{
		try
		{
			Producto prod = Sistema.getInstance().getProductos().get(0);
			this.fO.agregaPedidos(4, 99999, prod.getIdProd());
			Assert.fail("Deberia lanzarse StockInsuficiente_Exception");
		} catch (StockInsuficiente_Exception e)
		{

		} catch (NoExisteID_Exception e)
		{
			Assert.fail("Deberia lanzarse StockInsuficiente_Exception");
		}
	}

	@Test
	public void testAgregaPedidosIdInexistente()
	{
		try
		{
			this.fO.agregaPedidos(4, 1, 34234);
			Assert.fail("Deberia lanzarse NoExisteID_Exception");
		} catch (StockInsuficiente_Exception e)
		{
			Assert.fail("Deberia lanzarse NoExisteID_Exception");
		} catch (NoExisteID_Exception e)
		{

		}
	}

	@Test
	public void testAgregaPedidosNroMesaInexistente()
	{
		try
		{
			Producto prod = Sistema.getInstance().getProductos().get(0);
			int cant = prod.getStockInicial();
			this.fO.agregaPedidos(9999, 1, prod.getIdProd());
			Assert.assertEquals("Pedido agregado incorrectamente", cant - 1, prod.getStockInicial());
		} catch (StockInsuficiente_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excpecion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excpecion");
		}
	}

	@Test
	public void testAgregaPedidosCantNegativa()
	{
		try
		{
			Producto prod = Sistema.getInstance().getProductos().get(0);
			int cant = prod.getStockInicial();
			this.fO.agregaPedidos(1, -1, prod.getIdProd());
			Assert.assertEquals("Pedido agregado incorrectamente", cant + 1, prod.getStockInicial());
		} catch (StockInsuficiente_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NoExisteID_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testModificaPassword()
	{
		String password = "Aloworld1";
		this.fO.modificaPassword(password);
		Assert.assertEquals("Password modificada incorrectamente", password, fO.getOperario().getPassword());
	}

	@Test
	public void testVerificaPasswordValida()
	{
		Assert.assertEquals("Password verificada incorrectamente", true, this.fO.verificaPassword("Aloworld1"));
	}

	@Test
	public void testVerificaPasswordInvalida()
	{
		Assert.assertEquals("Password verificada incorrectamente", false,
				this.fO.verificaPassword("no quiero desaprobar por favor"));
	}

	@Test
	public void testVerificaPasswordNull()
	{
		Assert.assertEquals("Password verificada incorrectamente", false, this.fO.verificaPassword(null));
	}
}
