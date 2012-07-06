package claireandbruce.com.test.login.checkout;

import junit.framework.Assert;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibPayCreditCard;

import basics.ClaireandbruceTestCase;

/**
 * Este caso de prueba verificara la correcta validacion del sistema para los  campos de  nombre y  apellido
 * con valores diferentes a los correctos, el  exito del  caso  de prueba se  vera reflejado en los   avisos 
 * mostrados por el sistema para rechazar el registro.
 * Este Caso de  Prueba  verificará el  correcto funcionamiento del proceso  de  login de un usuario durante
 * el  checkout,  al validar la  información ingresada por el usuario al momento de realizar   esta  acción. 
 * El éxito del  caso  de prueba  será la validación   del  campo  contraseña  ingresado y  por consecuencia 
 * la posterior muestra del mensaje de advertencia sobre formato de contraseña no válido.
 * 
 * @author 	NEWSHORE 
 * Testlink: Local CBT20  - Privalia CBT44
 */

public class TestUserRegisterCheckoutUserRegistrationValidFieldString extends ClaireandbruceTestCase{

	@Test
	public void cbt44() throws Exception{

		Helper.log("Se inicia proceso de registro por checkout con contraseña no válida");
		// Elimina las cookies
		Helper.log("Se eliminan cookies del navegador");
		selenium.deleteAllVisibleCookies();
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open(ClaireandbruceUrl);

		selenium.waitForPageToLoad("50000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		// Verifica que el usuario no este logueado
		if(selenium.isElementPresent("link=Salir")) {
			Helper.log("Se presenta usuario con sesión iniciada al cargar la página de C+B");
			selenium.click("link=Salir");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				Helper.log("Se regresa a Homepage");
				selenium.click("xpath=//img");
				selenium.waitForPageToLoad("15000");
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
			Helper.log("Se ingresa el correo electrónico para el registro por checkout");
			if(selenium.isElementPresent("xpath=.//*[@id='emailreg']")){
				int i =(int)(Math.random()*100);
				
				selenium.type("xpath=.//*[@id='emailreg']", "claireandbruceqa"+i+"@gmail.com");
				Helper.log("Se hace clic en el botón 'Registrarme'");
				selenium.click("xpath=.//*[@id='send3']");
				selenium.waitForPageToLoad("35000");

				Helper.log("Se ingresan campos vacíos en la información del usuario");
				selenium.type("id=shipping:firstname", "");
				selenium.type("id=shipping:lastname", "");
				selenium.click("id=shipping:street1");
				selenium.type("id=shipping:street1", "");
				selenium.type("id=shipping:city","");
				selenium.click("css=div.selreplace_selectinner");
				selenium.type("id=shipping:postcode", "");
				selenium.type("id=shipping:telephone", "");
				selenium.type("id=firstname", "");
				selenium.type("id=lastname", "");
				selenium.type("id=email_address", "");
				selenium.type("id=password", "");
				Helper.log("Se hace clic en 'PAGAR'");
				selenium.click("xpath=(//button[@type='button'])[2]");
				Helper.log("Se inicia validación de mensajes de advertencia sobre campos obligatorios");
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
				
				if(selenium.isTextPresent("Check/Money")){
					if (!"Seleccione una de las opciones.".equals(selenium.getText("xpath=.//*[@id='advice-validate-one-required-by-name-p_method_checkmo']"))) {
						Assert.fail("No seleccionó método de pago, no se muestra mensaje de advertencia sobre el Cheque");
					}
				}	
				
				if(!selenium.isElementPresent("id=advice-required-entry-confirmation")){
					Assert.fail("Se deben aceptar los terminos y condiciones del servicio");
				}

				// Validación del formulario para datos no validos
				
				Helper.log("Se ingresan datos no válidos (númericos) en los campos");
				selenium.type("id=shipping:firstname", "1234"); //Nombre de envío
				
				selenium.type("id=shipping:lastname", "1234");// Apellido de envío
		
				selenium.type("id=shipping:telephone", "Yrdytrdf"); // Campo teléfono
				
				selenium.type("id=firstname", "12551");// Nombre de Registro de Usuario
				
				selenium.type("id=lastname", "1554142"); // Apellido de Registro de Usuario
				
				selenium.type("id=password", "32323");// Campo Contraseña
				Helper.log("Se inicia validación de mensajes de advertencia sobre formato no válido");
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:firstname")){
					Assert.fail("Formato no válido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:lastname")){
					Assert.fail("Formato no válido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-phone-shipping:telephone"))
				{
					Assert.fail("Formato no válido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-firstname")){
					Assert.fail("El campo nombre de registro usuario es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-lastname")){
					Assert.fail("El campo apellido de registro usuario es obligatorio");
				}
				Helper.log("Se ingresan caracteres especiales en los campos");
				selenium.type("id=shipping:firstname", "%$·$·"); //Nombre de envío
				
				selenium.type("id=shipping:lastname", "·$$&%$$");// Apellido de envío
		
				selenium.type("id=shipping:telephone", "$%&#@"); // Campo teléfono
				
				selenium.type("id=firstname", "$%&#@");// Nombre de Registro de Usuario
				
				selenium.type("id=lastname", "$%&#@"); // Apellido de Registro de Usuario
				
				Helper.log("Se validan los mensajes de advertencia sobre formato no Válido");
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:firstname")){
					Assert.fail("Formato no válido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-shipping:lastname")){
					Assert.fail("Formato no válido para el campo");
				}
				if(!selenium.isElementPresent("id=advice-validate-phone-shipping:telephone"))
				{
					Assert.fail("Formato no válido para el campo");;
				}
				if(!selenium.isElementPresent("id=advice-validate-name-firstname")){
					Assert.fail("El campo nombre de registro usuario es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-validate-name-lastname")){
					Assert.fail("El campo apellido de registro usuario es obligatorio");
				}

				Helper.log("Se ingresan datos válidos para finalizar el proceso de compra");
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
				Helper.log("Se selecciona fecha de nacimiento");
				selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='3']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=//span/div[2]/div/div/div[24]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=//div[@value='1989']");
				selenium.type("id=email_address", "claireandbruceqa"+i+"@gmail.com");
				selenium.type("id=password", "123456");
				Helper.log("Se selecciona método de pago: Cheque");
				LibPayCreditCard.credit_Card(selenium);
			}else
			{
				Assert.fail("Error: No carga el formulario de registro");
			}
			
			// Validación del formulario para datos númericos en campos nombre de envío, apellido de envío, 
			
	}
}
