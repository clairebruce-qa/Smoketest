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

		Helper.log(" ");
		Helper.log("\nSe inicia el PAGO CON CHEQUE");
		
		Helper.log("Se verifica que se encuentre una direcci�n de env�o por defecto se�alada");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca m�todo de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el bot�n 'C�MPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el bot�n 'C�MPRALO AHROA' del header");
				selenium.waitForPageToLoad("30000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el bot�n 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el bot�n 'COMPRA AHORA' ubicado en la parte superior de la p�gina");
				selenium.waitForPageToLoad("30000");
			}
			Helper.log("Se presiona el bot�n 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}
		
			//Se selecciona m�todo de pago: Cheque
			Helper.log("Se selecciona Pago con Cheque");
			selenium.click("xpath=.//*[@id='p_method_checkmo']");
			//Se aceptan t�rminos y condiciones
			Helper.log("Se aceptan t�rminos y condiciones y pol�ticas de privacidad");
			selenium.click("id=agreement-1");
			//Se presiona el bot�n PAGAR
			if(selenium.isElementPresent("xpath=//div[@id='checkout-buttons-container']/button")){
				Helper.log("Se encuentra el bot�n pagar");				
			} else {
				Helper.log("No se encuentra el bot�n pagar");
			}
			Helper.log("Se hace clic en el bot�n pagar");
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			Helper.log("Se espera carga de la interfaz con mensaje de confirmaci�n del pedido realizado");
			selenium.waitForPageToLoad("50000");
			Helper.log("Se verifica el mensaje de confirmaci�n del pedido realizado");
			assertEquals(selenium.getText("xpath=//p"),"Recibir�s un e-mail con tu confirmaci�n de compra a:");
			Helper.log("PEDIDO REALIZADO!!");		
			Helper.log("Fin del proceso de pago con Cheque");
		
	}
}