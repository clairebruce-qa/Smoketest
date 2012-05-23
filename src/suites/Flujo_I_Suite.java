package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.basicosFlujos.CBT55_Test_CorrectLogon_ValidUser_TuCuenta;
import claireandbruce.com.test.basicosFlujos.Test_Address_Exist;
import claireandbruce.com.test.basicosFlujos.Test_ChangeUnits_OneProduct;
import claireandbruce.com.test.basicosFlujos.Test_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicosFlujos.Test_PayPal;
import claireandbruce.com.test.basicosFlujos.Test_TypeShipping;
import claireandbruce.com.test.basicosFlujos.Test_Without_Purchase;

/**
 * Flujo I login +  producto simple + con direccion + sin factura+ Pagado con Paypal
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	
	
	
	
	CBT55_Test_CorrectLogon_ValidUser_TuCuenta.class,
	Test_CorrectAddProduct_Cart_SimpleProduct.class,
	Test_ChangeUnits_OneProduct.class,
	//Test_TypeShipping.class,
	///meter el cambio de unidades para un solo producto
	
	/// verifica el tipo de envio
	//Test_Address_Exist.class,
	//Test_Without_Purchase.class,
	//Test_PayPal.class// termina
	
	
})

public class Flujo_I_Suite {
	


}
