package claireandbruce.com.test.basicsFlows;

import lib.Helper;
import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;


/**
 * TestCase que verif�ca que el pago ser� efectuado por Paypal.
 * @author NEWSHORE
 *
 */
public class LibWindowPayPal extends ClaireandbruceTestCase {

	/**
	 *  
	 * @param nombreProducto
	 * @throws Exception
	 */
	
	public static void CBT_Paypal(Selenium selenium) throws Exception{
	
	
		Helper.log("Carga de la p�gina de PayPal para iniciar sesi�n en ella");
		selenium.open("https://developer.paypal.com");
		if(selenium.isElementPresent("//input[@id='login_email']")){
 			selenium.type("id=login_email", "david.vinuales@privalia.com");
 			selenium.type("id=login_password", "testing1111");
 			selenium.click("name=submit");
 			selenium.waitForPageToLoad("30000");
 		}
		selenium.selectWindow("null");
		
		//selenium.waitForPopUp(ClaireandbruceUrl, "30000");
		
		

		
	}
}
