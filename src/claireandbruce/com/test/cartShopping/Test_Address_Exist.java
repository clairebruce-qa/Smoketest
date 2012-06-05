package claireandbruce.com.test.cartShopping;

import lib.Helper;

import org.junit.Test;
import claireandbruce.com.test.basicsFlows.Lib_Address_Exist;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librer�a que verifica la existencia direcci�n por defecto
 * @author NEWSHORE
 *
 */

public class Test_Address_Exist extends ClaireandbruceTestCase{
	
	@Test
	public void CBL1() throws Exception {
		Helper.log(" *** CBL1 *** Test * Verificar la existencia de una direcci�n por defecto ***");
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		Lib_Address_Exist.CBT_Address(selenium);
	}
}