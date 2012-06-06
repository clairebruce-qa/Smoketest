package claireandbruce.com.test.basicsFlows;

import lib.Helper;

import com.thoughtworks.selenium.Selenium;
import static org.junit.Assert.assertEquals;
import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */
public class LibPayChecking extends ClaireandbruceTestCase {

	public static void pay_checking(Selenium selenium) throws Exception {

		Helper.log("\nPAGO CON CHEQUE");
		if(selenium.getTitle().equals("Compra ahora")){
			//Se selecciona m�todo de pago: Cheque
			selenium.click("xpath=.//*[@id='p_method_checkmo']");
			//Se aceptan t�rminos y condiciones
			selenium.click("id=agreement-1");
			//Se presiona el bot�n PAGAR
			if(selenium.isElementPresent("xpath=//div[@id='checkout-buttons-container']/button")){
				Helper.log("se encuentra el boton pagar");				
			} else {
				Helper.log("no se encuentra el boton pagar");
			}
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			selenium.waitForPageToLoad("50000");
			assertEquals(selenium.getText("xpath=//p"),"Recibir�s un e-mail con tu confirmaci�n de compra a:");
			Helper.log("PEDIDO REALIZADO!!");				
		} else {
			Helper.log("No se encuentra actualmente en la interfaz 'Compra ahora'");
		}
	}
}