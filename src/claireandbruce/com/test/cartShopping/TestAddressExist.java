package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librer�a que verifica la existencia direcci�n por defecto
 * @author NEWSHORE
 *
 */

public class TestAddressExist extends ClaireandbruceTestCase{
	
	@Test
	public void CBL1() throws Exception {
		Helper.log(" *** CBL1 *** Test * Verificar la existencia de una direcci�n por defecto ***");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibAddressExist.CBT_Address(selenium);
	}
}