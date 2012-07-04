package claireandbruce.com.test.login;

import lib.Helper;
import org.junit.Assert;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificar� el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la informaci�n ingresada por el usuario al momento de realizar esta 
 * acci�n y/o al presionar el bot�n �ENTRAR�. El �xito del caso de prueba ser� la validaci�n del 
 * email ingresado y por consecuencia la posterior muestra del mensaje de advertencia sobre formato 
 * de email no v�lido
 * @author NEWSHORE
 * CBT56
 */
public class TestIncorrectLogonInvalidUserFormatAccount extends ClaireandbruceTestCase{
	
	@Test
	public void CBT56() throws Exception {
		
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
			 Helper.log("Se ha encontrado una sesi�n iniciada al abrir la p�gina C+B");
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
			
			Helper.log("Se ingresan los datos de usuario para el proceso de login (Email no v�lido)");
			//Formulario para autenticar usuario
			selenium.type("xpath=.//*[@id='email']", "claireandbruce@gmailcom");
			selenium.type("xpath=.//*[@id='pass']", password);		
			Helper.log("Se hace clic en el bot�n 'ENTRAR'");
			selenium.click("//button[contains(@id,'send2')]");	
		
		if (selenium.isTextPresent("Ingrese una direcci�n de correo electr�nico v�lida. Por ejemplo: juanperez@dominio.com.")){
			Helper.log("OK. Se visualiza el mensaje 'Ingrese una direcci�n de correo electr�nico v�lida. Por ejemplo: juanperez@dominio.com.'");
		} else {
			Assert.fail("No se ha encontrado el mensaje de advertencia 'Ingrese una direcci�n de correo electr�nico v�lida. Por ejemplo: juanperez@dominio.com.'");
		}
	}
}