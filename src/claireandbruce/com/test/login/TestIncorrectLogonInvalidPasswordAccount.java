package claireandbruce.com.test.login;

import lib.Helper;
import org.junit.Assert;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificará el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la información ingresada por el usuario al momento de realizar esta 
 * acción y/o al presionar el botón “ENTRAR”. El éxito del caso de prueba será la validación del 
 * email ingresado y por consecuencia la posterior muestra del mensaje de advertencia sobre formato 
 * de email no válido
 * @author NEWSHORE
 * CBT57
 */

public class TestIncorrectLogonInvalidPasswordAccount extends ClaireandbruceTestCase{
	
	@Test
	public void CBT57() throws Exception {
			
		selenium.deleteAllVisibleCookies();
		Helper.log("Se eliminan cookies");
		Helper.log("Se abre la interfaz "+ClaireandbruceUrl);
		selenium.open(ClaireandbruceUrl);
		Helper.log("Se inicia proceso de login en C+B");
		
		selenium.waitForPageToLoad("50000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		
		 if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			 Helper.log("Se ha encontrado una sesión iniciada al abrir la página C+B");
				selenium.click("//a[contains(text(), 'Salir')]");
				selenium.waitForPageToLoad("60000");
				if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")) {
					Helper.log("Logout done!");
				} else {
					Helper.log("NO Logout!");
				}
		  }
		  
			Helper.log("Open Homepage");
			Helper.log("Se verifica que se encuentre presente el formulario para ingreso de datos de usuario para login");
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {			
				Helper.log("No se ha encontrado el formulario por lo cual se ingresa al link 'Tu cuenta'");
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("60000");			
			}
			
			Helper.log("Se ingresan los datos de usuario para el proceso de login (Password no válida)");
			//Formulario para autenticar usuario
			selenium.type("xpath=.//*[@id='email']", username);
			selenium.type("xpath=.//*[@id='pass']", "125478");		
			Helper.log("Se hace clic en el botón 'ENTRAR'");
			selenium.click("//button[contains(@id,'send2')]");	
			selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Usuario o contraseña inválidos.")){
			Helper.log("OK. Se encuentra el mensaje de advertencia 'Usuario o contraseña inválidos.'");
		}else {
			Assert.fail("No se encuentra el mensaje de advertencia 'Usuario o contraseña inválidos.'");
			Helper.log("KO. No se encuentra el mensaje de advertencia 'Usuario o contraseña inválidos.'");
		}
			
	}	
}