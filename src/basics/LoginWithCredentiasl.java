
package basics;
import org.junit.Test;
import junit.framework.Assert;
import lib.*;


public class LoginWithCredentiasl extends ClaireandbruceTestCase {

	@Test
	public void testLogin() throws Exception {
		selenium.deleteAllVisibleCookies();
		
		selenium.open("");
		
		Helper.waitForElement(selenium,"//a[contains(text(),'Tu cuenta')]","link "+ "Link Tu Cuenta not found");
		selenium.click("//a[contains(text(),'Tu cuenta')]");

		//Clearandbruce.login(selenium, username,password);
		
		//Clearandbruce.logout(selenium);	
	}
}
