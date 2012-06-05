package claireandbruce.com.test.login.checkout;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;

import basics.ClaireandbruceTestCase;

/**

 * Este caso de prueba verificara la correcta validacion del sistema para los campos de nombre y apellido
 * con valores diferentes a los correctos, el  exito del  caso  de prueba se vera reflejado en los avisos 
 * mostrados por el sistema para rechazar el registro.
 * Este Caso de  Prueba  verificar� el  correcto funcionamiento del proceso  de  login de un usuario durante
 * el  checkout,  al validar la  informaci�n ingresada por el usuario al momento de realizar
 * esta acci�n. El �xito del caso de prueba ser� la validaci�n del campo contrase�a ingresado y por consecuencia 
 * la posterior muestra del mensaje de advertencia sobre formato de contrase�a no v�lido.
 * 
 * 
 * @author 	Yuliana Mar�a Saavedra Russ�
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
				
				// Se validan los campos para valores vac�os
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:firstname")){
					Assert.fail("El campo nombre  de env�o es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:lastname")){
					Assert.fail("El campo apellido de env�o es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:city")){
					Assert.fail("El campo ciudad es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-validate-select-shipping:region_id"))
				{
					Assert.fail("El campo poblaci�n es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:postcode"))
				{
					Assert.fail("El campo c�digo postal es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-shipping:telephone"))
				{
					Assert.fail("El campo tel�fono es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-firstname")){
					Assert.fail("El campo nombre de registro usuario es obligatorio");
				}
				if(!selenium.isElementPresent("id=advice-required-entry-lastname")){
					Assert.fail("El campo apellido de registro usuario es obligatorio");
				}
				
				if(!selenium.isElementPresent("id=advice-validate-one-required-by-name-p_method_checkmo") || !(selenium.isElementPresent("id=advice-validate-one-required-by-name-p_method_sermepa"))){
					Assert.fail("Seleccione uno de los m�todos de pago");
				}
				
				if(!selenium.isElementPresent("id=advice-required-entry-confirmation")){
					Assert.fail("Se deben aceptar los terminos y condiciones del servicio");
				}

				// Validaci�n del formulario para datos no validos
				
				selenium.type("id=shipping:firstname", "1234"); //Nombre de env�o
				
				selenium.type("id=shipping:lastname", "1234");// Apellido de env�o
		
				//selenium.type("id=shipping:city", "1235415"); // Campo poblaci�n
				//selenium.type("id=shipping:postcode", "YEDGY");//Campo c�digo postal
				selenium.type("id=shipping:telephone", "Yrdytrdf"); // Campo tel�fono
				
				selenium.type("id=firstname", "12551");// Nombre de Registro de Usuario
				
				selenium.type("id=lastname", "1554142"); // Apellido de Registro de Usuario
				
				selenium.type("id=password", "32323");// Campo Contrase�a
				
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
				}*/
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
				
				selenium.type("id=shipping:firstname", "%$�$�"); //Nombre de env�o
				
				selenium.type("id=shipping:lastname", "�$$&%$$");// Apellido de env�o
		
				//selenium.type("id=shipping:city", "1235415"); // Campo poblaci�n
				//selenium.type("id=shipping:postcode", "YEDGY");//Campo c�digo postal
				selenium.type("id=shipping:telephone", "$%&#@"); // Campo tel�fono
				
				selenium.type("id=firstname", "$%&#@");// Nombre de Registro de Usuario
				
				selenium.type("id=lastname", "$%&#@"); // Apellido de Registro de Usuario
				
				
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
				}*/
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
				
			}else
			{
				Assert.fail("Error: No carga el formulario de registro");
			}
			

			

			
	

	}
}
