package claireandbruce.com.test.account;

import lib.Claireandbruce;
import org.junit.Assert;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 *  Este Caso de Prueba verificará el correcto funcionamiento 
 *  del proceso recuperación de la contraseña de un   usuario 
 *  registrado.
 * 
 * CBT83
 * @author NEWSHORE
 *
 */
public class TestForgottenPasswordValidUserAccount extends ClaireandbruceTestCase{
	
	public static String username2="";
	@Test
	public void CBT83() throws Exception{
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				Claireandbruce.logout(selenium);
				
			}
	
			
			if(!selenium.isElementPresent("//a[contains(text(), 'Tu cuenta')]")){
				
				  Assert.fail("Error elemento no encontrado");
			}
			selenium.click("//a[contains(text(), 'Tu cuenta')]");
			selenium.waitForPageToLoad("15000");
			
			if(!selenium.isElementPresent("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div")){
				
				
					  Claireandbruce.login(selenium,"claireandbruceqa39@gmail.com", "123458");
					  
			
			
				  Assert.fail("Error: elemento OLVIDO SU CONTRASEÑA no encontrado");
			}
			
			selenium.click("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div");
			
			//Verifica que el botón de cancelar funciona correctamente
			selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[2]");
			
			if(!selenium.isElementPresent("xpath=.//*[@id='login-form']/div/ul/li[3]/div")){
				
				  Assert.fail("Error elemento no encontrado");
			}
			
			// Se ingresan los datos del usuario para confirmar la contraseña
			selenium.click("xpath=.//*[@id='login-form']/div/ul/li[3]/div");
			
			selenium.type("xpath=.//*[@id='email_address']", "claireandbruceqa39@gmail.com");
			selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[1]/button");
			selenium.waitForPageToLoad("30000");
			
			if(!selenium.isTextPresent("Te hemos enviado un e-mail a claireandbruceqa39@gmail.com con las instrucciones para cambiar tu contraseña.")){
				
				  Assert.fail("No se envío e-mail de la contraseña");
				  
			  }
			
	//}/
	}
	
}
