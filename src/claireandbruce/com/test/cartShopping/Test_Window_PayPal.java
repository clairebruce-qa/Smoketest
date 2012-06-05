package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_Window_PayPal;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la apertura correcta de la página de PayPal
 * @author NEWSHORE
 *
 */
public class Test_Window_PayPal extends ClaireandbruceTestCase{
	
	@Test
	public void CBL9() throws Exception {
		Helper.log(" *** CBL9 *** Test * Apertura de página PayPal ***");
		Lib_Window_PayPal.CBT_Paypal(selenium);
	}

}
