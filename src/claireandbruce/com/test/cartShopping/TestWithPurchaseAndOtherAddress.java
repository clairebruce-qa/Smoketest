package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibWithPurchaseAndOtherAddress;

import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente la compra con factura y dirección de factura diferente a la de envío
 * @author NEWSHORE
 *
 */
public class TestWithPurchaseAndOtherAddress extends ClaireandbruceTestCase{
	
	@Test
	public void CBL10() throws Exception {
		Helper.log(" *** CBL10 *** Test * Factura con otra dirección ***");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);		
		LibWithPurchaseAndOtherAddress.with_Purchase_and_Other_Address(selenium);
	}
}
