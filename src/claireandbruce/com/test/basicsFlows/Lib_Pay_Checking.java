package claireandbruce.com.test.basicsFlows;

import lib.Helper;

import com.thoughtworks.selenium.Selenium;
import static org.junit.Assert.assertEquals;
import basics.ClaireandbruceTestCase;

public class Lib_Pay_Checking extends ClaireandbruceTestCase {

	public static void pay_checking(Selenium selenium) throws Exception {

		Helper.log("\nPAGO CON CHEQUE");
		if(selenium.getTitle().equals("Compra ahora")){
			//Se selecciona método de pago: Cheque
			selenium.click("id=p_method_checkmo");
			//Se aceptan términos y condiciones
			selenium.click("id=agreement-1");
			//Se presiona el botón PAGAR
			selenium.click("xpath=//form/div/button");
			selenium.waitForPageToLoad("30000");
			assertEquals(selenium.getText("xpath=//p"),"Recibirás un e-mail con tu confirmación de compra a:");
			Helper.log("PEDIDO REALIZADO!!");				
		} else {
			Helper.log("No se encuentra actualmente en la interfaz 'Compra ahora'");
		}
	}
}