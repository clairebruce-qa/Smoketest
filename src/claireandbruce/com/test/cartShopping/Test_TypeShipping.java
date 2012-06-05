package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_TypeShipping;

/**
 * @Test correspondiente a la Librería que verifica la selección de tipo de envío
 * @author NEWSHORE
 *
 */
public class Test_TypeShipping extends ClaireandbruceTestCase{
	
	@Test
	public void CBL8() throws Exception {
		Helper.log(" *** CBL8 *** Test * Selección del Tipo de Envío ***");
		selenium.open("");
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		Lib_TypeShipping.typeShipping(selenium);		
	}
}