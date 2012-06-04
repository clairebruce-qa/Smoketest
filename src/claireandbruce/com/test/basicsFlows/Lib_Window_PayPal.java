package claireandbruce.com.test.basicsFlows;

import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

/**
 * TestCase que verifíca que el pago será efectuado por Paypal.
 * @author NEWSHORE
 * 
 *
 */
public class Lib_Window_PayPal extends ClaireandbruceTestCase {
	
	public static void CBT_Paypal(Selenium selenium) throws Exception{
			
		selenium.open("https://developer.paypal.com");
		selenium.type("id=login_email", "david.vinuales@privalia.com");
		selenium.type("id=login_password", "testing1111");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		
		selenium.selectWindow("null");
		
		//selenium.waitForPopUp(ClaireandbruceUrl, "30000");
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){			
			Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);		
		}		
	}
}