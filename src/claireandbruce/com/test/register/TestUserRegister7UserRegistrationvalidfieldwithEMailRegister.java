package claireandbruce.com.test.register;


import junit.framework.Assert;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * El objetivo   será mostrar  y  verificar  el reporte de error de 
 * registro de usuario   cuando se ingresa un e- mail de  un usuario 
 * registrado, el exito del caso de prueba será un mensaje de  error 
 * del sistema con  la  confirmacion  de correo electronico de  otro 
 * usuario, solicitando nuevamente el ingreso del correo electrónico.
 * 
 * @author NEWSHORE
 *
 */
public class TestUserRegister7UserRegistrationvalidfieldwithEMailRegister extends ClaireandbruceTestCase {
	

	public static String username2;

	@Test
	public void CBT28() throws Exception{
		
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				
				int i =(int)(Math.random()*100);
				username2 = System.getProperty("my.username","stress_test_qa@claireandbruce.com");
				//String username= "usuarioQa"+i+"@gmail.com";
				System.out.println(username2);
				
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
				  
				if (!selenium.isTextPresent( "Ya existe una cuenta con esta dirección de correo electrónico.")){		
					
					Assert.fail("Error: el formato de correo no es válido");
			}
				
				
			  }
			
			if(!("Tu Cuenta").equals(selenium.getTitle())){
				  selenium.open("/es_es/customer/account/");
				  
			  }
		
		}}
			
	
	


}
