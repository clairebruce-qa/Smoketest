package claireandbruce.com.test.account;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Assert;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 *  Este Caso de Prueba verificar� el correcto funcionamiento 
 *  del proceso recuperaci�n de la contrase�a de un   usuario 
 *  registrado.
 * 
 *  Testlink: Local CBT83  - Privalia CBT17
 * @author NEWSHORE
 *
 */
public class TestForgottenPasswordValidUserAccount extends ClaireandbruceTestCase{
	
	@Test
	public void cbt17() throws Exception{
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		 if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			 selenium.click("//a[@id='overridelink']");
		 }	
		 
		if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Helper.log("Se encuentra activa una sesi�n de usuario");
			Claireandbruce.logout(selenium);
		}

		if(!selenium.isElementPresent("//a[contains(text(), 'Tu cuenta')]")){
			Helper.log("No se encuentra el link 'Tu cuenta'");
			Assert.fail("Error elemento no encontrado");
		}
		
		selenium.click("//a[contains(text(), 'Tu cuenta')]");
		selenium.waitForPageToLoad("15000");
			
		if(!selenium.isElementPresent("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div")){
			Claireandbruce.login(selenium,"stress_test_qa125@claireandbruce.com", "123458");
			Assert.fail("Error: elemento OLVIDO SU CONTRASE�A no encontrado");
		}

		selenium.click("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div");
			
		//Verifica que el bot�n de cancelar funciona correctamente
		Helper.log("Se verifica que el bot�n cancelar funciona correctamente");
		selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[2]");
			
		if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div/ul/li[3]/div")){
			  Assert.fail("Error elemento no encontrado");
		}
			
		// Se ingresan los datos del usuario para confirmar la contrase�a
		Helper.log("Se ingresan los datos de usuario para confirmar la contrase�a");
		selenium.click("xpath=.//*[@id='login-form']/div/ul/li[3]/div");
			
		selenium.type("xpath=.//*[@id='email_address']", "stress_test_qa125@claireandbruce.com");
		selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[1]/button");
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isTextPresent("Te hemos enviado un e-mail a stress_test_qa125@claireandbruce.com con las instrucciones para cambiar tu contrase�a.")){
			  Assert.fail("No se env�o e-mail de la contrase�a");
		}
			
	//}/
	}
	
}
