package claireandbruce.com.test.login;

import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import basics.ClaireandbruceTestCase;

/**
 * @Test correspondiente a la librería de login correcto.
 * @author NEWSHORE
 * CBT55
 */
public class Test_CorrectLogon_ValidUser_Account extends ClaireandbruceTestCase {

	@Test
	public void CBL6() throws Exception{
		Helper.log("*** CBL6 *** Test Login correcto ***");
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
	}
}
