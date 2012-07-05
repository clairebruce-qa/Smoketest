package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;

import basics.ClaireandbruceTestCase;

/**
 * Este Caso de  Prueba  verificará el  correcto funcionamiento del proceso  de  login de un usuario 
 * durante el  checkout,  al validar la  información ingresada por el usuario al momento de realizar
 * esta acción. El éxito del caso de prueba será la validación del campo contraseña ingresado y por consecuencia 
 * la posterior muestra del mensaje de advertencia sobre formato de contraseña no válido.
 * Testlink: Local CBT74  - Privalia CBT27
 * @author 	NEWSHORE 
 *
 */

public class TestIncorrectLogonInvalidPasswordSpaceCheckout extends ClaireandbruceTestCase{

	@Test
	public void cbt27() throws Exception{

		
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
			Helper.log("Se busca método de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'CÓMPRALO AHORA' del header");
				if(!selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
					selenium.click("id=cartHeader");
				}
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el botón 'CÓMPRALO AHORA' del header");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el botón 'COMPRA AHORA' ubicado en la parte superior de la página");			
			}
			selenium.waitForPageToLoad("30000");
			Helper.log("Se presiona el botón 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");				
		}		
			
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {			
				
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("30000");			
			}
			
			// ---***Se ingresan los datos de e-mail para el logueo por check-out ***---\\
			
			
			selenium.type("xpath=.//*[@id='email']", "claireandbruce@gmail.com");
			selenium.type("xpath=.//*[@id='pass']", " ");		
			selenium.click("//button[contains(@id,'send2')]");	
			
			if (!selenium.isElementPresent( "class=validation-advice")){		
				
					Assert.fail("Error: el formato de correo no es válido");
			}
			
	

	}
}
