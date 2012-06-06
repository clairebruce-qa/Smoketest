package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;

/**
 * @Test correspondiente a la Librería que verifica la selección de tipo de envío
 * @author NEWSHORE
 *
 */
public class TestTypeShipping extends ClaireandbruceTestCase{
	
	@Test
	public void CBL8() throws Exception {
		Helper.log(" *** CBL8 *** Test * Selección del Tipo de Envío ***");
		selenium.open("");
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibTypeShipping.typeShipping(selenium);		
	}
}
