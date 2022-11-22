package test;

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
import vista.Ventana;
import vista.VistaModificaProducto;

/**
 * Clase test que verifica si los botones de la ventana "Modifica Producto" se encuentran
 * habilitados o no a la hora de ingresar datos.
 *
 */

public class GuiTestEnabledDisanabled 
{
	private Robot robot;
	private ControladorVistaModificaProducto controlador;
	private VistaModificaProducto vista;
	private Ventana ventana;
    private FalsoOptionPane fo = new FalsoOptionPane();
	

	public GuiTestEnabledDisanabled()
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
		
		Producto producto = new Producto ("Pizza", 10, 20, 10);
		Cerveceria.getInstance().getProductos().put(0, producto);
	}

	@After
	public void tearDown() throws Exception 
	{
		controlador.getVentana().setVisible(false);
	}

	
	/*
	 * tengo que hacer todos los casos de test
	 * todos vacios
	 * todos llenos
	 * solo idProd
	 * sin idProd
	 * solo nombreProducto
	 * sin nombreProducto
	 * solo costoProducto
	 * sin costoProducto
	 * solo precioVenta
	 * sin precioVenta
	 * solo stock
	 * sin stock
	 */
	@Test
	public void testVacio() 
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
		
	}
	
	@Test
	public void testLleno ()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
			
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
		Assert.assertTrue("El boton de confirmar deberia estar hablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());		
	
	}
	
	@Test
	public void testSoloidProd()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
		
		//lleno los JTextField
		TestUtils.clickComponent(idProd, robot);
		TestUtils.borraJTextField(idProd, robot);
		TestUtils.tipeaTexto("0", robot);
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
				
	}
	
	
	@Test
	public void testSinidProd()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
			
		//lleno los JTextField
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
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
				
	}
	
	
	@Test
	public void testSoloNombre()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
		
		//lleno los JTextField
		TestUtils.clickComponent(nombre, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.tipeaTexto("Pizza", robot);
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
			
	}
	
	@Test
	public void testSinNombre()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
			
		//lleno los JTextField
		TestUtils.clickComponent(idProd, robot);
		TestUtils.borraJTextField(idProd, robot);
		TestUtils.tipeaTexto("0", robot);
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
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
		
	}
	
	@Test
	public void testSoloCostoProducto()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
		
		//lleno los JTextField
		TestUtils.clickComponent(precioCosto, robot);
		TestUtils.borraJTextField(precioCosto, robot);
		TestUtils.tipeaTexto("15.0", robot);
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
		
	}

	@Test
	public void testSinCostoProducto()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
			
		//lleno los JTextField
		TestUtils.clickComponent(idProd, robot);
		TestUtils.borraJTextField(idProd, robot);
		TestUtils.tipeaTexto("0", robot);
		TestUtils.clickComponent(nombre, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.tipeaTexto("Pizza", robot);
		TestUtils.clickComponent(precioVenta, robot);
		TestUtils.borraJTextField(precioVenta, robot);
		TestUtils.tipeaTexto("25.0", robot);
		TestUtils.clickComponent(stock, robot);
		TestUtils.borraJTextField(stock, robot);
		TestUtils.tipeaTexto("12", robot);
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
				
	}
	
	@Test
	public void testSoloPrecioVenta()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
		
		//lleno los JTextField
		TestUtils.clickComponent(precioVenta, robot);
		TestUtils.borraJTextField(precioVenta, robot);
		TestUtils.tipeaTexto("25.0", robot);
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
		
	}
	
	@Test
	public void testSinPrecioVenta()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
			
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
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
				
	}
	
	@Test
	public void testSoloStock()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField stock = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtStockProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
		
		//lleno los JTextField
		TestUtils.clickComponent(stock, robot);
		TestUtils.borraJTextField(stock, robot);
		TestUtils.tipeaTexto("12", robot);
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
	}
	
	@Test
	public void testSinStock()
	{
		robot.delay(TestUtils.getDelay());
		//obtengo las referencias a los componentes necesarios
		JTextField idProd = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtidProducto");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreProducto");
		JTextField precioCosto = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtCostoProducto");
		JTextField precioVenta = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtPrecioVentaProducto");
		JButton confirmar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonVolver");
			
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
		
		//verifico los resultados
		Assert.assertFalse("El boton de confirmar deberia estar deshablitado", confirmar.isEnabled());
		Assert.assertTrue("El boton de volver deberia estar hablitado", volver.isEnabled());
	}
}
