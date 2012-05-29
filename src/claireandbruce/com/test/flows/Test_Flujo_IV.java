package claireandbruce.com.test.flows;

import lib.Claireandbruce;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_Checkout;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_PayPal;
import claireandbruce.com.test.basicsFlows.Lib_Pay_Checking;
import claireandbruce.com.test.basicsFlows.Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24;
import claireandbruce.com.test.basicsFlows.Lib_TypeShipping;
import claireandbruce.com.test.basicsFlows.Lib_Without_Purchase;

import basics.ClaireandbruceTestCase;

/**
 * 
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */
public class Test_Flujo_IV  extends ClaireandbruceTestCase{

	/**
	 * En este m�todo de test se hace una prueba unitaria para el flujo IV
	 * Se pueden comentar los m�todos de cambio de unidades, eliminar producto
	 * y seleccionar direcci�n de env�o (solo son validaciones de confirmaci�n)
	 * 4.	Compra producto configurable  + login por checkout + en pagina de compra direcci�n existente + sin factura
	 * pago con cheque
	 * @throws Exception
	 */
	@Test
	public void test_flujo4() throws Exception
	{
		if(selenium.isElementPresent("link=Salir")){
			Claireandbruce.logout(selenium);
		}
		
		//Se a�ade un producto para realizar para eliminarlo posteriormente 
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		
		// Se Elimina el producto
		//Test_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se a�ade un producto nuevamente
		//String nombreProducto= Test_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		
		//Se a�ade un producto para realizar cambio de unidades
		Lib_ChangeUnits_OneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de env�o
		Lib_TypeShipping.typeShipping(selenium);
		
		//Se realiza login por checkout
		Lib_CorrectLogon_Checkout.login_Checkout(selenium);
		
		// Se verifica si existe una direcci�n por defecto y si esta seleccionada
		Lib_Address_Exist.CBT_Address(selenium);
		
		// Se verifica que el env�o se hara sin factura
		Lib_Without_Purchase.CBT_WPurchase(selenium);
		
		// Se efectua el pago con cheque
		Lib_Pay_Checking.pay_checking(selenium);		
	}	
}