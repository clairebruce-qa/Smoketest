

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import claireandbruce.com.test.flows.TestFlowIII;

/**
 * FlujoIII: ProductoSimple + CambioUnidades + TipoEnv�o + LoginCheckout + Direcci�nExistente + Factura + Direcci�nFactura != Direcci�nEnv�o + PagoCheque
 * @author NEWSHORE
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestFlowIII.class
	
	
})

public class FlowIIISuite {
	
}
