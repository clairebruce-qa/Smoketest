package claireandbruce.com.test.flows;

import lib.Claireandbruce;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_Pay_Checking;
import claireandbruce.com.test.basicsFlows.Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase;
import claireandbruce.com.test.basicsFlows.Lib_TypeShipping;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase_and_Other_Address;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */
public class Test_Flow_III extends ClaireandbruceTestCase{

	/**En este método de test se hace una prueba unitaria para el flujo III
	 * Se pueden comentar los métodos de cambio de unidades, eliminar producto
	 * y seleccionar dirección de envío (solo son validaciones de confirmación)
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void test_flow3() throws Exception{		
				
		if(selenium.isElementPresent("link=Salir")){
			Claireandbruce.logout(selenium);
		}
		
		//Se agrega un producto simple
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se elimina el producto 
		//Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se agrega un producto simple 
		//Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se cambian las unidades del producto
		Lib_ChangeUnits_OneProduct.changeUnits(selenium);
		
		//Se selecciona aleatoriamente el tipo de envío
		Lib_TypeShipping.typeShipping(selenium);
		
		//Login por checkout
		Lib_CorrectLogon_Checkout.login_Checkout(selenium);		
		
		//Se selecciona la dirección de envío
		Lib_Address_Exist.CBT_Address(selenium);
		
		//Se solicita factura
		Lib_With_Purchase.shippingWithPurchase(selenium);
		
		//Se indica que la dirección de factura es diferente a la de envío
		Lib_With_Purchase_and_Other_Address.with_Purchase_and_Other_Address(selenium);
		
		//Se selecciona como forma de pago: Cheque
		Lib_Pay_Checking.pay_checking(selenium);
		
	}
}
