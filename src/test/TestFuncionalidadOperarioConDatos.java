package test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
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
		Sistema.getInstance().getMozos().put("Mario", new Mozo("Mario", 2));
		Sistema.getInstance().getMozos().put("Salome", new Mozo("Salome", 1));
		Sistema.getInstance().getMozos().put("Quimey", new Mozo("Quimey", 7));
		Sistema.getInstance().getOperariosRegistrados().put(this.fO.getOperario().getUserName(), this.fO.getOperario());
		Sistema.getInstance().getOperariosRegistrados().put("valus",
				new Operario("Valentina", "valus", "marioneta", false));
		Sistema.getInstance().getOperariosRegistrados().put("aquamarina",
				new Operario("Marina", "aquamarina", "carrrnada12", true));

		Producto prod1 = new Producto("Rata ahumada", 2, 230, 1);
		Producto prod2 = new Producto("Milanesa de cemento", 189, 430, 3);
		Sistema.getInstance().getProductos().put(prod1.getIdProd(), prod1);
		Sistema.getInstance().getProductos().put(prod2.getIdProd(), prod2);
		Comanda com = new Comanda();
		ArrayList<Pedido> peds = new ArrayList<Pedido>();
		Pedido ped = new Pedido(prod1, 2);
		peds.add(ped);
		com.setPedidos(peds);
		com.setEstado(Enumerados.estadoComanda.ABIERTO);
		Sistema.getInstance().getComandas().add(com);
		Mesa mesa1 = new Mesa(3);
		Mesa mesa2 = new Mesa(10);
		mesa1.setEstado(Enumerados.estadoMesa.LIBRE);
		mesa2.setEstado(Enumerados.estadoMesa.OCUPADA);
		Sistema.getInstance().getMesas().put(mesa1.getNroMesa(), mesa1);
		Sistema.getInstance().getMesas().put(mesa2.getNroMesa(), mesa2);
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
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.ACTIVO,this.mozo.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente",Enumerados.estadoMozo.ACTIVO,this.mozo.getEstado());
	}
	
	@Test
	public void testEstableceEstadosMozosAusente()
	{
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.AUSENTE,this.mozo.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente",Enumerados.estadoMozo.AUSENTE,this.mozo.getEstado());
	}
	
	@Test
	public void testEstableceEstadosMozosDeFranco()
	{
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.DEFRANCO,this.mozo.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente",Enumerados.estadoMozo.DEFRANCO,this.mozo.getEstado());
	}
	
	@Test
	public void testEstableceEstadosMozosInexistente()
	{
		Mozo mozoInexistente = new Mozo("no existe",6);
		this.fO.estableceEstadosMozos(Enumerados.estadoMozo.ACTIVO,mozoInexistente.getNyA());
		Assert.assertEquals("Nuevo estado establecido incorrectamente",Enumerados.estadoMozo.ACTIVO,mozoInexistente.getEstado());
	}

}
