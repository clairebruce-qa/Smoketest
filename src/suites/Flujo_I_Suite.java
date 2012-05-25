package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.basicsFlows.CBT55_Test_CorrectLogon_ValidUser_TuCuenta;
import claireandbruce.com.test.basicsFlows.Test_Address_Exist;
import claireandbruce.com.test.basicsFlows.Test_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Test_CorrectAddProduct_Cart_SimpleProduct;

import claireandbruce.com.test.basicsFlows.Test_PayPal;
import claireandbruce.com.test.basicsFlows.Test_TypeShipping;
import claireandbruce.com.test.basicsFlows.Test_Without_Purchase;
import claireandbruce.com.test.flows.Test_Flujo_I;

/**
 * Flujo I login +  producto simple + con direccion + sin factura+ Pagado con Paypal
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	
	
	
	
	Test_Flujo_I.class
	
	
})

public class Flujo_I_Suite {
	


}
