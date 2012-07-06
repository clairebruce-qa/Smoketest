package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;

import basics.ClaireandbruceTestCase;

/**
 *Se comprobara la correcta validacion de la fecha de nacimiento por parte del sistema, 
 *el éxito del caso de prueba se vera evidenciado en las notificaciones o avisos que el 
 *sistema despliegue al usuario para el correcto ingreso de la fecha de nacimiento.
 *
 * 
 * @author 	NEWSHORE 
 * Testlink: Local CBT21  - Privalia CBT47
 */

public class TestUserRegisterCheckoutUserRegistrationValidFieldDate extends ClaireandbruceTestCase{

	@Test
	public void cbt47() throws Exception{

		Helper.log("Se inicia proceso de registro con fecha de nacimiento no válida");
		Helper.log("Se eliminan las cookies");
		// Elimina las cookies
		selenium.deleteAllVisibleCookies();
		Helper.log("Se ingresa a la página "+ClaireandbruceUrl);
		selenium.open(ClaireandbruceUrl);

		selenium.waitForPageToLoad("50000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		// Verifica que el usuario no este logueado
		 if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			 Helper.log("Se presenta usuario con sesión iniciada al cargar la página de C+B");
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
			 Helper.log("Se ingresa a la página 'Cesta de la Compra' para posteriormente ingresar a 'Compra ahora'");
				selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
				
				selenium.waitForPageToLoad("15000");
				Helper.log("Se hace clic en el botón 'CONTINUA' para el ingreso a 'Compra ahora'");
				selenium.click("xpath=(//button[@type='button'])[3]");
				selenium.waitForPageToLoad("30000");			
			}		
			
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {			
				Helper.log("No se encuentra formulario para el registro de usuario en checkout");
				
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("30000");			
			}
			
			// ---***Se ingresan los datos de e-mail para el registro por check-out ***---\\
			
			if(selenium.isElementPresent("xpath=.//*[@id='emailreg']")){
				int i =(int)(Math.random()*100);
				Helper.log("Se ingresa el correo electrónico para el registro por checkout");
				
				selenium.type("xpath=.//*[@id='emailreg']", "claireandbruce"+i+"@gmail.com");
				Helper.log("Se hace clic en el botón 'Registrarme'");
				selenium.click("xpath=.//*[@id='send3']");
				selenium.waitForPageToLoad("35000");			
				
				Helper.log("Se ingresa la fecha 31-12-2012");
				
				selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='31']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=(//div[@value='12'])[2]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectinner");
				selenium.click("//div[@value='2012']");
				Helper.log("Se hace clic en 'PAGAR'");
				
				selenium.click("xpath=(//button[@type='button'])[2]");
				if(("31".equals(selenium.getText("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectinner")))// Combo de selección de fecha de nacimiento
						&& ("12".equals(selenium.getText("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectinner")))
						&& ("2012".equals(selenium.getText("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectinner")))){
					
				Assert.fail("El usuario debe seleccionar una fecha de nacimiento válida");							
							
				}								
			}else
			{
				Assert.fail("Error: No carga el formulario de registro");
			}
	}
}