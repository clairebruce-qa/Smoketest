package claireandbruce.com.test.flows;

import lib.Claireandbruce;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonCheckout;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibChangeUnitsOneProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibPayPal;
import claireandbruce.com.test.basicsFlows.LibPayChecking;
import claireandbruce.com.test.basicsFlows.LibShoppingCart3DeleterItemShoppingCart;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;
import claireandbruce.com.test.basicsFlows.LibWithoutPurchase;

import basics.ClaireandbruceTestCase;

/**
 * FlujoIV: ProductoConfigurable + CambioUnidades + TipoEnv�o + LoginCheckout + Direcci�nExistente + SinFactura + PagoCheque
 * @author NEWSHORE
 *
 */
public class TestFlowIV  extends ClaireandbruceTestCase{

	/**
	 * En este m�todo de test se hace una prueba unitaria para el flujo IV
	 * @throws Exception
	 */
	@Test
	public void test_flujo4() throws Exception
	{
		selenium.open("");
		if(selenium.isElementPresent("link=Salir")){
			Claireandbruce.logout(selenium);
		}
		
		//Se a�ade un producto para realizar para eliminarlo posteriormente 
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		
		// Se Elimina el producto
		//Test_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se a�ade un producto nuevamente
		//String nombreProducto= Test_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		
		//Se a�ade un producto para realizar cambio de unidades
		LibChangeUnitsOneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de env�o
		LibTypeShipping.typeShipping(selenium);
		
		//Se realiza login por checkout
		LibCorrectLogonCheckout.login_Checkout(selenium);
		
		// Se verifica si existe una direcci�n por defecto y si esta seleccionada
		LibAddressExist.CBT_Address(selenium);
		
		// Se verifica que el env�o se hara sin factura
		LibWithoutPurchase.CBT_WPurchase(selenium);
		
		// Se efectua el pago con cheque
		LibPayChecking.pay_checking(selenium);	
	}	
}