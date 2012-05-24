package claireandbruce.com.test.basicosFlujos;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * Esta clase prueba los casos básicos para los flujos.
 * @author Maria Fernanda Rodríguez
 * @author Yuliana Maria Saavedra
 *
 */
public class Flujo_I extends ClaireandbruceTestCase{

	@Test
	public void test_flujo1() throws Exception {
		
		
		CBT55_Test_CorrectLogon_ValidUser_TuCuenta.CBT55(selenium);
		
		
		//Se añade un producto para realizar para eliminarlo posteriormente 
		//Test_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		// Se Elimina el producto
		//CBT24_Test_Shopping_Cart_3_Deleter_Item_Shopping_Cart.CBT24(selenium);
		
		//Se añade un producto para realizar cambio de unidades

		Test_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		//Test_ChangeUnits_OneProduct.changeUnits(selenium);

		String nombreProducto= Test_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se cambia los productos. 
		Test_ChangeUnits_OneProduct.changeUnits(selenium);

		Test_TypeShipping.typeShipping(selenium);
		
		Test_Address_Exist.CBT_Address(selenium);
		
		Test_Without_Purchase.CBT_WPurchase(selenium);
		
		Test_PayPal.CBT_Paypal(selenium,nombreProducto);
	}
}
