package claireandbruce.com.test.flujo1;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicosFlujos.Test_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.login.CBT55_Test_CorrectLogon_ValidUser_TuCuenta;

public class SmokeTest_Flujo1_LoginAccount_WithoutPurchase_WithAddress extends ClaireandbruceTestCase {

	@Test
	public void flujo1_LoginAccount_WithoutPurchase_WithAddress(){
		//CBT55_Test_CorrectLogon_ValidUser_TuCuenta login = new CBT55_Test_CorrectLogon_ValidUser_TuCuenta();
		Test_CorrectAddProduct_Cart_SimpleProduct addSimpleProduct = new Test_CorrectAddProduct_Cart_SimpleProduct();
	}
	
	
}
