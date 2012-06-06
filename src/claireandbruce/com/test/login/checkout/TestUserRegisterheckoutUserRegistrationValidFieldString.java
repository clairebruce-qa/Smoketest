package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;

import basics.ClaireandbruceTestCase;

/**
<<<<<<< HEAD
 * Este caso de prueba verificara la correcta validacion del sistema para los campos de nombre y apellido
 * con valores diferentes a los correctos, el  exito del  caso  de prueba se vera reflejado en los avisos 
 * mostrados por el sistema para rechazar el registro.
=======
 * Este Caso de  Prueba  verificará el  correcto funcionamiento del proceso  de  login de un usuario 
 * durante el  checkout,  al validar la  información ingresada por el usuario al momento de realizar
 * esta acción. El éxito del caso de prueba será la validación del campo contraseña ingresado y por consecuencia 
 * la posterior muestra del mensaje de advertencia sobre formato de contraseña no válido.
>>>>>>> parent of 7a14d68... Revert "Actualiza codigo casos nuevos"
 * 
 * 
 * @author 	Yuliana María Saavedra Russí
 *  		NEWSHORE 
 *
 */

public class TestUserRegisterheckoutUserRegistrationValidFieldString extends ClaireandbruceTestCase{

	@Test
	public void CBT20() throws Exception{

	
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
				

				selenium.type("id=shipping:firstname", "");
				selenium.type("id=shipping:lastname", "");
				selenium.click("id=shipping:street1");
				selenium.type("id=shipping:street1", "");
				selenium.type("id=shipping:city","");
				selenium.click("css=div.selreplace_selectinner");
				//selenium.click("//div[@value='139']");
				selenium.type("id=shipping:postcode", "");
				selenium.type("id=shipping:telephone", "");
				selenium.type("id=firstname", "");
				selenium.type("id=lastname", "");
				selenium.type("id=email_address", "");
				selenium.type("id=password", "");
				selenium.click("xpath=(//button[@type='button'])[2]");
				
				// Se validan los campos para valores vacíos
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:firstname")){
					Assert.fail("El campo nombre  de envío es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:lastname")){
					Assert.fail("El campo apellido de envío es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:city")){
					Assert.fail("El campo ciudad es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-validate-select-shipping:region_id"))
				{
					Assert.fail("El campo población es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:postcode"))
				{
					Assert.fail("El campo código postal es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:telephone"))
				{
					Assert.fail("El campo teléfono es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-firstname")){
					Assert.fail("El campo nombre de registro usuario es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-lastname")){
					Assert.fail("El campo apellido de registro usuario es obligatorio");
				}
				
				if(!selenium.isElementPresent("id=advice-validate-one-required-by-name-p_method_checkmo") || !(selenium.isElementPresent("id=advice-validate-one-required-by-name-p_method_sermepa"))){
					Assert.fail("Seleccione uno de los métodos de pago");
				}
				
				if(!selenium.isElementPresent("id=advice-required-entry-confirmation")){
					Assert.fail("Se deben aceptar los terminos y condiciones del servicio");
				}
				

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
			
			

			// Validación del formulario para datos númericos en campos nombre de envío, apellido de envío, 
			
			
	

	}
}
