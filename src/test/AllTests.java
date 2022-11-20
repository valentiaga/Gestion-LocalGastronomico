package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ TestAdministrador.class, TestComanda.class, TestMesa.class, TestMesaAtendida.class, TestMozo.class,
		TestOperario.class, TestPedido.class, TestProducto.class, TestPromocion.class, TestPromocionProd.class,
		TestPromocionTemporal.class, testSueldo.class })
public class AllTests
{

}
