

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import claireandbruce.com.test.flows.TestFlowIII;

/**
 * FlujoIII: ProductoSimple + CambioUnidades + TipoEnvío + LoginCheckout + DirecciónExistente + Factura + DirecciónFactura != DirecciónEnvío + PagoCheque
 * @author NEWSHORE
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestFlowIII.class
	
	
})

public class FlowIIISuite {
	
}
