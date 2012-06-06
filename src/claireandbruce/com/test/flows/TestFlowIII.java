package claireandbruce.com.test.flows;

import lib.Claireandbruce;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibChangeUnitsOneProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonCheckout;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibPayChecking;
import claireandbruce.com.test.basicsFlows.LibShoppingCart3DeleterItemShoppingCart;
import claireandbruce.com.test.basicsFlows.LibWithPurchase;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;
import claireandbruce.com.test.basicsFlows.LibWithPurchaseAndOtherAddress;

import basics.ClaireandbruceTestCase;
/**
 * FLUJOIII: ProductoSimple + CambioUnidades + TipoEnv�o + LoginCheckout + Direcci�nExistente + Factura + Direcci�nFactura != Direcci�nEnv�o + PagoCheque
 * @author NEWSHORE
 *
 */
public class TestFlowIII extends ClaireandbruceTestCase{

	/**En este m�todo de test se hace una prueba unitaria para el flujo III
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void test_flow3() throws Exception{		
				
		selenium.open("");
		if(selenium.isElementPresent("link=Salir")){
			Claireandbruce.logout(selenium);
		}
		
		//Se agrega un producto simple
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se elimina el producto 
		//Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se agrega un producto simple 
		//Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se cambian las unidades del producto
		LibChangeUnitsOneProduct.changeUnits(selenium);
		
		//Se selecciona aleatoriamente el tipo de env�o
		LibTypeShipping.typeShipping(selenium);
		
		//Login por checkout
		LibCorrectLogonCheckout.login_Checkout(selenium);		
		
		//Se selecciona la direcci�n de env�o
		LibAddressExist.CBT_Address(selenium);
		
		//Se solicita factura
		LibWithPurchase.shippingWithPurchase(selenium);
		
		//Se indica que la direcci�n de factura es diferente a la de env�o
		LibWithPurchaseAndOtherAddress.with_Purchase_and_Other_Address(selenium);
		
		//Se selecciona como forma de pago: Cheque
		LibPayChecking.pay_checking(selenium);
		
	}
}
