package claireandbruce.com.test.basicsFlows;

import static org.junit.Assert.assertEquals;
import lib.Helper;
import basics.ClaireandbruceTestCase;

import com.thoughtworks.selenium.Selenium;

public class Lib_Pay_Credit_Card extends ClaireandbruceTestCase{

	public static void credit_Card(Selenium selenium) throws Exception {
		
		Helper.log("\nPAGO CON TARJETA DE CR�DITO");
		if(selenium.getTitle().equals("Compra ahora")){
			//Se selecciona m�todo de pago: Cheque
			selenium.click("xpath=.//*[@id='p_method_sermepa']");
			//Se selecciona tipo de tarjeta
			selenium.click("xpath=//ul[@id='payment_form_sermepa']/li/div/div/div/div[2]");
			selenium.click("xpath=//div[@value='VI']");
			//Se ingresan datos de la tarjeta de cr�dito
			selenium.type("xpath=//input[@id='sermepa_cc_number']", "4548812049400004");
			//Se selecciona mes y a�o de vigencia
			selenium.click("xpath=//li[3]/div/div/div/div/div");
			selenium.click("xpath=//div[@value='1']");
			selenium.click("xpath=//li[3]/div/div[2]/div/div/div[2]");
			selenium.click("xpath=//div[@value='2013']");
			//Se ingresa c�digo de seguridad
			selenium.type("xpath=//li[@id='sermepa_cc_type_cvv_div']/div/div/input","555");
			//Se aceptan t�rminos y condiciones
			selenium.click("id=agreement-1");
			//Se presiona el bot�n PAGAR
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			selenium.waitForPageToLoad("50000");
			assertEquals(selenium.getText("xpath=//p"),"Recibir�s un e-mail con tu confirmaci�n de compra a:");
			Helper.log("PEDIDO REALIZADO!!");				
		} else {
			Helper.log("No se encuentra actualmente en la interfaz 'Compra ahora'");
		}
	}
	
	
}
