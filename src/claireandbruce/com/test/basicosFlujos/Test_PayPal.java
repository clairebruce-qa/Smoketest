package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;
import lib.Claireandbruce;

import org.junit.Test;

import basics.ClaireandbruceTestCase;


/**
 * TestCase que verif�ca que el pago ser� efectuado por Paypal.
 * 
 * 
 * 
 * @author YULIANA MAR�A SAAVEDRA RUSS�
 *
 */
public class Test_PayPal extends ClaireandbruceTestCase {

	///prueba
	private CBT55_Test_CorrectLogon_ValidUser_TuCuenta cbt55;
	private Test_CorrectAddProduct_Cart_SimpleProduct cbtPS;
	/**
	 * 
	 * @param nombreProducto
	 * @throws Exception
	 */
	
	@Test
	public void CBT_Paypal() throws Exception{
	
		// ESTO SE PONE EN COMENTARIO PARA QUE CORRA EN EL FLUJO
		
		cbt55= new CBT55_Test_CorrectLogon_ValidUser_TuCuenta();
		cbtPS= new Test_CorrectAddProduct_Cart_SimpleProduct();
		/*selenium.deleteAllVisibleCookies();
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
	
		*/
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			cbt55.CBT55();// Se comenta para la prueba de flujo 
			cbtPS.CBT_SimpleProduct();//Carga un producto simple
			//Assert.fail("El usuario no esta autenticado");
		}
		
		


		//-----****** Verif�ca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
			
			selenium.waitForPageToLoad("15000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("20000");
			
		}
		
		
		//------*****  Verifica que el pedido ser� sin factura *****-------\\
		
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
			
			selenium.waitForPageToLoad("15000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("15000");
			
		}
		if(("off").equals(selenium.getValue("xpath=.//*[@id='p_method_paypal_standard']")))
		{
			selenium.click("xpath=.//*[@id='p_method_paypal_standard']");
			
		}
		else
		{
			Assert.fail("Error:  No seleccion� el m�todo de pago PAYPAL");
		}
		if(("off").equals(selenium.getValue("id=agreement-1")))
		{
			selenium.click("id=agreement-1");
						
		}
		else
		{
			Assert.fail("Error:  Se deben aceptar los t�rminos y condiciones y las pol�ticas de privacidad");
		}
		selenium.click("xpath=.//*[@id='checkout-buttons-container']/button");
		selenium.waitForPageToLoad("15000");
		selenium.close();
		
		cbt55.CBT55();// Se comenta para la prueba de flujo 
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/a/div/div");
		selenium.waitForPageToLoad("15000");
		String check= selenium.getText("html/body/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]");
	//if(!(check).equals(selenium.isTextPresent(""))){
			
			
			
		//	Assert.fail("El pedido no fue efectuado");
		//}
		
		
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