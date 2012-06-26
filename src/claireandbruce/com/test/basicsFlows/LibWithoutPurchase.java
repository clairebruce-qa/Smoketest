package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * TestCase que verifíca que el pedido sera efectuado sin factura.
 * @author NEWSHORE
 *
 */
public class LibWithoutPurchase extends ClaireandbruceTestCase {
	
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
		Helper.log("Se verifica si se encuentra en la página 'Compra ahora'");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca método de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'CÓMPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el botón 'CÓMPRALO AHROA' del header");
				selenium.waitForPageToLoad("60000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el botón 'COMPRA AHORA' ubicado en la parte superior de la página");
				selenium.waitForPageToLoad("60000");
			}
			Helper.log("Se presiona el botón 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("60000");
		}
		
		//------*****  Verifica que el pedido será sin factura *****-------\\
		Helper.log("Se verifica que no se encuentre activo el check 'Necesito una factura'");		
		if(!("off").equals(selenium.getValue("id=showFakeBilling"))) {
			Helper.log("Se está solicitando la factura por defecto");
			Assert.fail("Error:  Se esta solicitando la factura");
		}
		
		
	}
}