package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;

import basics.ClaireandbruceTestCase;

/**
<<<<<<< HEAD
 * El informe de prueba permitira validar los campos de registro de usuario cuando desea efectuar una compra 
 * y no se presenta como usuario registrado.El exito de la prueba sera el correcto  registro del usuario en 
 * el sistema, los valores de los campos seran validos 
=======
 * Este Caso de  Prueba  verificará el  correcto funcionamiento del proceso  de  login de un usuario 
 * durante el  checkout,  al validar la  información ingresada por el usuario al momento de realizar
 * esta acción. El éxito del caso de prueba será la validación del campo contraseña ingresado y por consecuencia 
 * la posterior muestra del mensaje de advertencia sobre formato de contraseña no válido.
 * 
>>>>>>> parent of 7a14d68... Revert "Actualiza codigo casos nuevos"
 * 
 * @author 	Yuliana María Saavedra Russí
 *  		NEWSHORE 
 *
 */

public class TestUserRegisterCheckout1UserRegistrationValidField extends ClaireandbruceTestCase{

	@Test
	public void CBT18() throws Exception{

	
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
		 Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
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
			
			if(selenium.isElementPresent("xpath=.//*[@id='emailreg']")){
				int i =(int)(Math.random()*100);
				
				selenium.type("xpath=.//*[@id='emailreg']", "claireandbruce"+i+"@gmail.com");
				selenium.click("xpath=.//*[@id='send3']");
				selenium.waitForPageToLoad("30000");
				
				selenium.type("id=shipping:firstname", "Sandra Milena");
				selenium.type("id=shipping:lastname", "Torres Valencia");
				selenium.click("id=shipping:street1");
				selenium.type("id=shipping:street1", "Avenida Coruña 20 -"+i);
				selenium.type("id=shipping:city","Barcelona");
				selenium.click("css=div.selreplace_selectinner");
				selenium.click("//div[@value='139']");
				selenium.type("id=shipping:postcode", "80808"+i);
				selenium.type("id=shipping:telephone", "85827414"+i);
				selenium.type("id=firstname", "Claireandbruce");
				selenium.type("id=lastname", "qa");
				selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='3']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=//span/div[2]/div/div/div[24]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=//div[@value='1989']");
				selenium.type("id=email_address", "claireandbruceqa"+i+"@gmail.com");
				selenium.type("id=password", "123456");
				selenium.click("id=p_method_checkmo");
				selenium.click("id=agreement-1");
				selenium.click("xpath=(//button[@type='button'])[2]");
				selenium.waitForPageToLoad("30000");
				if(!("claireandbruceqa"+i+"@gmail.com").equals(selenium.getText("xpath=html/body/div[2]/div[2]/div[1]/div/div[2]/div[1]/div"))){
					Assert.fail("Error: No registro el usuario");
				}
			}else
			{
				Assert.fail("Error: No carga el formulario de registro");
			}
			
			
			
	

	}
}
