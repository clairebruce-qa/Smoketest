package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;

import basics.ClaireandbruceTestCase;

/**
 * Este Caso de  Prueba  verificará el  correcto funcionamiento del proceso  de  login de un usuario 
 * durante el  checkout,  al validar la  información ingresada por el usuario al momento de realizar
 * esta acción. El éxito del caso de prueba será la validación del campo contraseña =vacío  y por consecuencia 
 * la posterior muestra del mensaje de advertencia sobre formato de contraseña no válido.
 * CBT75
 * @author 	NEWSHORE 
 *
 */

public class TestIncorrectLogonInvalidPasswordEmptyCheckout extends ClaireandbruceTestCase{

	@Test
	public void CBT75() throws Exception{

		
		// Elimina las cookies
		selenium.deleteAllVisibleCookies();
		
		selenium.open(ClaireandbruceUrl);

		selenium.waitForPageToLoad("50000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		// Verifica que el usuario no este logueado
		 if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			 
				selenium.click("//a[contains(text(), 'Salir')]");
				selenium.waitForPageToLoad("30000");
				if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")) {
					Helper.log("Logout done!");
				} else {
					Helper.log("NO Logout!");
				}
		  }
		  
		 
		 // Se agrega el producto al carrito de compras 
		 LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
			//R2
		 if(!("Compra ahora").equals(selenium.getTitle()))
			{
				selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
				
				selenium.waitForPageToLoad("15000");
				selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
				selenium.waitForPageToLoad("30000");			
			}		
			
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {			
				
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("30000");			
			}
			
			// ---***Se ingresan los datos de e-mail para el logueo por check-out ***---\\
			
			
			selenium.type("xpath=.//*[@id='email']", "claireandbruce@gmail.com");
			selenium.type("xpath=.//*[@id='pass']", "");		
			selenium.click("//button[contains(@id,'send2')]");	
			
			if (!selenium.isElementPresent( "class=validation-advice")){		
				
					Assert.fail("Error: el formato de correo no es válido");
			}
			
	

	}
}
