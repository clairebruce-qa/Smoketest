package claireandbruce.com.test.flows;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonCheckout;
import claireandbruce.com.test.basicsFlows.LibPayCreditCard;
import claireandbruce.com.test.basicsFlows.LibShoppingCart3DeleterItemShoppingCart;
import claireandbruce.com.test.basicsFlows.LibWithPurchase;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;
import claireandbruce.com.test.basicsFlows.LibWithPurchaseAndOtherAddress;

import basics.ClaireandbruceTestCase;
/**
 * FLUJOIII: ProductoSimple + EliminarProducto + ProductoSimple + TipoEnvío + LoginCheckout + DirecciónExistente + Factura + DirecciónFactura != DirecciónEnvío + PagoCheque
 * @author NEWSHORE
 *
 */
public class TestFlowIII extends ClaireandbruceTestCase{

	/**En este método de test se hace una prueba unitaria para el flujo III
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void test_flow3() throws Exception{		
				
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		if(selenium.isElementPresent("link=Salir")){
			Helper.log("Se ha encontrado una sesión inicada al cargar la página C+B");
			Claireandbruce.logout(selenium);
		}
		
		//Se agrega un producto simple
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se elimina el producto 
		LibShoppingCart3DeleterItemShoppingCart.CBT24(selenium);
		
		//Se agrega un producto simple 
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se cambian las unidades del producto
		//LibChangeUnitsOneProduct.changeUnits(selenium);
		
		//Se selecciona aleatoriamente el tipo de envío
		LibTypeShipping.typeShipping(selenium);
		
		//Login por checkout
		LibCorrectLogonCheckout.login_Checkout(selenium);		
		
		//Se selecciona la dirección de envío
		LibAddressExist.CBT_Address(selenium);
		
		//Se solicita factura
		LibWithPurchase.shippingWithPurchase(selenium);
		
		//Se indica que la dirección de factura es diferente a la de envío
		LibWithPurchaseAndOtherAddress.with_Purchase_and_Other_Address(selenium);
		
		//Se selecciona como forma de pago: Tarjeta de crédito
		LibPayCreditCard.credit_Card(selenium);
		
	}
}
