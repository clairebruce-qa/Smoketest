package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibWithPurchase;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la solicitud de una factura.
 * @author NEWSHORE
 *
 */
public class TestWithPurchase extends ClaireandbruceTestCase{
	
	@Test
	public void CBL11() throws Exception {
		Helper.log("*** CBL11 * Test * Solicitud de Factura ***");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		LibWithPurchase.shippingWithPurchase(selenium);
	}
}
