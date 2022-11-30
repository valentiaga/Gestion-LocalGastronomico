package test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.CantComensalesInvalida_Exception;
import excepciones.CantHijosInvalida_Exception;
import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.EdadInvalida_Exception;
import excepciones.MesaOcupada_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.NyARepetido_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Sueldo;
import negocio.FuncionalidadAdmin;
import negocio.Sistema;

public class TestFuncionalidadAdminSinDatos
{

	private FuncionalidadAdmin fA;

	@Before
	public void setUp() throws Exception
	{
		this.fA = new FuncionalidadAdmin();
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
		// De igual manera necesito hacer esto porque siguienteIdProd y SiguienteNroMesa
		// son static
		Producto.setSiguienteIdProd(0);
		Mesa.setSiguienteNroMesa(0);
	}

	@Test
	public void Constructor()
	{
		Operario op = new Operario();
		FuncionalidadAdmin fAaux = new FuncionalidadAdmin(op);
		Assert.assertEquals("Operario registrado incorrectamente", op, fAaux.getOperario());
	}

	@Test
	public void ConstructorConOperarioNull()
	{
		FuncionalidadAdmin fAaux = new FuncionalidadAdmin();
		Assert.assertEquals("Operario registrado incorrectamente", null, fAaux.getOperario());
	}

