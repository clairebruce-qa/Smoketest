package claireandbruce.com.test.navigationWeb;


import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;

import org.junit.Assert;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 *  Este Caso de Prueba verificará el correcto funcionamiento 
 *  del proceso recuperación de la contraseña de un   usuario 
 *  registrado.
 * 
 * 
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */
public class Test_ForgottenPassword_ValidUser_TuCuenta extends ClaireandbruceTestCase{
	
	public static String username2="";
	@Test
	public void CBT83() throws Exception{
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		
		/* if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				
				int i =(int)(Math.random()*100);
				
				username2 = System.getProperty("my.username","claireandbruceqa"+i+"@gmail.com");
				//String username= "usuarioQa"+i+"@gmail.com";
				System.out.println(username2);
				
				// Se crea el usuario
				selenium.click("//a[contains(text(),'Regístrate')]");
				selenium.waitForPageToLoad("30000");
				selenium.isElementPresent("css=label.required");
				
				if(selenium.isTextPresent("")){
				selenium.type("id=firstname", "Claire");
				selenium.type("id=lastname", "andBruceQA");
				selenium.type("id=email_address", username2);
				selenium.click("name=gender");
				selenium.click("css=div.selreplace_selectbutton");
				selenium.click("//div[@value='14']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=(//div[@value='8'])[2]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='1988']");
				selenium.type("id=password", "123456");
				selenium.click("css=input.fieldset-float-left-align.validate-terms");
				selenium.click("id=registerSubmitButton");
				selenium.waitForPageToLoad("30000");
				  
			  }*/
			
			//if(!("Tu Cuenta").equals(selenium.getTitle())){
			//	  selenium.open("/es_es/customer/account/");
			//	  
			//  }
			
			/*if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				  Claireandbruce.logout(selenium);
				  *
			}*/
			
			if(!selenium.isElementPresent("//a[contains(text(), 'Tu cuenta')]")){
				
				  Assert.fail("Error elemento no encontrado");
			}
			selenium.click("//a[contains(text(), 'Tu cuenta')]");
			selenium.waitForPageToLoad("15000");
			
			if(!selenium.isElementPresent("xpath=/html/body/div/div[3]/div/div/div/div/form/div/ul/li[3]/div")){
				
				//if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
					  Claireandbruce.login(selenium, username2, "123456");
					  
				//}
				/*assertTrue(selenium.isElementPresent("class=menu-item"));
				assertTrue(selenium.isElementPresent("css=div.item.account-configuration"));
				assertTrue(selenium.isTextPresent("Contraseña y bajas"));
				selenium.click("//div[2]/li[3]/a/span");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getText("css=div.infounsubscribe-subtitle").equals("¿Quieres desactivar tu cuenta?"));
				assertTrue(selenium.isElementPresent("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button"));
				selenium.click("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button");
				int j= (int)(Math.random()*(6))+1;
				selenium.click("xpath=.//*[@id='form-validate-unsubscribe']/div[2]/ul/li["+j+"]/div/label");
				assertTrue(selenium.isElementPresent("css=a.buttoncancelunsubscribe > span"));//verifica que el boton cancelar si esta habilitado
				selenium.click("css=#form-validate-unsubscribe > div.buttons-set.form-buttons > button.button");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Su cuenta ha sido desactivada con éxito."));
			*/
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
