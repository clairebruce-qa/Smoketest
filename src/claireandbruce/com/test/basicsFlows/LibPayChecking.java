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
		
		Helper.log("Se verifica que se encuentre una dirección de envío por defecto señalada");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca método de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'CÓMPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el botón 'CÓMPRALO AHROA' del header");
				selenium.waitForPageToLoad("30000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el botón 'COMPRA AHORA' ubicado en la parte superior de la página");
				selenium.waitForPageToLoad("30000");
			}
			Helper.log("Se presiona el botón 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}
		
			//Se selecciona método de pago: Cheque
			Helper.log("Se selecciona Pago con Cheque");
			selenium.click("xpath=.//*[@id='p_method_checkmo']");
			//Se aceptan términos y condiciones
			Helper.log("Se aceptan términos y condiciones y políticas de privacidad");
			selenium.click("id=agreement-1");
			//Se presiona el botón PAGAR
			if(selenium.isElementPresent("xpath=//div[@id='checkout-buttons-container']/button")){
				Helper.log("Se encuentra el botón pagar");				
			} else {
				Helper.log("No se encuentra el botón pagar");
			}
			Helper.log("Se hace clic en el botón pagar");
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			Helper.log("Se espera carga de la interfaz con mensaje de confirmación del pedido realizado");
			selenium.waitForPageToLoad("50000");
			Helper.log("Se verifica el mensaje de confirmación del pedido realizado");
			assertEquals(selenium.getText("xpath=//p"),"Recibirás un e-mail con tu confirmación de compra a:");
			Helper.log("PEDIDO REALIZADO!!");		
			Helper.log("Fin del proceso de pago con Cheque");
		
	}
}