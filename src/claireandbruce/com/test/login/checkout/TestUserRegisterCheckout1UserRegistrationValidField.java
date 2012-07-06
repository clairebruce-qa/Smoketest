package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibPayCreditCard;

import basics.ClaireandbruceTestCase;

/**
 * 
 * @author 	NEWSHORE 
 * Testlink: Local CBT18 -  Privalia CBT35
 */

public class TestUserRegisterCheckout1UserRegistrationValidField extends ClaireandbruceTestCase{

	@Test
	public void cbt35() throws Exception{
 
		Helper.log("Se inicia proceso de registro con datos válidos por checkout");
		// Elimina las cookies
		Helper.log("Se eliminan cookies");
		selenium.deleteAllVisibleCookies();
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open(ClaireandbruceUrl);

		selenium.waitForPageToLoad("50000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		// Verifica que el usuario no este logueado
		 if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			 Helper.log("Se encuentra una sesión de usuario iniciada al cargar la página de C+B");
				selenium.click("//a[contains(text(), 'Salir')]");
				Helper.log("Se hace clic en 'Salir'");
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
			 Helper.log("Se ingresa a la interfaz 'Cesta de la Compra' para cargar posteriormente la interfaz 'Compra ahora'");
				selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
				
				selenium.waitForPageToLoad("15000");
				Helper.log("Se hace clic en el botón 'CONTINUA' para cargar la interfaz 'Compra ahora'");
				selenium.click("xpath=(//button[@type='button'])[3]");
				selenium.waitForPageToLoad("30000");			
			}		
			
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {			
				Helper.log("No se encontró el campo para ingresar el correo electrónico para realizar el registro de usuario");
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("30000");			
			}
			
			// ---***Se ingresan los datos de e-mail para el logueo por check-out ***---\\
			
			if(selenium.isElementPresent("xpath=.//*[@id='emailreg']")){
				int i =(int)(Math.random()*1000);
				Helper.log("Se ingresa el correo electrónico con el que se realizará el registro de usuario");
				selenium.type("xpath=.//*[@id='emailreg']", "claireandbruce"+i+"@gmail.com");
				Helper.log("Se hace clic en el botón 'Registrarme'");
				selenium.click("xpath=.//*[@id='send3']");
				Helper.log("Se espera carga de interfaz con campos para el registro de usuario");
				selenium.waitForPageToLoad("35000");
				Helper.log("Se ingresan los datos del usuario a registrar");
				selenium.type("id=shipping:firstname", "Sandra Milena");
				selenium.type("id=shipping:lastname", "Torres Valencia");
				selenium.click("id=shipping:street1");
				selenium.type("id=shipping:street1", "Avenida Coruña 20 -"+i);
				selenium.type("id=shipping:city","Barcelona");
				Helper.log("Se selecciona la Provincia");
				selenium.click("css=div.selreplace_selectinner");
				selenium.click("//div[@value='139']");
				selenium.type("id=shipping:postcode", "80808"+i);
				selenium.type("id=shipping:telephone", "85827414"+i);
				Helper.log("Se ingresan los datos de usuario en la sección 'SOBRE TI'");
				selenium.type("id=firstname", "Claireandbruce");
				selenium.type("id=lastname", "qa");
				Helper.log("Se selecciona la fecha de nacimiento");
				selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='3']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=//span/div[2]/div/div/div[24]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=//div[@value='1989']");
				selenium.type("id=email_address", "claireandbruceqa"+i+"@gmail.com");
				selenium.type("id=password", "123456");
				Helper.log("Se selecciona pago con Tarjeta");
				LibPayCreditCard.credit_Card(selenium);				
			}else
			{
				Assert.fail("Error: No carga el formulario de registro");
			}
			
			
			
	

	}
}
