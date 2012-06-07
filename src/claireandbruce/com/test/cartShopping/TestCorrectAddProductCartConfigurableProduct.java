package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;

/**
 * @Test correspondiente a la Librer�a que a�ade un producto configurable al carrito de compras
 * @author NEWSHORE
 * CBL3 - CBT117
 */
public class TestCorrectAddProductCartConfigurableProduct extends ClaireandbruceTestCase{
	
	@Test
	public void CBL3() throws Exception {
		Helper.log(" *** CBL3 *** Test * A�adir un producto configurable al carrito de comrpas ***");
		selenium.open("");
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
	}
}
