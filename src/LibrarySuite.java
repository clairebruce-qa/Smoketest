

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.cartShopping.TestAddressExist;
import claireandbruce.com.test.cartShopping.TestChangeUnitsOneProduct;
import claireandbruce.com.test.cartShopping.TestCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.cartShopping.TestCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.cartShopping.TestShoppingCart3DelerterItemShoppingCart;
import claireandbruce.com.test.cartShopping.TestTypeShipping;
import claireandbruce.com.test.cartShopping.TestWindowPayPal;
import claireandbruce.com.test.cartShopping.TestWithPurchase;
import claireandbruce.com.test.cartShopping.TestWithPurchaseAndOtherAddress;
import claireandbruce.com.test.cartShopping.TestWithoutPurchase;
import claireandbruce.com.test.login.TestCorrectLogonValidUserAccount;
import claireandbruce.com.test.login.checkout.TestCorrectLogonValidUserCheckout;


/**
 * 
 * 	Login.class,
 *
 * 
 * @author Administrator
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	// @Test correspondientes a algunas librerías de los Flujos	
	TestAddressExist.class,									//CBL1 - CBT113   - CBT36
	TestChangeUnitsOneProduct.class,						//CBL2 - CBT110   - CBT37
	TestCorrectAddProductCartConfigurableProduct.class, 	//CBL3 - CBT117   - CBT38
	TestCorrectAddProductCartSimpleProduct.class,  			//CBL4 - CBT111   - CBT39
	TestCorrectLogonValidUserCheckout.class, 				//CBL5 - CBT71    - CBT40
	TestCorrectLogonValidUserAccount.class, 				//CBL6 - CBT55    - CBT41
	TestShoppingCart3DelerterItemShoppingCart.class, 		//CBL7 - CBT118   - CBT42
	TestTypeShipping.class, 								//CBL8 - CBT112   - CBT43
	TestWindowPayPal.class, 								//CBL9 - CBT119   - CBT45
	TestWithPurchaseAndOtherAddress.class, 					//CBL10 - CBT120  - CBT46
	TestWithPurchase.class, 								//CBL11 - CBT11   - CBT48
	TestWithoutPurchase.class, 								//CBL12 - CBT115  - CBT49
	
	
})

public class LibrarySuite {

}
