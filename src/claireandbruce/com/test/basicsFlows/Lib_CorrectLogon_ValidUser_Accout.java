package claireandbruce.com.test.basicsFlows;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

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
public class Lib_CorrectLogon_ValidUser_Accout extends ClaireandbruceTestCase {

	public static void CBT55(Selenium selenium) throws Exception {
		String mensaje = null;
		
		// Elimina las cookies
		selenium.deleteAllVisibleCookies();
		
		selenium.open(ClaireandbruceUrl);

		selenium.waitForPageToLoad("30000");
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
			}
			
			//Formulario para autenticar usuario
			selenium.type("xpath=.//*[@id='email']", username);
			selenium.type("xpath=.//*[@id='pass']", password);		
			selenium.click("//button[contains(@id,'send2')]");	
			selenium.waitForPageToLoad("38000");
			
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
