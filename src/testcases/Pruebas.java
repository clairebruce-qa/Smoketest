package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.CBT55_Test_CorrectLogon_ValidUser_TuCuenta;
import claireandbruce.com.test.basicsFlows.Lib_Pay_Checking;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase_and_Other_Address;
import claireandbruce.com.test.basicsFlows.Test_Address_Exist;
import claireandbruce.com.test.basicsFlows.Test_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.login.checkout.CBT71_Test_CorrectLogon_ValidUser_Checkout;
import basics.ClaireandbruceTestCase;

public class Pruebas extends ClaireandbruceTestCase {
		
	@Test
	public void test_FooterMiddleNavigation_Tendencias() throws Exception{
		CBT55_Test_CorrectLogon_ValidUser_TuCuenta.CBT55(selenium);
		Test_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		Test_Address_Exist.CBT_Address(selenium);
		Lib_With_Purchase_and_Other_Address.with_Purchase_and_Other_Address(selenium);
		Lib_Pay_Checking.pay_checking(selenium);
		
	}
}