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
 * FLUJOIII: ProductoSimple + EliminarProducto + ProductoSimple + TipoEnv�o + LoginCheckout + Direcci�nExistente + Factura + Direcci�nFactura != Direcci�nEnv�o + PagoCheque
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
				
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl);
		selenium.open("");
		if(selenium.isElementPresent("link=Salir")){
			Helper.log("Se ha encontrado una sesi�n inicada al cargar la p�gina C+B");
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
		
		//Se selecciona como forma de pago: Tarjeta de cr�dito
		LibPayCreditCard.credit_Card(selenium);
		
	}
}
