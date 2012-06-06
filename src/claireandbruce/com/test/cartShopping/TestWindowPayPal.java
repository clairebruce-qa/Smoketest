package claireandbruce.com.test.cartShopping;

import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibWindowPayPal;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la Librería que verifica la apertura correcta de la página de PayPal
 * @author NEWSHORE
 *
 */
public class TestWindowPayPal extends ClaireandbruceTestCase{
	
	@Test
	public void CBL9() throws Exception {
		Helper.log(" *** CBL9 *** Test * Apertura de página PayPal ***");
		LibWindowPayPal.CBT_Paypal(selenium);
	}

}
