package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibWithoutPurchase;

/**
 * @Test correspondiente a la Librería que verifica la compra sin solicitud de factura.
 * @author NEWSHORE
 */
public class TestWithoutPurchase extends ClaireandbruceTestCase {	
		
	@Test
	public void CBL12() throws Exception {
		Helper.log(" *** CBL12 *** Test * Sin Solicitud de Factura ***");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		LibWithoutPurchase.CBT_WPurchase(selenium);
	}
}
