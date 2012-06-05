package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;

/**
 * @Test correspondiente a la Librería que añade un producto simple al carrito de compras
 * @author NEWSHORE
 *
 */
public class Test_CorrectAddProduct_Cart_SimpleProduct extends ClaireandbruceTestCase{
	
	@Test
	public void CBL4() throws Exception {
		Helper.log(" *** CBL4 *** Test * Añadir un producto simple al carrito de comrpas ***");
		selenium.open("");
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
	}
}