	@Test
	public void testAgregaMozoNuevoActivo()
	{
		int cant = Sistema.getInstance().getMozos().size();
		try
		{
			String nombre = "Aureliano Vega Imbalde";
			int cantHijos = 2;
			Enumerados.estadoMozo estado = Enumerados.estadoMozo.ACTIVO;
			GregorianCalendar fecha = new GregorianCalendar(2000, 11, 15);
			this.fA.agregaMozo(nombre,fecha,cantHijos,estado);
			Assert.assertEquals("Mozo registrado incorrectamente", cant + 1, Sistema.getInstance().getMozos().size());
			Mozo mozo = Sistema.getInstance().getMozos().get(nombre);
			Assert.assertEquals("NyA registrado incorrectamente",nombre,mozo.getNyA());
			Assert.assertEquals("CantHijos registrada incorrectamente",cantHijos,mozo.getCantHijos());
			Assert.assertEquals("Estado registrado incorrectamente",estado,mozo.getEstado());
		} catch (EdadInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAgregaMozoNuevoAusente()
	{
		int cant = Sistema.getInstance().getMozos().size();
		try
		{
			String nombre = "Aureliano Vega Imbalde";
			int cantHijos = 2;
			Enumerados.estadoMozo estado = Enumerados.estadoMozo.AUSENTE;
			GregorianCalendar fecha = new GregorianCalendar(2000, 11, 15);
			this.fA.agregaMozo(nombre,fecha,cantHijos,estado);
			Assert.assertEquals("Mozo registrado incorrectamente", cant + 1, Sistema.getInstance().getMozos().size());
			Mozo mozo = Sistema.getInstance().getMozos().get(nombre);
			Assert.assertEquals("NyA registrado incorrectamente",nombre,mozo.getNyA());
			Assert.assertEquals("CantHijos registrada incorrectamente",cantHijos,mozo.getCantHijos());
			Assert.assertEquals("Estado registrado incorrectamente",estado,mozo.getEstado());
		} catch (EdadInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAgregaMozoNuevoDeFranco()
	{
		int cant = Sistema.getInstance().getMozos().size();
		try
		{
			String nombre = "Aureliano Vega Imbalde";
			int cantHijos = 2;
			Enumerados.estadoMozo estado = Enumerados.estadoMozo.DEFRANCO;
			GregorianCalendar fecha = new GregorianCalendar(2000, 11, 15);
			this.fA.agregaMozo(nombre,fecha,cantHijos,estado);
			Assert.assertEquals("Mozo registrado incorrectamente", cant + 1, Sistema.getInstance().getMozos().size());
			Mozo mozo = Sistema.getInstance().getMozos().get(nombre);
			Assert.assertEquals("NyA registrado incorrectamente",nombre,mozo.getNyA());
			Assert.assertEquals("CantHijos registrada incorrectamente",cantHijos,mozo.getCantHijos());
			Assert.assertEquals("Estado registrado incorrectamente",estado,mozo.getEstado());
		} catch (EdadInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAgregaMozoNuevoEstadoNull()
	{
		int cant = Sistema.getInstance().getMozos().size();
		try
		{
			String nombre = "Aureliano Vega Imbalde";
			int cantHijos = 2;
			Enumerados.estadoMozo estado = null;
			GregorianCalendar fecha = new GregorianCalendar(2000, 11, 15);
			this.fA.agregaMozo(nombre,fecha,cantHijos,estado);
			Assert.assertEquals("Mozo registrado incorrectamente", cant + 1, Sistema.getInstance().getMozos().size());
			Mozo mozo = Sistema.getInstance().getMozos().get(nombre);
			Assert.assertEquals("NyA registrado incorrectamente",nombre,mozo.getNyA());
			Assert.assertEquals("CantHijos registrada incorrectamente",cantHijos,mozo.getCantHijos());
			Assert.assertEquals("Estado registrado incorrectamente",estado,mozo.getEstado());
		} catch (EdadInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}

		
	}

	@Test
	public void testAgregaMozoMenorDeEdad()
	{
		try
		{
			this.fA.agregaMozo("Jose", new GregorianCalendar(2010, 11, 15), 2, Enumerados.estadoMozo.ACTIVO);
			Assert.fail("Deberia lanzarse EdadInvalida_Exception");
		} catch (EdadInvalida_Exception e)
		{

		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("Deberia lanzarse EdadInvalida_Exception");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("Deberia lanzarse EdadInvalida_Exception");
		}
	}
	
	@Test
	public void testAgregaMozoFechaNull()
	{
		int cant = Sistema.getInstance().getMozos().size();
		try
		{
			String nombre = "Aureliano Vega Imbalde";
			int cantHijos = 2;
			Enumerados.estadoMozo estado = Enumerados.estadoMozo.ACTIVO;
			GregorianCalendar fecha = null;
			this.fA.agregaMozo(nombre,fecha,cantHijos,estado);
			Assert.assertEquals("Mozo registrado incorrectamente", cant + 1, Sistema.getInstance().getMozos().size());
			Mozo mozo = Sistema.getInstance().getMozos().get(nombre);
			Assert.assertEquals("NyA registrado incorrectamente",nombre,mozo.getNyA());
			Assert.assertEquals("CantHijos registrada incorrectamente",cantHijos,mozo.getCantHijos());
			Assert.assertEquals("Estado registrado incorrectamente",estado,mozo.getEstado());
		} catch (EdadInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (CantHijosInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (NyARepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testAgregaMozoCantHijosInvalida()
	{
		try
		{
			this.fA.agregaMozo("Maria", new GregorianCalendar(2000, 11, 15), -2, Enumerados.estadoMozo.ACTIVO);
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		} catch (EdadInvalida_Exception e)
		{
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		} catch (CantHijosInvalida_Exception e)
		{

		} catch (NyARepetido_Exception e)
		{
			Assert.fail("Deberia lanzarse CantHijosInvalida_Exception");
		}
	}

	@Test
	public void testEliminaMozoInexistente()
	{
		try
		{
			this.fA.eliminaMozo("Aure el mas lindo");
			Assert.fail("Deberia lanzarse NoExisteMozo_Exception");
		} catch (NoExisteMozo_Exception e)
		{

		}
	}

	@Test
	public void testModificaEstadoOperarioInexistente()
	{
		try
		{
			this.fA.modificaEstadoOperario("marinadiamandis", false);
			Assert.fail("NoExisteOperario_Exception deberia lanzarse");
		} catch (NoExisteOperario_Exception e)
		{

		}
	}

	@Test
	public void testRegistraOperarioNuevoACTIVO()
	{
		int cant = Sistema.getInstance().getOperariosRegistrados().size();
		try
		{
			this.fA.registraOperario("Carola", "caritenss.gl", "perfumew0rlddominati1on",
					Enumerados.estadoOperario.ACTIVO);
			Assert.assertEquals("Operario registrado incorrectamente", cant + 1,
					Sistema.getInstance().getOperariosRegistrados().size());
		} catch (UserNameRepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (ContrasenaIncorrecta_Exception e) // el contrato nunca menciona cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testRegistraOperarioNuevoINACTIVO()
	{
		int cant = Sistema.getInstance().getOperariosRegistrados().size();
		try
		{
			this.fA.registraOperario("Carola", "caritenss.gl", "perfumew0rlddominati1on",
					Enumerados.estadoOperario.INACTIVO);
			Assert.assertEquals("Operario registrado incorrectamente", cant + 1,
					Sistema.getInstance().getOperariosRegistrados().size());
		} catch (UserNameRepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (ContrasenaIncorrecta_Exception e) // el contrato nunca menciona cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testRegistraOperarioNuevoEstadoNull()
	{
		int cant = Sistema.getInstance().getOperariosRegistrados().size();
		try
		{
			this.fA.registraOperario("Carola", "caritenss.gl", "perfumew0rlddominati1on", null);
			Assert.assertEquals("Operario registrado incorrectamente", cant + 1,
					Sistema.getInstance().getOperariosRegistrados().size());
		} catch (UserNameRepetido_Exception e)
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		} catch (ContrasenaIncorrecta_Exception e) // el contrato nunca menciona cuando se lanza esta excepcion
		{
			Assert.fail("No deberia lanzarse ninguna excepcion");
		}
	}

	@Test
	public void testEliminaOperarioInexistente()
	{
		try
		{
			this.fA.eliminaOperario("ro_berto1990");
			Assert.fail("NoExisteOperario_Exception deberia lanzarse");
		} catch (NoExisteOperario_Exception e)
		{

		}
	}

	@Test
	public void testAgregaProducto()
	{
		int cant = Sistema.getInstance().getProductos().size();
		try
		{
			this.fA.agregaProducto("Fideos con dulce de leche", 150, 1200, 3);
			Assert.assertEquals("Producto registrado incorrectamente", cant + 1,
					Sistema.getInstance().getProductos().size());
		} catch (precioInvalido_Exception e)
		{
			Assert.fail("No deberia lanzarse excepcion");
		}
	}

	@Test
	public void testAgregaProductoPrecioCostoNegativo()
	{
		try
		{
			this.fA.agregaProducto("Torta de cheddar", -150, 1200, 3);
			Assert.fail("Deberia lanzarse precioInvalido_Exception");
		} catch (precioInvalido_Exception e)
		{

		}
	}

	@Test
	public void testAgregaProductoPrecioVentaNegativo()
	{
		try
		{
			this.fA.agregaProducto("Licuado de mortadela", 150, -1200, 3);
			Assert.fail("Deberia lanzarse precioInvalido_Exception");
		} catch (precioInvalido_Exception e)
		{

		}
	}

	@Test
	public void testAgregaProductoPrecioCostoMayorAPrecioVenta()
	{
		int cant = Sistema.getInstance().getProductos().size();
		try
		{
			this.fA.agregaProducto("Chorizo Cake", 4000, 20, 3);
			Assert.assertEquals("Producto registrado incorrectamente", cant + 1,
					Sistema.getInstance().getProductos().size());
		} catch (precioInvalido_Exception e)
		{
			Assert.fail("No deberia lanzarse excepcion");
		}
	}

	@Test
	public void testAgregaProductoStockInicialNegativo()
	{
		int cant = Sistema.getInstance().getProductos().size();
		try
		{
			this.fA.agregaProducto("Empanada de gusanos", 20, 47, -3);
			Assert.assertEquals("Producto registrado incorrectamente", cant + 1,
					Sistema.getInstance().getProductos().size());
		} catch (precioInvalido_Exception e)
		{
			Assert.fail("No deberia lanzarse excepcion");
		}
	}

	@Test
	public void testEliminaProductoInexistente()
	{
		try
		{
			this.fA.eliminaProducto(850);
			Assert.fail("NoExisteID_Exception deberia lanzarse");
		} catch (prodEnUso_Exception e)
		{
			Assert.fail("NoExisteID_Exception deberia lanzarse");
		} catch (NoExisteID_Exception e)
		{

		}
	}

	@Test
	public void testAgregaMesa()
	{
		int cant = Sistema.getInstance().getMesas().size();
		try
		{
			this.fA.agregaMesa(3);
			Assert.assertEquals("Mesa registrada incorrectamente", cant + 1, Sistema.getInstance().getMesas().size());
		} catch (CantComensalesInvalida_Exception e)
		{
			Assert.fail("No deberia lanzarse esta excepcion");
		}
	}

	@Test
	public void testAgregaMesaCantSillasMenorA0ANoBarra()
	{
		try
		{
			this.fA.agregaMesa(1); // mesa 0
			this.fA.agregaMesa(1); // mesa 1
			Assert.fail("CantComensalesInvalida_Exception deberia lanzarse");
		} catch (CantComensalesInvalida_Exception e)
		{

		}
	}

	@Test
	public void testEliminaMesaInexistente()
	{
		try
		{
			this.fA.eliminaMesa(18);
			Assert.fail("NoExisteMesa_Exception deberia lanzarse");
		} catch (MesaOcupada_Exception e)
		{
			Assert.fail("NoExisteMesa_Exception deberia lanzarse");
		} catch (NoExisteMesa_Exception e)
		{

		}
	}

	@Test
	public void testModificaRemuneracionBasica()
	{
		Sueldo sueldo = new Sueldo();
		this.fA.modificaRemuneracionBasica(43);
		Assert.assertEquals("Nueva remBasic registrada incorrectamente", 43, sueldo.getRemBasic(), 0);
	}

}