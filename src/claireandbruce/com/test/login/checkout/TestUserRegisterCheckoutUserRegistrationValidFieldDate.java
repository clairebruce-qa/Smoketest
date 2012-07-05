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
				selenium.waitForPageToLoad("30000");
			
				
				//selenium.click("xpath=(//button[@type='button'])[2]");
				//selenium.waitForPageToLoad("30000");
				// Se validan la fecha, si no existe una selección para valores vacíos
				
				
				/*if(("02".equals(selenium.getText("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectinner")))// Combo de selección de fecha de nacimiento
						&& ("01".equals(selenium.getText("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectinner")))
						&& ("2012".equals(selenium.getText("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectinner")))){
					
					Assert.fail("El usuario debe seleccionar una fecha de nacimiento válida");
							
							
				}*/
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
				/*if(!selenium.isElementPresent("id=advice-required-entry-shipping:firstname")){
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

				// Validación del formulario para datos no validos
				
				selenium.type("id=shipping:firstname", "1234"); //Nombre de envío
				
				selenium.type("id=shipping:lastname", "1234");// Apellido de envío
		
				//selenium.type("id=shipping:city", "1235415"); // Campo población
				//selenium.type("id=shipping:postcode", "YEDGY");//Campo código postal
				selenium.type("id=shipping:telephone", "Yrdytrdf"); // Campo teléfono
				
				selenium.type("id=firstname", "12551");// Nombre de Registro de Usuario
				
				selenium.type("id=lastname", "1554142"); // Apellido de Registro de Usuario
				
				selenium.type("id=password", "32323");// Campo Contraseña
				
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:firstname")){
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:lastname")){
					Assert.fail("formato no valido para el campo");
				}
				/*if(!selenium.isElementPresent("id=advice-validate-shipping:city")){
					Assert.fail("formato no valido para el campo");
				}
				/*if(!selenium.isElementPresent("id=advice-validate-select-shipping:region_id"))
				{
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:postcode"))
				{
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-phone-shipping:telephone"))
				{
					Assert.fail("formato no valido para el campo");;
				}
				if(!selenium.isElementPresent("id=advice-validate-name-firstname")){
					Assert.fail("El campo nombre de registro usuario es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-lastname")){
					Assert.fail("El campo apellido de registro usuario es obligatorio");
				}
				
				selenium.type("id=shipping:firstname", "%$·$·"); //Nombre de envío
				
				selenium.type("id=shipping:lastname", "·$$&%$$");// Apellido de envío
		
				//selenium.type("id=shipping:city", "1235415"); // Campo población
				//selenium.type("id=shipping:postcode", "YEDGY");//Campo código postal
				selenium.type("id=shipping:telephone", "$%&#@"); // Campo teléfono
				
				selenium.type("id=firstname", "$%&#@");// Nombre de Registro de Usuario
				
				selenium.type("id=lastname", "$%&#@"); // Apellido de Registro de Usuario
				
				
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:firstname")){
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:lastname")){
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-shipping:city")){
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-select-shipping:region_id"))
				{
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:postcode"))
				{
					Assert.fail("formato no valido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-phone-shipping:telephone"))
				{
					Assert.fail("formato no valido para el campo");;
				}
				if(!selenium.isElementPresent("id=advice-validate-name-firstname")){
					Assert.fail("El campo nombre de registro usuario es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-lastname")){
					Assert.fail("El campo apellido de registro usuario es obligatorio");
				}*/
				
			}else
			{
				Assert.fail("Error: No carga el formulario de registro");
			}
			

			

			
	

	}
}
