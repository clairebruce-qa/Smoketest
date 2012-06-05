package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase_and_Other_Address;

import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente la compra con factura y dirección de factura diferente a la de envío
 * @author NEWSHORE
 *
 */
public class Test_WithPurchase_and_OtherAddress extends ClaireandbruceTestCase{
	
	@Test
	public void CBL10() throws Exception {
		Helper.log(" *** CBL10 *** Test * Factura con otra dirección ***");
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);		
		Lib_With_Purchase_and_Other_Address.with_Purchase_and_Other_Address(selenium);
	}
}