package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;
import lib.Claireandbruce;

import org.junit.Test;

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

	///prueba
	private CBT55_Test_CorrectLogon_ValidUser_TuCuenta cbt55;

	@Test
	public void CBT_Paypal() throws Exception{
	
		// ESTO SE PONE EN COMENTARIO PARA QUE CORRA EN EL FLUJO
		
		cbt55= new CBT55_Test_CorrectLogon_ValidUser_TuCuenta();
		
		/*selenium.deleteAllVisibleCookies();
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
	
		*/
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			cbt55.CBT55();// Se comenta para la prueba de flujo 
			
			//Assert.fail("El usuario no esta autenticado");
		}
		
		


		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("//a[contains(text(),'Compra ahora')]");
			
			selenium.waitForPageToLoad("15000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("15000");
			
		}
		
		
		//------*****  Verifica que el pedido será sin factura *****-------\\
		
		
		if(!("on").equals(selenium.getValue("id=p_method_paypal_standard")))
		{
			Assert.fail("Error:  No seleccionó el método de pago PAYPAL");
		}
		if(!("on").equals(selenium.getValue("id=agreement-1")))
		{
			Assert.fail("Error:  Se deben aceptar los términos y condiciones y las políticas de privacidad");
						
		}
		selenium.click("xpath=.//*[@id='checkout-buttons-container']/button");
		selenium.waitForPageToLoad("15000");
		
		selenium.close();
		
		
		selenium.deleteAllVisibleCookies();
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
	
		
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			Claireandbruce.login(selenium, username, password); // Se comenta para la prueba de flujo 
			
			//Assert.fail("El usuario no esta autenticado");
		}
		
		
		
	}
}
