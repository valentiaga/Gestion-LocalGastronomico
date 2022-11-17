package testGUI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.ControladorVistaModificaMozoOp;
import modelo.Mozo;
import negocio.Sistema;
import vista.Ventana;
import vista.VistaModificaMozoOp;

public class GuiTestEnDis {

	private ControladorVistaModificaMozoOp controlador;
	private Robot robot;
	private VistaModificaMozoOp vista;
	private Ventana v;
	private Mozo mozo;
	private FalsoOptionPane fo = new FalsoOptionPane();

	public GuiTestEnDis() {

		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp()  {
		vista = new VistaModificaMozoOp();
		v = new Ventana(vista);
		controlador = new ControladorVistaModificaMozoOp(vista, v);
		controlador.setOptionPane(fo);
		mozo = new Mozo("Valen", 0);
		Mozo mozo1 =  new Mozo("Penelope Luisa", 3);
		Mozo mozo2 = new Mozo("Pau", 2);
		Mozo mozo3 = new Mozo("Marti", 1);
		Sistema.getInstance().getMozos().put("Marti", mozo3);
		Sistema.getInstance().getMozos().put("Valen", mozo);
		Sistema.getInstance().getMozos().put("Pau", mozo2);
		Sistema.getInstance().getMozos().put("Penelope", mozo1);
	}

	@After
	public void tearDown() throws Exception {
		this.vista.setVisible(false);
		Sistema.getInstance().getMozos().clear();
	}

	public void seleccionaItemMozo(String nombreMozo) {
		
		JComboBox<String> comboMozos = (JComboBox<String>) TestUtils.getComponentForName(vista, "jComboBoxMozos");
		TestUtils.clickComponent(comboMozos, robot);
		TestUtils.tipeaTexto(nombreMozo, robot);
		robot.keyPress(KeyEvent.VK_ENTER);
		TestUtils.getDelay();
		robot.keyRelease(KeyEvent.VK_ENTER);
		comboMozos.setSelectedItem(nombreMozo);
        TestUtils.getDelay();
	}
	
	@Test
	public void testCantHijosNeg() throws Exception {
		JTextField hijos = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldCantHijos");
		JComboBox<String> comboMozos = (JComboBox<String>) TestUtils.getComponentForName(vista, "jComboBoxMozos");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldNyA");
		JButton confirmar = (JButton) TestUtils.getComponentForName(vista, "jBtnConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(vista, "jBtnVolver");
		JComboBox comboEstados = (JComboBox) TestUtils.getComponentForName(vista, "jComboBoxEstados");
		
		this.seleccionaItemMozo("Pau");
		TestUtils.clickComponent(hijos, robot);
		TestUtils.borraJTextField(hijos, robot);
		TestUtils.tipeaTexto("-1", robot);
		TestUtils.getDelay();
		//verifica los resultados
		Assert.assertFalse("El boton 'Confirmar' deberia estar habilitado", confirmar.isEnabled());
		Assert.assertTrue("El boton 'Volver' deberia estar habilitado", volver.isEnabled());
	}
	
	@Test
	public void testCantHijosPos() {
		JTextField hijos = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldCantHijos");
		JComboBox<String> comboMozos = (JComboBox<String>) TestUtils.getComponentForName(vista, "jComboBoxMozos");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldNyA");
		JButton confirmar = (JButton) TestUtils.getComponentForName(vista, "jBtnConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(vista, "jBtnVolver");
		JComboBox comboEstados = (JComboBox) TestUtils.getComponentForName(vista, "jComboBoxEstados");
		
		this.seleccionaItemMozo("Valen");
		TestUtils.clickComponent(hijos, robot);
		TestUtils.borraJTextField(hijos, robot);
		TestUtils.tipeaTexto("5", robot);
		TestUtils.getDelay();
		//verifica los resultados
		Assert.assertFalse("El boton 'Confirmar' deberia estar habilitado", confirmar.isEnabled());
		Assert.assertTrue("El boton 'Volver' deberia estar habilitado", volver.isEnabled());
		//continua
		TestUtils.getDelay();
		confirmar.doClick();
		Assert.assertEquals("No se modifico", Sistema.getInstance().getMozos().get("Valen").getCantHijos(), 5);
		Assert.assertEquals("El mensaje debería ser: 'Datos actualizados' y es "+this.fo.getMensaje() , this.fo.getMensaje(), "Datos actualizados");

	}
	

	/*@Test
	public void testMuestraDatosCorrectos() {
		JTextField hijos = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldCantHijos");
		JComboBox comboMozos = (JComboBox) TestUtils.getComponentForName(vista, "jComboBoxMozos");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldNyA");
		JButton confirmar = (JButton) TestUtils.getComponentForName(vista, "jBtnConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(vista, "jBtnVolver");
		JComboBox comboEstados = (JComboBox) TestUtils.getComponentForName(vista, "jComboBoxEstados");
		//Sistema.getInstance().getMozos().put("Valen", mozo);
		TestUtils.getDelay();
		this.seleccionaItemMozo("Valen");
		//verifica los resultados
		TestUtils.getDelay();
		TestUtils.getDelay();
		TestUtils.getDelay();
        Mozo mozo = Sistema.getInstance().getMozos().get("Valen");
		int cantHijos = -1;
		try {
			cantHijos = Integer.parseInt(hijos.getText());
		} catch (NumberFormatException e2) {
		}
        Assert.assertTrue("La cantidad de hijos no corresponde con el mozo selecciondo", mozo.getCantHijos()== cantHijos);
		Assert.assertTrue("El nombre y apellido no corresponde con el mozo selecciondo", mozo.getNyA().equals(nombre.getText()));
		Assert.assertTrue("El estado no corresponde con el mozo selecciondo", mozo.getEstado().equals(comboEstados.getSelectedItem()));
	}
	
	@Test
	public void testMuestraDatosCorrectosMozoNoExiste() {
		JTextField hijos = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldCantHijos");
		JComboBox comboMozos = (JComboBox) TestUtils.getComponentForName(vista, "jComboBoxMozos");
		JTextField nombre = (JTextField) TestUtils.getComponentForName(vista, "jTextFieldNyA");
		JButton confirmar = (JButton) TestUtils.getComponentForName(vista, "jBtnConfirmar");
		JButton volver = (JButton) TestUtils.getComponentForName(vista, "jBtnVolver");
		JComboBox comboEstados = (JComboBox) TestUtils.getComponentForName(vista, "jComboBoxEstados");
		
		TestUtils.getDelay();
		this.seleccionaItemMozo("Aureliano");
		//verifica los resultados
		TestUtils.getDelay();
        Assert.assertTrue("El campo hijos deberia estar vacio", hijos.getText()=="");
        Assert.assertTrue("El campo nombre deberia estar vacio", nombre.getText()=="");
        Assert.assertTrue("El comboBox de estados deberia estar vacio", comboEstados.getSelectedItem()==null);
		Assert.assertFalse("El boton 'Confirmar' deberia estar inhabilitado", confirmar.isEnabled());
		Assert.assertTrue("El boton 'Volver' deberia estar habilitado", volver.isEnabled());
	}*/

}
