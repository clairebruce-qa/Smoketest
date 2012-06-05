package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_Without_Purchase;

/**
 * @Test correspondiente a la Librería que verifica la compra sin solicitud de factura.
 * @author NEWSHORE
 */
public class Test_Without_Purchase extends ClaireandbruceTestCase {	
		
	@Test
	public void CBL12() throws Exception {
		Helper.log(" *** CBL12 *** Test * Sin Solicitud de Factura ***");
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		Lib_Without_Purchase.CBT_WPurchase(selenium);
	}
}
