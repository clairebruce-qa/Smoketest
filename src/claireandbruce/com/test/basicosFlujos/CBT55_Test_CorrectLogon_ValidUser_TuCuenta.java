package claireandbruce.com.test.basicosFlujos;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import junit.framework.Assert;
import lib.*;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificará el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la información ingresada por el usuario al momento de realizar esta 
 * acción y/o al presionar el botón “ENTRAR”. El éxito del caso de prueba será la verificación del 
 * usuario en el sistema y la redirección de este al "AREA PRIVADA" de "Tu cuenta"
 * @author MARIA FERNANDA RODRIGUEZ VARGAS
 *
 */
public class CBT55_Test_CorrectLogon_ValidUser_TuCuenta extends ClaireandbruceTestCase {

	@Test
	public void CBT55() throws Exception {
		String mensaje = null;
		
		// Elimina las cookies
		selenium.deleteAllVisibleCookies();
		
		selenium.open("");

		selenium.waitForPageToLoad("15000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		
		 if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			 
				selenium.click("//a[contains(text(), 'Salir')]");
				selenium.waitForPageToLoad("30000");
				if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")) {
					Helper.log("Logout done!");
				} else {
					Helper.log("NO Logout!");
				}
		  }
		  
			//R2
			String message = null;
			Helper.log("Open Homepage");
			
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {
					
				
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("30000");
				//check Autenticacion con cuenta is on the page
				//Helper.waitForElement(selenium, "//a[contains(text(), 'Tu cuenta')]", "Inicio de sesion  not found in "+ selenium.getLocation());
		/*
				if(selenium.isTextPresent("Existe un problema con el certificado de seguridad de este sitio web."))
				{
				
					selenium.click("//a[contains(text(), 'Vaya a este sitio web (no recomendado).')]");
					selenium.waitForPageToLoad("40000");
					
					//if(selenium.isElementPresent("//*[contains(text(), 'Mostrar contenido')]")|| selenium.isElementPresent("//*[contains(text(), 'Mostrar todo el  contenido')]"))
					selenium.click("//*@button[contains(text(), 'Mostrar contenido')]");
					selenium.waitForPageToLoad("30000");
					selenium.click("//*[contains(text(), 'Mostrar todo el contenido')]");
					selenium.waitForPageToLoad("30000");
				}
				else
				{
					Assert.fail("Error: excepción de seguridad, contenido bloqueado");
				}
			*/		
			}
			
			
			selenium.type("xpath=.//*[@id='email']", username);
			selenium.type("xpath=.//*[@id='pass']", password);		
			selenium.click("//button[contains(@id,'send2')]");	
			selenium.waitForPageToLoad("20000");
			
			if (!selenium.isElementPresent( "class=validation-advice")){
		
				if (selenium.isTextPresent("Salir")){
					message = "loginOk";
				}else if (selenium.isElementPresent("//div[@id='error-message-login']")){
					message = "Fail";
				}
			}
			
			if(message == null){
				Helper.log("Login Error " + selenium.getLocation());
				//Assert.fail("Login Error " + selenium.getLocation());
			}
		
		
		//Se comprueba en caso tal de que el usuario no se encuentre creado.
		if(selenium.isTextPresent("Usuario o contraseña inválido")) {
			assertEquals(username, selenium.getValue("id=emailreg"));
		}
		
		Helper.log("Login the user "+ username + " with password " + password);

		if (selenium.isElementPresent("class=user") && selenium.isElementPresent("class=welcome-user-register")){
			mensaje = "loginOk";
		}else if (selenium.isElementPresent("//div[@id='error-message-login']")){
			mensaje = selenium.getText("ferrorLogin");
		}
		
		if(mensaje == null){
			Helper.log("Login Error " + selenium.getLocation());
			Assert.fail("Login Error " + selenium.getLocation());
		}
		Helper.log("Login message is "+mensaje);
	
	}
	
	//	SE PONE EN COMENTARIO PARA CORRER EN EL FLUJO
	// 	PARA PRUEBAS UNITARIAS SE ACTIVA
	/*
	@After
	public void afterTest(){
		selenium.stop();
	}*/
}
