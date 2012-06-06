package claireandbruce.com.test.account;



import lib.Claireandbruce;
import org.junit.Assert;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * Este Caso  de Prueba verificará el  correcto funcionamiento  
 * del proceso  recuperación  de la  contraseña de  un usuario
 * no registrado. Para esto se realiza la prueba con el correo 
 * electrónico  pertenece a un usuario no  registrado  en   el 
 * sistema.
 * 
 * CBT84
 * @author NEWSHORE
 *
 */
public class TestForgottenPasswordInvalidUserTuCuenta extends ClaireandbruceTestCase{
	

	@Test
	public void CBT84() throws Exception{
		
		// Se ingresa a la pagina principal de ClaireandBruce
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		  
		  // Si el usuario esta autenticado se sale \\
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				Claireandbruce.logout(selenium);
				
			}
			
			// Se verifica que el link de Tu cuenta esta habilitado \\	
			if(!selenium.isElementPresent("//a[contains(text(), 'Tu cuenta')]")){
				
				  Assert.fail("Error elemento no encontrado");
			}
			selenium.click("//a[contains(text(), 'Tu cuenta')]");
			selenium.waitForPageToLoad("15000");
			
			
			// Se busca el elemento Olvido su contraseña para cargar el formulario \\
			if(!selenium.isElementPresent("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div")){
				
				
					  Claireandbruce.login(selenium, "claireandbruceqa39@gmail.com", "123458");
				
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
			
			selenium.type("xpath=.//*[@id='email_address']", "stress_test_qa85@claireandbruce.com");
			selenium.click("xpath=.//*[@id='form-forgot-password']/div/div[2]/div[1]/button");
			selenium.waitForPageToLoad("30000");
			
			if(!selenium.isTextPresent("No se encontró esta dirección de correo electrónico en nuestros registros")){
				
				  Assert.fail("No se encontro el mensaje.");
				  
			  }
			
	//}/
	}
	
}
