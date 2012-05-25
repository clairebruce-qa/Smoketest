package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import lib.Claireandbruce;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * TestCase que verifíca que el pedido sera efectuado sin factura.
 * 
 * 
 * 
 * @author YULIANA MARÍA SAAVEDRA RUSSÍ
 *
 */
public class Lib_Without_Purchase extends ClaireandbruceTestCase {
	
	public static void CBT_WPurchase(Selenium selenium) throws Exception{
	
		// ESTO SE PONE EN COMENTARIO PARA QUE CORRA EN EL FLUJO
		
	//	selenium.deleteAllVisibleCookies();
		//selenium.open("");
		//selenium.waitForPageToLoad("15000");
		
		//if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			//selenium.click("//a[@id='overridelink']");
		//}	
		
		//if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){			
			//Claireandbruce.login(selenium, username, password); // Se comenta para la prueba de flujo 
			//Assert.fail("El usuario no esta autenticado");
		//}
				

		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("//a[contains(text(),'Compra ahora')]");
			
			selenium.waitForPageToLoad("15000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("15000");			
		}
		
		//------*****  Verifica que el pedido será sin factura *****-------\\
				
		if(!("off").equals(selenium.getValue("id=showFakeBilling"))) {
			Assert.fail("Error:  Se esta solicitando la factura");
		}
		
		
	}
}