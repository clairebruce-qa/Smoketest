package claireandbruce.com.test.register;


import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * El objetivo   ser� mostrar  y  verificar  el reporte de error de 
 * registro de usuario   cuando se ingresa un e- mail de  un usuario 
 * registrado, el exito del caso de prueba ser� un mensaje de  error 
 * del sistema con  la  confirmacion  de correo electronico de  otro 
 * usuario, solicitando nuevamente el ingreso del correo electr�nico.
 * Testlink: Local CBT28  - Privalia CBT30
 * @author NEWSHORE
 *
 */
public class TestUserRegister7UserRegistrationvalidfieldwithEMailRegister extends ClaireandbruceTestCase {
	

	public static String username2;

	@Test
	public void cbt30() throws Exception{
		
		Helper.log("Se inicia proceso de registro de usuario con correo electr�nico de un usuario ya registrado");
		// Elimina las cookies
		Helper.log("Se eliminan cookies del navegador");
		selenium.deleteAllVisibleCookies();
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl); 
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				
				int i =(int)(Math.random()*100);
				Helper.log("Prueba realizada con el correo electr�nico stress_test_qa@claireandbruce.com ");
				username2 = System.getProperty("my.username","stress_test_qa@claireandbruce.com");
				//String username= "usuarioQa"+i+"@gmail.com";
				Helper.log("Se hace clic en el link 'Reg�strate'");
				selenium.click("//a[contains(text(),'Reg�strate')]");
				selenium.waitForPageToLoad("30000");
				selenium.isElementPresent("css=label.required");
				
				if(selenium.isTextPresent("")){
				Helper.log("Se ingresan los datos de usuario");
				selenium.type("id=firstname", "Claire");
				selenium.type("id=lastname", "andBruceQA");
				selenium.type("id=email_address", username2);
				selenium.click("name=gender");
				selenium.click("css=div.selreplace_selectbutton");
				selenium.click("//div[@value='14']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=(//div[@value='2'])[2]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='1988']");
				selenium.type("id=password", "123456");
				Helper.log("Se aceptan t�rminos y condiciones, y pol�ticas de privacidad");
				selenium.click("css=input.fieldset-float-left-align.validate-terms");
				Helper.log("Se hace clic en el bot�n 'SIGUE CON TU COMPRA'");
				selenium.click("id=registerSubmitButton");
				Helper.log("Se espera carga de la interfaz con el mensaje de advertencia");
				selenium.waitForPageToLoad("30000");
				  
				if (!selenium.isTextPresent( "Ya existe una cuenta con esta direcci�n de correo electr�nico.")){		
					
					Assert.fail("Error: el formato de correo no es v�lido");
			}
				Helper.log("Se encuentra el mensaje de advertencia 'Ya existe una cuenta con esta direcci�n de correo electr�nico");
				
				
			  }
			
			if(!("Mi cuenta").equals(selenium.getTitle())){
				  selenium.open("/es_es/customer/account/");
				  
			  }
		
		}}
			
	
}
