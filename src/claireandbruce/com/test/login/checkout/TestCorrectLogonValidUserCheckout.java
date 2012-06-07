package claireandbruce.com.test.login.checkout;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonCheckout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la librería que verifica el login por checkout
 * @author NEWSHORE
 * CBT71
 */
public class TestCorrectLogonValidUserCheckout extends ClaireandbruceTestCase{

	@Test
	public void CBL5() throws Exception {
		Helper.log("*** CBL5 *** Test Login por checkout ***");
		selenium.open("");
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		LibCorrectLogonCheckout.login_Checkout(selenium);
	}
}