package claireandbruce.com.test.basicsFlows;
import static org.junit.Assert.assertEquals;

import com.thoughtworks.selenium.Selenium;

import junit.framework.Assert;
import lib.*;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificará el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la información ingresada por el usuario al momento de realizar esta 
 * acción y/o al presionar el botón “ENTRAR”. El éxito del caso de prueba será la verificación del 
 * usuario en el sistema y la redirección de este al "AREA PRIVADA" de "Tu cuenta"
 * @author NEWSHORE
 *
 */
public class LibCorrectLogonValidUserAccout extends ClaireandbruceTestCase {

	public static void CBT55(Selenium selenium) throws Exception {
		String mensaje = null;
		// Elimina las cookies
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
		  
			//R2
			String message = null;
			Helper.log("Open Homepage");
			Helper.log("Se verifica que se encuentre presente el formulario para ingreso de datos de usuario para login");
			//Si no esta presente el formulario para ingresar los datos de usuario
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div")) {			
				Helper.log("No se ha encontrado el formulario por lo cual se ingresa al link 'Tu cuenta'");
				selenium.click("//a[contains(text(), 'Tu cuenta')]");
				selenium.waitForPageToLoad("60000");			
			}
			
			Helper.log("Se ingresan los datos de usuario para el proceso de login");
			//Formulario para autenticar usuario
			selenium.type("xpath=.//*[@id='email']", username);
			selenium.type("xpath=.//*[@id='pass']", password);		
			Helper.log("Se hace clic en el botón 'ENTRAR'");
			selenium.click("//button[contains(@id,'send2')]");	
			selenium.waitForPageToLoad("40000");
			
			if (!selenium.isElementPresent( "class=validation-advice")){		
				if (selenium.isTextPresent("Salir")){
					Helper.log("LOGIN OK");
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
			Helper.log("Se ha producido un error durante el proceso de login. 'Usuario o contraseña inválido'");
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
