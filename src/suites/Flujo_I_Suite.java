package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;

import claireandbruce.com.test.basicsFlows.Lib_PayPal;
import claireandbruce.com.test.basicsFlows.Lib_TypeShipping;
import claireandbruce.com.test.basicsFlows.Lib_Without_Purchase;
import claireandbruce.com.test.flows.Test_Flow_I;
import claireandbruce.com.test.flows.Test_Flow_II;
import claireandbruce.com.test.flows.Test_Flow_III;
import claireandbruce.com.test.flows.Test_Flow_IV;

/**
 * Flujo I login +  producto simple + con direccion + sin factura+ Pagado con Paypal
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	
	
	
	
	Test_Flow_I.class,
	
	Test_Flow_II.class,
	
	Test_Flow_III.class,
	
	Test_Flow_IV.class
	
	
})

public class Flujo_I_Suite {
	


}
