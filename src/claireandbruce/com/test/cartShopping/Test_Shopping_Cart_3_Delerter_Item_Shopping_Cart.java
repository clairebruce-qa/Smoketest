package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24;

import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la existencia dirección por defecto
 * @author NEWSHORE
 *
 */
public class Test_Shopping_Cart_3_Delerter_Item_Shopping_Cart extends ClaireandbruceTestCase{
	
	@Test
	public void CBL7() throws Exception {
		Helper.log(" *** CBL7 *** Test * Eliminar un producto del carrito de compras ***");
		selenium.open("");
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
	}
}