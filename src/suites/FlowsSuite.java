package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import claireandbruce.com.test.flows.TestFlowI;
import claireandbruce.com.test.flows.TestFlowII;
import claireandbruce.com.test.flows.TestFlowIII;
import claireandbruce.com.test.flows.TestFlowIV;

/**
 * FlujoI: ProductoSimple + Direcci�nExistente + SinFactura + PagoPayPal
 * FlujoII: Login + ProductoSimple + CambioUnidad de un Producto + TipoEnv�o + Direcci�nExistente + Factura + PagoTarjetaCr�dito
 * FlujoIII: ProductoSimple + CambioUnidades + TipoEnv�o + LoginCheckout + Direcci�nExistente + Factura + Direcci�nFactura != Direcci�nEnv�o + PagoCheque
 * FlujoIV: ProductoConfigurable + CambioUnidades + TipoEnv�o + LoginCheckout + Direcci�nExistente + SinFactura + PagoCheque
 * @author NEWSHORE
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestFlowI.class,
	
	TestFlowII.class,
	
	TestFlowIII.class,
	
	TestFlowIV.class
	
	
})

public class FlowsSuite {
	
}
