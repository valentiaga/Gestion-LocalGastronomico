package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.ControladorVistaModificaProducto;
import modelo.Cerveceria;
import modelo.Producto;
import util.Mensajes;
import vista.Ventana;
import vista.VistaModificaProducto;

public class GuiTestConjuntoConDatos 
{
	private Robot robot;
	private ControladorVistaModificaProducto controlador;
	private VistaModificaProducto vista;
	private Ventana ventana;
    private FalsoOptionPane fo = new FalsoOptionPane();
	
    
	
	
	public GuiTestConjuntoConDatos() 
	{
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
	}

	@Before
	public void setUp() throws Exception 
	{
		vista = new VistaModificaProducto();
		ventana = new Ventana(vista);
		controlador = new ControladorVistaModificaProducto(vista, ventana);
		controlador.setOptionPane(fo);
		
		Producto producto = new Producto("Pizza", 10, 20, 10);
		Cerveceria.getInstance().getProductos().put(1, producto);
	}

	@After
	public void tearDown() throws Exception 
	{
		controlador.getVentana().setVisible(false);
	}

	
	/*
	 * Casos a considerar:
	 * modifica ok
	 * precio costo negativo
	 * precio venta negativo
	 * 
	 * no se pueden consiedar más casos ya que no se lanzan algunas excepciones
	 */
	@Test
	public void testModificaOK() 
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
			
		//lleno los JTextField
		TestUtils.clickComponent(idProd, robot);
		TestUtils.borraJTextField(idProd, robot);
		TestUtils.tipeaTexto("0", robot);
		TestUtils.clickComponent(nombre, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.tipeaTexto("Pizza", robot);
		TestUtils.clickComponent(precioCosto, robot);
		TestUtils.borraJTextField(precioCosto, robot);
		TestUtils.tipeaTexto("15.0", robot);
		TestUtils.clickComponent(precioVenta, robot);
		TestUtils.borraJTextField(precioVenta, robot);
		TestUtils.tipeaTexto("25.0", robot);
		TestUtils.clickComponent(stock, robot);
		TestUtils.borraJTextField(stock, robot);
		TestUtils.tipeaTexto("12", robot);
		
		//verifico los resultados
		Assert.assertEquals("Mensaje incorrecto, debería decir"+Mensajes.ACTUALIZA_DATOS.getValor(),Mensajes.ACTUALIZA_DATOS.getValor(),fo.getMensaje());
	
	}

	@Test
	public void testPrecioCostoNegativo()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
			
		//lleno los JTextField
		TestUtils.clickComponent(idProd, robot);
		TestUtils.borraJTextField(idProd, robot);
		TestUtils.tipeaTexto("0", robot);
		TestUtils.clickComponent(nombre, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.tipeaTexto("Pizza", robot);
		TestUtils.clickComponent(precioCosto, robot);
		TestUtils.borraJTextField(precioCosto, robot);
		TestUtils.tipeaTexto("-15.0", robot);
		TestUtils.clickComponent(precioVenta, robot);
		TestUtils.borraJTextField(precioVenta, robot);
		TestUtils.tipeaTexto("25.0", robot);
		TestUtils.clickComponent(stock, robot);
		TestUtils.borraJTextField(stock, robot);
		TestUtils.tipeaTexto("12", robot);
		
		//verifico los resultados
		Assert.assertEquals("Mensaje incorrecto, debería decir"+Mensajes.PRECIO_INVALIDO.getValor(),Mensajes.PRECIO_INVALIDO.getValor(),fo.getMensaje());
		
	}
	
	@Test
	public void TestPrecioVentaNegativo()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
			
		//lleno los JTextField
		TestUtils.clickComponent(idProd, robot);
		TestUtils.borraJTextField(idProd, robot);
		TestUtils.tipeaTexto("0", robot);
		TestUtils.clickComponent(nombre, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.tipeaTexto("Pizza", robot);
		TestUtils.clickComponent(precioCosto, robot);
		TestUtils.borraJTextField(precioCosto, robot);
		TestUtils.tipeaTexto("15.0", robot);
		TestUtils.clickComponent(precioVenta, robot);
		TestUtils.borraJTextField(precioVenta, robot);
		TestUtils.tipeaTexto("-25.0", robot);
		TestUtils.clickComponent(stock, robot);
		TestUtils.borraJTextField(stock, robot);
		TestUtils.tipeaTexto("12", robot);
		
		//verifico los resultados
		Assert.assertEquals("Mensaje incorrecto, debería decir"+Mensajes.PRECIO_INVALIDO.getValor(),Mensajes.PRECIO_INVALIDO.getValor(),fo.getMensaje());
				
	}
}
