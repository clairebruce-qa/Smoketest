

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import claireandbruce.com.test.flows.TestFlowI;
import claireandbruce.com.test.flows.TestFlowII;
import claireandbruce.com.test.flows.TestFlowIII;
import claireandbruce.com.test.flows.TestFlowIV;

/**
 * FlujoI: Login + ProductoSimple + DirecciónExistente + SinFactura + PagoPayPal
 * FlujoII: Login + ProductoSimple + CambioUnidad de un Producto + TipoEnvío + DirecciónExistente + Factura + PagoTarjetaCrédito
 * FlujoIII: ProductoSimple + EliminarProducto + ProductoSimple + TipoEnvío + LoginCheckout + \nDirecciónExistente + Factura + DirecciónFactura != DirecciónEnvío + PagoTarjetaCrédito
 * FlujoIV: ProductoConfigurable + CambioUnidades + TipoEnvío + LoginCheckout + DirecciónExistente + SinFactura + PagoPayPal
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
