package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;

/**
 * @Test correspondiente a la Librer�a que a�ade un producto simple al carrito de compras
 * @author NEWSHORE
 *
 */
public class TestCorrectAddProductCartSimpleProduct extends ClaireandbruceTestCase{
	
	@Test
	public void CBL4() throws Exception {
		Helper.log(" *** CBL4 *** Test * A�adir un producto simple al carrito de comrpas ***");
		selenium.open("");
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
	}
}
