package claireandbruce.com.test.basicsFlows;

import lib.Helper;

import com.thoughtworks.selenium.Selenium;
import static org.junit.Assert.assertEquals;
import basics.ClaireandbruceTestCase;

public class Lib_Pay_Checking extends ClaireandbruceTestCase {

	public static void pay_checking(Selenium selenium) throws Exception {

		Helper.log("\nPAGO CON CHEQUE");
		if(!selenium.getTitle().equals("Compra ahora")){
			if(!selenium.getTitle().equals("Cesta de la Compra")){
				if(selenium.isElementPresent("link=Compra ahora")){
					selenium.click("link=Compra ahora");
					selenium.waitForPageToLoad("15000");
				} else {
					selenium.click("id=cartHeader");
					selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
					selenium.waitForPageToLoad("15000");			
				}			
			}
			
			//Se presiona el botón "CONTINUA"
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("20000");
		}
		
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