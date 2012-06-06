package claireandbruce.com.test.basicsFlows;


import org.junit.Assert;
import lib.Helper;
import basics.ClaireandbruceTestCase;
import com.thoughtworks.selenium.Selenium;
/**
 * 
 * @author NEWSHORE
 *
 */
public class LibPayCreditCard extends ClaireandbruceTestCase{

	public static void credit_Card(Selenium selenium) throws Exception {
		
		Helper.log("\nPAGO CON TARJETA DE CR�DITO");
		if(selenium.getTitle().equals("Compra ahora")){
			//Se selecciona m�todo de pago: Cheque
			selenium.click("xpath=.//*[@id='p_method_sermepa']");
			//Se selecciona tipo de tarjeta
			selenium.click("xpath=//ul[@id='payment_form_sermepa']/li/div/div/div/div[2]");
			selenium.click("xpath=//div[@value='VI']");
			//Se ingresan datos de la tarjeta de cr�dito
			selenium.type("id=cc_number_part1","4548");
			selenium.type("id=cc_number_part2","8120");
			selenium.type("id=cc_number_part3","4940");
			selenium.type("id=cc_number_part4","0004");
			//Se selecciona mes y a�o de vigencia
			selenium.click("xpath=//li[3]/div/div/div/div/div");
			selenium.click("xpath=//div[@value='12']");
			selenium.click("xpath=//li[3]/div/div[2]/div/div/div[2]");
			selenium.click("xpath=//div[@value='2012']");
			//Se ingresa c�digo de seguridad
			selenium.type("xpath=//li[@id='sermepa_cc_type_cvv_div']/div/div/input","123");
			//Se aceptan t�rminos y condiciones
			selenium.click("id=agreement-1");
			//Se presiona el bot�n PAGAR
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			
			if(selenium.isAlertPresent() || selenium.isTextPresent("El n�mero de tarjeta de cr�dito no se ajusta al tipo de tarjeta de cr�dito.")){
				//selenium.getAlert();
				Assert.fail("Datos de tarjeta de cr�dito no v�lidos");
			} else {
				selenium.waitForPageToLoad("25000");
				//SI EL TITULO DE LA PAGINA ES COMPRAR AHORA FALLAR
		    }			
			
			if(selenium.getText("xpath=//p").equals("Recibir�s un e-mail con tu confirmaci�n de compra a:")){
				Helper.log("PEDIDO REALIZADO!!");
			} else {
				Helper.log("PEDIDO NO REALIZADO!!");
			}
							
		} else {
			Helper.log("No se encuentra actualmente en la interfaz 'Compra ahora'");
		}
	}	
}