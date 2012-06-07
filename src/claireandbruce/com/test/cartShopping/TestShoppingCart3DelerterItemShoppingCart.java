package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibShoppingCart3DeleterItemShoppingCart;

import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la existencia dirección por defecto
 * @author NEWSHORE
 * CBL7 - CBT118
 */
public class TestShoppingCart3DelerterItemShoppingCart extends ClaireandbruceTestCase{
	
	@Test
	public void CBL7() throws Exception {
		Helper.log(" *** CBL7 *** Test * Eliminar un producto del carrito de compras ***");
		selenium.open("");
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibShoppingCart3DeleterItemShoppingCart.CBT24(selenium);
	}
}