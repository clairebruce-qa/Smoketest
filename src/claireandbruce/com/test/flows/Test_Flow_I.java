package claireandbruce.com.test.flows;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_PayPal;
import claireandbruce.com.test.basicsFlows.Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24;
import claireandbruce.com.test.basicsFlows.Lib_TypeShipping;
import claireandbruce.com.test.basicsFlows.Lib_Window_PayPal;
import claireandbruce.com.test.basicsFlows.Lib_Without_Purchase;

import basics.ClaireandbruceTestCase;

/**
 * Esta clase prueba los casos b�sicos para el flujo I.
 * @author Maria Fernanda Rodr�guez
 * @author Yuliana Maria Saavedra
 *
 */
public class Test_Flow_I extends ClaireandbruceTestCase{

	/**En este metodo de test se hace una prueba unitaria para el flujo I
	 * Se pueden comentar los m�todos de cambio de unidades, eliminar producto
	 * y seleccionar direcci�n de env�o (solo son validaciones de confirmaci�n)
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_flow1() throws Exception {
		
		
		Lib_Window_PayPal.CBT_Paypal(selenium);
		
		// El Usuario se Autentica
		//Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
			
		//Se a�ade un producto para realizar para eliminarlo posteriormente 
	//	Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		// Se Elimina el producto
		//Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se a�ade un producto nuevamente
		String nombreProducto= Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se a�ade un producto para realizar cambio de unidades
		//Lib_ChangeUnits_OneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de env�o
		//Lib_TypeShipping.typeShipping(selenium);
		
		// Se verifica si existe una direcci�n por defecto y si esta seleccionada
		Lib_Address_Exist.Address_Exist(selenium);
		
		// Se verifica que el env�o se hara sin factura
		Lib_Without_Purchase.CBT_WPurchase(selenium);
		
		// Se efectua el pago con Paypal
		Lib_PayPal.CBT_Paypal(selenium,nombreProducto);
	}
}
