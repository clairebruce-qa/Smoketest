package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;

/**
 * @Test correspondiente a la Librer�a que verifica la selecci�n de tipo de env�o
 * @author NEWSHORE
 *
 */
public class TestTypeShipping extends ClaireandbruceTestCase{
	
	@Test
	public void CBL8() throws Exception {
		Helper.log(" *** CBL8 *** Test * Selecci�n del Tipo de Env�o ***");
		selenium.open("");
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibTypeShipping.typeShipping(selenium);		
	}
}
