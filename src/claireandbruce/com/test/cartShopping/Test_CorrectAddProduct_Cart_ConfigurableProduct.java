package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;

/**
 * @Test correspondiente a la Librería que añade un producto configurable al carrito de compras
 * @author NEWSHORE
 *
 */
public class Test_CorrectAddProduct_Cart_ConfigurableProduct extends ClaireandbruceTestCase{
	
	@Test
	public void CBL3() throws Exception {
		Helper.log(" *** CBL3 *** Test * Añadir un producto configurable al carrito de comrpas ***");
		selenium.open("");
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
	}
}
