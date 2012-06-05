package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;
import claireandbruce.com.test.basicsFlows.Lib_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que realiza el cambio de unidades al primer producto
 * en la lista de añadidos al carrito de compras
 * @author NEWSHORE
 *
 *
 */
public class Test_ChangeUnits_OneProduct extends ClaireandbruceTestCase {
	
	@Test
	public void CBL2() throws Exception {
		Helper.log(" *** CBL2 *** Test * Cambio de unidades a un producto ***");
		selenium.open("");
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		Lib_ChangeUnits_OneProduct.changeUnits(selenium);
	}
}