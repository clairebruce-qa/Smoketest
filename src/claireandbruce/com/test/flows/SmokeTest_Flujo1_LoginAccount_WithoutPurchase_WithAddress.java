package claireandbruce.com.test.flows;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_PayPal;

public class SmokeTest_Flujo1_LoginAccount_WithoutPurchase_WithAddress extends ClaireandbruceTestCase {

	@Test
	public void flujo1_LoginAccount_WithoutPurchase_WithAddress() throws Exception{
	
		
		Lib_PayPal.CBT_Paypal(selenium, nombreProducto);
	}
	
	
}
