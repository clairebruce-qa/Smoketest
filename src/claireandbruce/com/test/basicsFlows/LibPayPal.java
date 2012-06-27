package claireandbruce.com.test.basicsFlows;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;


/**
 * TestCase que verifíca que el pago será efectuado por Paypal.
 * @author NEWSHORE
 *
 */
public class LibPayPal extends ClaireandbruceTestCase {

	/**
	 *  
	 * @param nombreProducto
	 * @throws Exception
	 */
	
	public static void CBT_Paypal(Selenium selenium, String nombreProducto) throws Exception{
	
	
		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		Helper.log("Se verifica si se encuentra en la página 'Compra ahora'");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca método de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'CÓMPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el botón 'CÓMPRALO AHROA' del header");
				selenium.waitForPageToLoad("40000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el botón 'COMPRA AHORA' ubicado en la parte superior de la página");
				selenium.waitForPageToLoad("40000");
			}
			Helper.log("Se presiona el botón 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("30000");
		}	
		
		
		if(("off").equals(selenium.getValue("name=shipping_address_id"))){	
			LibAddressExist.CBT_Address(selenium);
			//Test_Without_Purchase.CBT_WPurchase(selenium);
		}
		
		if(("on").equals(selenium.getValue("id=showFakeBilling"))){	
			LibAddressExist.CBT_Address(selenium);
			
		}
		//------*****  Verifica que el pedido es pagado con Paypal *****-------\\
		
		Helper.log("Se verifica que se selecciona el pago con PayPal");
		if(("off").equals(selenium.getValue("id=p_method_paypal_express")))	{
			Helper.log("Se hace clic en la opción de Pago con PayPal");
			selenium.click("id=p_method_paypal_express");			
		} else {
			Assert.fail("Error:  No seleccionó el método de pago PAYPAL");
		}
		if(("off").equals(selenium.getValue("id=agreement-1"))) {
			Helper.log("Se aceptan términos y condiciones y políticas de privacidad");
			selenium.click("id=agreement-1");						
		} else {
			Assert.fail("Error:  Se deben aceptar los términos y condiciones y las políticas de privacidad");
		}
		Helper.log("Se hace clic en el botón 'PAGAR'");
		selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
		Helper.log("Se espera carga de la interfaz de PayPal a la que se redirecciona para finalizar el pago");
		selenium.waitForPageToLoad("50000");
		
		//----**** Se confirma el pago en Paypal ----****\\
		
		//selenium.waitForPageToLoad("30000");
		
		
		//----**** Se autentica el usuario en Paypal ****----\\
		Helper.log("Se inicia proceso de autenticación del usuario en PayPal");
		/*if(!selenium.isElementPresent("xpath=.//*[@id='loadLogin']"))
		{
			Assert.fail(selenium.getLocation());
		}
		Helper.log("Se cargan campos para login");
		selenium.click("xpath=.//*[@id='loadLogin']");
		selenium.waitForPageToLoad("60000");*/
		
		Helper.log("Se ingresan los datos de usuario de PayPal");
		selenium.type("xpath=.//*[@id='login_email']", "qualit_1337780842_per@privalia.com");
		selenium.type("xpath=.//*[@id='login_password']", "337780714");
		Helper.log("Se hace clic en el botón para iniciar sesión");
		selenium.click("id=submitLogin");
		selenium.waitForPageToLoad("60000");
		// Se confirma el pago en Paypal \\
		Helper.log("Se confirma el pago en PayPal");
		selenium.click("id=continue_abovefold");
		
		selenium.waitForPageToLoad("60000");
		//Helper.log("Se presiona en el enlace que redirecciona a C+B"); Al cambiar el pago a PayPal Express no se posee esto
		//selenium.click("xpath=.//*[@id='doneInfo']/ul/li[1]/a");
		
		//selenium.waitForPageToLoad("60000");
		
		// Selenium Redireccion a la página de ClaireandBruce y confirma que el pedido se ha enviado  \\
		Helper.log("Se verifica que se encuentre el mensaje de confirmación sobre el pedido realizado con éxito");
	   	assertEquals(selenium.isTextPresent("Recibirás un e-mail con tu confirmación de compra a:"),true);
		Helper.log("PEDIDO REALIZADO!!");		
		if(!selenium.isElementPresent("//span[2]")||!selenium.isElementPresent("css=span.button"))
		{
			Assert.fail("Error no se encontro el pedido");
		}
		
		
	

	}
}
