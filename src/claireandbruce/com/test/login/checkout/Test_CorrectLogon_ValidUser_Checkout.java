package claireandbruce.com.test.login.checkout;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_Checkout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la librería que verifica el login por checkout
 * @author NEWSHORE
 * CBT71
 */
public class Test_CorrectLogon_ValidUser_Checkout extends ClaireandbruceTestCase{

	@Test
	public void CBL5() throws Exception {
		Helper.log("*** CBL5 *** Test Login por checkout ***");
		selenium.open("");
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		Lib_CorrectLogon_Checkout.login_Checkout(selenium);
	}
}