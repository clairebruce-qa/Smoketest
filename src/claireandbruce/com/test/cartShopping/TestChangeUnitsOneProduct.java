package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibChangeUnitsOneProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que realiza el cambio de unidades al primer producto
 * en la lista de añadidos al carrito de compras
 * @author NEWSHORE
 *
 */
public class TestChangeUnitsOneProduct extends ClaireandbruceTestCase {
	
	@Test
	public void CBL2() throws Exception {
		Helper.log(" *** CBL2 *** Test * Cambio de unidades a un producto ***");
		selenium.open("");
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibChangeUnitsOneProduct.changeUnits(selenium);
	}
}