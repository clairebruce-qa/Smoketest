package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibWindowPayPal;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librer�a que verifica la apertura correcta de la p�gina de PayPal
 * @author NEWSHORE
 *
 */
public class TestWindowPayPal extends ClaireandbruceTestCase{
	
	@Test
	public void CBL9() throws Exception {
		Helper.log(" *** CBL9 *** Test * Apertura de p�gina PayPal ***");
		LibWindowPayPal.CBT_Paypal(selenium);
	}

}
