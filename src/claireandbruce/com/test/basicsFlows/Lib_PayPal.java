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
 */
public class Lib_PayPal extends ClaireandbruceTestCase {
	
	public static void CBT_Paypal(Selenium selenium, String nombreProducto) throws Exception{
	
		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
			
			selenium.waitForPageToLoad("15000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("20000");			
		}		
		
		
		if(("off").equals(selenium.getValue("name=shipping_address_id"))){	
			Lib_Address_Exist.Address_Exist(selenium);
			//Test_Without_Purchase.CBT_WPurchase(selenium);
		}
		
		if(("on").equals(selenium.getValue("id=showFakeBilling"))){	
			Lib_Address_Exist.Address_Exist(selenium);
			
		}
		//------*****  Verifica que el pedido es pagado con Paypal *****-------\\
		
		
		if(("off").equals(selenium.getValue("xpath=.//*[@id='p_method_paypal_standard']")))	{
			selenium.click("xpath=.//*[@id='p_method_paypal_standard']");			
		} else {
			Assert.fail("Error:  No seleccionó el método de pago PAYPAL");
		}
		if(("off").equals(selenium.getValue("id=agreement-1"))) {
			selenium.click("id=agreement-1");						
		} else {
			Assert.fail("Error:  Se deben aceptar los términos y condiciones y las políticas de privacidad");
		}
		selenium.click("xpath=.//*[@id='checkout-buttons-container']/button");
		selenium.waitForPageToLoad("60000");
		
		//----**** Se confirma el pago en Paypal ----****\\
		
		//selenium.waitForPageToLoad("30000");		
		
		//----**** Se autentica el usuario en Paypal ****----\\
		
		if(!selenium.isElementPresent("xpath=.//*[@id='loadLogin']"))
		{
			Assert.fail(selenium.getLocation());
		}
		
		selenium.click("xpath=.//*[@id='loadLogin']");
		selenium.waitForPageToLoad("30000");
		
		selenium.type("xpath=.//*[@id='login_email']", "qualit_1337780842_per@privalia.com");
		selenium.type("xpath=.//*[@id='login_password']", "337780714");
		
		selenium.click("id=submitLogin");
		selenium.waitForPageToLoad("30000");
		// Se confirma el pago en Paypal \\
		selenium.click("id=continue");
		
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=.//*[@id='doneInfo']/ul/li[1]/a");
		
		selenium.waitForPageToLoad("30000");
		
		// Selenium Redireccion a la página de ClaireandBruce y confirma que el pedido se ha enviado  \\
		
		assertEquals(selenium.getText("xpath=//p"),"Recibirás un e-mail con tu confirmación de compra a:");
		Helper.log("PEDIDO REALIZADO!!");		
		if(!selenium.isElementPresent("//span[2]")||!selenium.isElementPresent("css=span.button"))
		{
			Assert.fail("Error no se encontro el pedido");
		}
	}
}