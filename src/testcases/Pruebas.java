package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_Pay_Checking;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase_and_Other_Address;
import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.login.checkout.CBT71_Test_CorrectLogon_ValidUser_Checkout;
import claireandbruce.com.test.navigationWeb.CBT100_Test_HeaderHomePageNavigation_Tendencias;
import basics.ClaireandbruceTestCase;

public class Pruebas extends ClaireandbruceTestCase {
		
	@Test
	public void test_FooterMiddleNavigation_Tendencias() throws Exception{
		CBT100_Test_HeaderHomePageNavigation_Tendencias.CBT100(selenium);
		
	}
}