package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;


/**
 * TestCase que verifíca que el pago será efectuado por Paypal.
 * 
 * 
 * 
 * @author YULIANA MARÍA SAAVEDRA RUSSÍ
 *
 */
public class Test_PayPal extends ClaireandbruceTestCase {

	/**
	 * 
	 * @param nombreProducto
	 * @throws Exception
	 */
	
	public static void CBT_Paypal(Selenium selenium, String nombreProducto) throws Exception{
	
		// ESTO SE PONE EN COMENTARIO PARA QUE CORRA EN EL FLUJO
		
		//cbt55= new CBT55_Test_CorrectLogon_ValidUser_TuCuenta();
		//cbtPS= new Test_CorrectAddProduct_Cart_SimpleProduct();
		//selenium.deleteAllVisibleCookies();
		//selenium.open(ClaireandbruceUrl);
		//selenium.waitForPageToLoad("15000");
		
		/*if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
	
		*/
		//if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
		//	CBT55_Test_CorrectLogon_ValidUser_TuCuenta.CBT55(selenium);// Se comenta para la prueba de flujo			
		//}	

		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
			
			selenium.waitForPageToLoad("15000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("20000");			
		}		
		
		
		if(("off").equals(selenium.getValue("name=shipping_address_id"))){	
			Test_Address_Exist.CBT_Address(selenium);
			//Test_Without_Purchase.CBT_WPurchase(selenium);
		}
		
		if(("on").equals(selenium.getValue("id=showFakeBilling"))){	
			Test_Address_Exist.CBT_Address(selenium);
			
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
		selenium.waitForPageToLoad("15000");
		
	
		//Se verifica si el pedido esta ingresado en el historial
	
		
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/a/div/div"))
		{	
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/a/div/div");
			selenium.waitForPageToLoad("15000");
			String check= selenium.getText("html/body/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]");
		
			if(!(check).equals(selenium.isTextPresent(nombreProducto))){			
				Assert.fail("El pedido no fue efectuado");
			}
		}
		else
			{
			Assert.fail("El pedido no fue efectuado");
		}
		
		

		/*		
		selenium.click("xpath=.//*[@id='main']/div/p[2]/strong/a");
		selenium.click("xpath=.//*[@id='loadLogin']");
		selenium.type("xpath=.//*[@id='login_email']", "qualit_1337780842_per@privalia.com");
		selenium.type("xpath=.//*[@id='login_password']", "337780714");
		selenium.click("xpath=.//*[@id='nav-menu']/form/ul[1]/li/ul/li[6]/input");	
	
		if(selenium.isTextPresent("The email address or password you have entered does not match our records. Please try again."))
		{
			Assert.fail("Error:  NO AUTENTICO EL USUARIO DE PAYPAL");
		}
		*/		

	}
}
