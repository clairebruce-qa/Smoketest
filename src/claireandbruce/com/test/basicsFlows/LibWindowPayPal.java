package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

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
	
	
		
		selenium.open("https://developer.paypal.com");
		selenium.type("id=login_email", "david.vinuales@privalia.com");
		selenium.type("id=login_password", "testing1111");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		
		selenium.selectWindow("null");
		
		//selenium.waitForPopUp(ClaireandbruceUrl, "30000");
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		}
		

		
	}
}