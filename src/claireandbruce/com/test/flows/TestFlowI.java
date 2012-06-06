package claireandbruce.com.test.flows;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibChangeUnitsOneProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibPayPal;
import claireandbruce.com.test.basicsFlows.LibShoppingCart3DeleterItemShoppingCart;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;
import claireandbruce.com.test.basicsFlows.LibWindowPayPal;
import claireandbruce.com.test.basicsFlows.LibWithoutPurchase;

import basics.ClaireandbruceTestCase;

/**
 * Esta clase prueba los casos básicos para el flujo I.
 * @author NEWSHORE
 *
 */
public class TestFlowI extends ClaireandbruceTestCase{

	/** En este metodo de test se hace una prueba unitaria para el flujo I
	 * 
	 *  FlujoI: ProductoSimple + DirecciónExistente + SinFactura + PagoPayPal
	 * @throws Exception
	 */
	@Test
	public void test_flow1() throws Exception {
		
		
		LibWindowPayPal.CBT_Paypal(selenium);
		
		// El Usuario se Autentica
		//Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
			
		//Se añade un producto para realizar para eliminarlo posteriormente 
	//	Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		// Se Elimina el producto
		//Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se añade un producto nuevamente
		String nombreProducto= LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se añade un producto para realizar cambio de unidades
		//Lib_ChangeUnits_OneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de envío
		//Lib_TypeShipping.typeShipping(selenium);
		
		// Se verifica si existe una dirección por defecto y si esta seleccionada
		LibAddressExist.CBT_Address(selenium);
		
		// Se verifica que el envío se hara sin factura
		LibWithoutPurchase.CBT_WPurchase(selenium);
		
		// Se efectua el pago con Paypal
		LibPayPal.CBT_Paypal(selenium,nombreProducto);
		
		
	}
}
