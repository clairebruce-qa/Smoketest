package claireandbruce.com.test.flows;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;

public class SmokeTest_Flujo1_LoginAccount_WithoutPurchase_WithAddress extends ClaireandbruceTestCase {

	@Test
	public void flujo1_LoginAccount_WithoutPurchase_WithAddress(){
		Lib_CorrectLogon_ValidUser_Accout login = new Lib_CorrectLogon_ValidUser_Accout();
		Lib_CorrectAddProduct_Cart_SimpleProduct addSimpleProduct = new Lib_CorrectAddProduct_Cart_SimpleProduct();
	}
	
	
}
