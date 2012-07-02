package claireandbruce.com.test.account;



import lib.Claireandbruce;
import lib.Helper;

import org.junit.Assert;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * Este Caso  de Prueba verificar� el  correcto funcionamiento  
 * del proceso  recuperaci�n  de la  contrase�a de  un usuario
 * no registrado. Para esto se realiza la prueba con el correo 
 * electr�nico  pertenece a un usuario no  registrado  en   el 
 * sistema.
 * 
 * CBT84
 * @author NEWSHORE
 *
 */
public class TestForgottenPasswordInvalidUserAccount extends ClaireandbruceTestCase{
	

	@Test
	public void CBT84() throws Exception{
		
		// Se ingresa a la pagina principal de ClaireandBruce
		Helper.log("Se eliminan cookies");
		selenium.deleteAllVisibleCookies();  
		Helper.log("Se ingresa a la p�gina "+ClaireandbruceUrl);
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		  
		// Si el usuario esta autenticado se sale \\
		if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
		  Helper.log("Se ha encontrado una sesi�n de usuario activa");
			Claireandbruce.logout(selenium);			
		}
			
			// Se verifica que el link de Tu cuenta esta habilitado \\	
			if(!selenium.isElementPresent("//a[contains(text(), 'Tu cuenta')]")){
				Helper.log("No se ha encontrado el link 'Tu cuenta'");
				Assert.fail("Error elemento no encontrado");
			}
			selenium.click("//a[contains(text(), 'Tu cuenta')]");
			selenium.waitForPageToLoad("15000");
			
			
			// Se busca el elemento Olvido su contrase�a para cargar el formulario \\
			if(!selenium.isElementPresent("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div")){
				Helper.log("Se realiza proceso de login");
				Claireandbruce.login(selenium, "claireandbruceqa39@gmail.com", "123458");				
				Assert.fail("Error: elemento OLVIDO SU CONTRASE�A no encontrado");
			}
			
			selenium.click("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div");
			Helper.log("Se verifica el funcionamiento del bot�n cancelar");
			
			//Verifica que el bot�n de cancelar funciona correctamente
			selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[2]");
			
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div/ul/li[3]/div")){				
				  Assert.fail("Error elemento no encontrado");
			}
			
			Helper.log("Se ingresan los datos del usuario para confirmar la contrase�a");
			// Se ingresan los datos del usuario para confirmar la contrase�a
			selenium.click("xpath=.//*[@id='login-form']/div/ul/li[3]/div");
			
			selenium.type("xpath=.//*[@id='email_address']", "stress_test_qa85@claireandbruce.com");
			selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[1]/button");
			selenium.waitForPageToLoad("30000");
			
			Helper.log("Se verifica la visualizaci�n del mensaje 'No se encontr� esta direcci�n de correo electr�nico en nuestros registros'");
			if(!selenium.isTextPresent("No se encontr� esta direcci�n de correo electr�nico en nuestros registros")){				
				  Assert.fail("No se encontr� el mensaje.");				  
			} else {
				Helper.log("Se encontr� el mensaje");
			}
	//}/
	}	
}
