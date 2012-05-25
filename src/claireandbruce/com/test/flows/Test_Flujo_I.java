package claireandbruce.com.test.flows;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.CBT55_Test_CorrectLogon_ValidUser_TuCuenta;
import claireandbruce.com.test.basicsFlows.Test_Address_Exist;
import claireandbruce.com.test.basicsFlows.Test_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicsFlows.Test_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Test_PayPal;
import claireandbruce.com.test.basicsFlows.Test_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24;
import claireandbruce.com.test.basicsFlows.Test_TypeShipping;
import claireandbruce.com.test.basicsFlows.Test_Without_Purchase;

import basics.ClaireandbruceTestCase;

/**
 * Esta clase prueba los casos básicos para el flujo I.
 * @author Maria Fernanda Rodríguez
 * @author Yuliana Maria Saavedra
 *
 */
public class Test_Flujo_I extends ClaireandbruceTestCase{

	/**En este metodo de test se hace una prueba unitaria para el flujo I
	 * Se pueden comentar los métodos de cambio de unidades, eliminar producto
	 * y seleccionar dirección de envío (solo son validaciones de confirmación)
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_flujo1() throws Exception {
		
		// El Usuario se Autentica
		CBT55_Test_CorrectLogon_ValidUser_TuCuenta.CBT55(selenium);
		
		
		//Se añade un producto para realizar para eliminarlo posteriormente 
		Test_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		// Se Elimina el producto
		Test_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24.CBT24(selenium);
		
		//Se añade un producto nuevamente
		String nombreProducto= Test_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se añade un producto para realizar cambio de unidades
		Test_ChangeUnits_OneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de envío
		Test_TypeShipping.typeShipping(selenium);
		
		// Se verifica si existe una dirección por defecto y si esta seleccionada
		Test_Address_Exist.CBT_Address(selenium);
		
		// Se verifica que el envío se hara sin factura
		Test_Without_Purchase.CBT_WPurchase(selenium);
		
		// Se efectua el pago con Paypal
		Test_PayPal.CBT_Paypal(selenium,nombreProducto);
	}
}
