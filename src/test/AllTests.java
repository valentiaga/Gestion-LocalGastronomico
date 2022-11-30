package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ CajaBlancaFuncionalidadAdmin.class, CajaBlancaFuncionalidadOperario.class, CajaBlancaSistema.class,
		CajaNegraAdministrador.class, CajaNegraComanda.class, CajaNegraFuncionalidadAdminConDatos.class,
		CajaNegraFuncionalidadAdminSinDatos.class, CajaNegraFuncionalidadOperarioConDatos.class,
		CajaNegraFuncionalidadOperarioNingunMozoActivo.class, CajaNegraMesa.class, CajaNegraMesaAtendida.class,
		CajaNegraMozo.class, CajaNegraOperario.class, CajaNegraPedido.class, CajaNegraProducto.class,
		CajaNegraPromocion.class, CajaNegraPromocionProd.class, CajaNegraPromocionTemporal.class,
		CajaNegraSistema.class, CajaNegraSueldo.class, GuiTestConjuntoConDatos.class, GuiTestEnabledDisanabled.class,
		IntegracionEscenario1.class, IntegracionEscenario2.class, IntegracionEscenario3.class, TestPersistencia.class })
public class AllTests
{

}
