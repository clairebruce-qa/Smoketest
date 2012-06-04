package claireandbruce.com.test.register;

import static org.junit.Assert.assertTrue;
import lib.Helper;

import org.junit.After;
import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class TestUserRegister1UserRegistrationValidField extends ClaireandbruceTestCase {
	
	/*@After 
	public void verify() throws Exception{
		//Para Abrir otra ventana
		selenium.deleteAllVisibleCookies();  
		  selenium.open("");

		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		   System.out.print("Si entra");
		  }	
		  
		  selenium.waitForPageToLoad("40000");
			
		  Helper.waitForElement(selenium, "//a[contains(text(),'Regístrate')]", "Log-out link not found in the page");
	
		 
	}*/
	
	public static String username2;

	@Test
	public void CBT2() throws Exception{
		
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				
				int i =(int)(Math.random()*100);
				username2 = System.getProperty("my.username","stress_test_qa"+i+"@claireandbruce.com");
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
				  
			  }
			
			if(!("Tu Cuenta").equals(selenium.getTitle())){
				  selenium.open("/es_es/customer/account/");
				  
			  }
			//-----------***** la interfaz de AREA PRIVADA esta cargada*****-----------------
			assertTrue(selenium.isElementPresent("class=menu-item"));
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
		
			
		}}
			
	
	


}
