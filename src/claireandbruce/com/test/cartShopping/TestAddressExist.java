package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la existencia dirección por defecto
 * @author NEWSHORE
 *
 */

public class TestAddressExist extends ClaireandbruceTestCase{
	
	@Test
	public void CBL1() throws Exception {
		Helper.log(" *** CBL1 *** Test * Verificar la existencia de una dirección por defecto ***");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibAddressExist.CBT_Address(selenium);
	}
}