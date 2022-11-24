package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ CoberturaFuncionalidadAdmin.class, CoberturaFuncionalidadOperario.class, CoberturaSistema.class,
		GuiTestConjuntoConDatos.class, GuiTestEnabledDisanabled.class, TestAdministrador.class, TestComanda.class,
		TestFuncionalidadAdminConDatos.class, TestFuncionalidadAdminSinDatos.class,
		TestFuncionalidadOperarioConDatos.class, TestFuncionalidadOperarioNingunMozoActivo.class, TestMesa.class,
		TestMesaAtendida.class, TestMozo.class, TestOperario.class, TestPedido.class, TestProducto.class,
		TestPromocion.class, TestPromocionProd.class, TestPromocionTemporal.class, TestSistema.class,
		TestSueldo.class })
public class AllTests
{

}
