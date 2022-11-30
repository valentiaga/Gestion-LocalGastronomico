package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ CoberturaFuncionalidadAdmin.class, CoberturaFuncionalidadOperario.class, CoberturaSistema.class,
		GuiTestConjuntoConDatos.class, GuiTestEnabledDisanabled.class, IntegracionEscenario1.class,
		IntegracionEscenario2.class, IntegracionEscenario3.class, TestAdministrador.class, TestComanda.class,
		TestFuncionalidadAdminConDatos.class, TestFuncionalidadAdminSinDatos.class,
		TestFuncionalidadOperarioConDatos.class, TestFuncionalidadOperarioNingunMozoActivo.class, TestMesa.class,
		TestMesaAtendida.class, TestMozo.class, TestOperario.class, TestPedido.class, TestPersistencia.class,
		TestProducto.class, TestPromocion.class, TestPromocionProd.class, TestPromocionTemporal.class,
		TestSistema.class, TestSueldo.class })
public class AllTests
{

}
