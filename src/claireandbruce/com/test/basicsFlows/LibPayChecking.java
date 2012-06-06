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
			//Se selecciona método de pago: Cheque
			selenium.click("xpath=.//*[@id='p_method_checkmo']");
			//Se aceptan términos y condiciones
			selenium.click("id=agreement-1");
			//Se presiona el botón PAGAR
			if(selenium.isElementPresent("xpath=//div[@id='checkout-buttons-container']/button")){
				Helper.log("se encuentra el boton pagar");				
			} else {
				Helper.log("no se encuentra el boton pagar");
			}
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			selenium.waitForPageToLoad("50000");
			assertEquals(selenium.getText("xpath=//p"),"Recibirás un e-mail con tu confirmación de compra a:");
			Helper.log("PEDIDO REALIZADO!!");				
		} else {
			Helper.log("No se encuentra actualmente en la interfaz 'Compra ahora'");
		}
	}
}