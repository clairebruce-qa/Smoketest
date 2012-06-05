package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la solicitud de una factura.
 * @author NEWSHORE
 *
 */
public class Test_With_Purchase extends ClaireandbruceTestCase{
	
	@Test
	public void CBL11() throws Exception {
		Helper.log("*** CBL11 * Test * Solicitud de Factura ***");
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		Lib_With_Purchase.shippingWithPurchase(selenium);
	}
}
