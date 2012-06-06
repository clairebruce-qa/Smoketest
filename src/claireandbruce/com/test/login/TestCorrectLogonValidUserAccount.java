package claireandbruce.com.test.login;

import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la librería de login correcto.
 * @author NEWSHORE
 * CBT55
 */
public class TestCorrectLogonValidUserAccount extends ClaireandbruceTestCase {

	@Test
	public void CBL6() throws Exception{
		Helper.log("*** CBL6 *** Test Login correcto ***");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
	}
}
