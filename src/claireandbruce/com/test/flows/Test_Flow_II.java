package claireandbruce.com.test.flows;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_With_Purchase;
import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_PayPal;
import claireandbruce.com.test.basicsFlows.Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24;
import claireandbruce.com.test.basicsFlows.Lib_TypeShipping;
import claireandbruce.com.test.basicsFlows.Lib_Without_Purchase;

import basics.ClaireandbruceTestCase;

/**
 * 
 * @author YULIANA MAR�A SAAVEDRA RUSS�
 *
 */
public class Test_Flow_II extends ClaireandbruceTestCase {

	/**En este m�todo de test se hace una prueba unitaria para el flujo II
	 * Se pueden comentar los m�todos de cambio de unidades, eliminar producto
	 * y seleccionar direcci�n de env�o (solo son validaciones de confirmaci�n)
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void test_flow2() throws Exception{		
		
		// El Usuario se Autentica
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
				
		//Se a�ade un producto para realizar para eliminarlo posteriormente 
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		// Se Elimina el producto
		Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se a�ade un producto nuevamente
		String nombreProducto= Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se a�ade un producto para realizar cambio de unidades
		Lib_ChangeUnits_OneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de env�o
		Lib_TypeShipping.typeShipping(selenium);
		
		// Se verifica si existe una direcci�n por defecto y si esta seleccionada
		Lib_Address_Exist.CBT_Address(selenium);
		
		// Se verifica que el env�o se hara sin factura
		Lib_With_Purchase.shippingWithPurchase(selenium);
		
		// Se efectua el pago con Paypal
		Lib_PayPal.CBT_Paypal(selenium,nombreProducto);		
	}
}
