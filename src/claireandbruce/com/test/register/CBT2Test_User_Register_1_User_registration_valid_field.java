package claireandbruce.com.test.register;

import lib.Helper;

import org.junit.After;
import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT2Test_User_Register_1_User_registration_valid_field extends ClaireandbruceTestCase {
	
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
	
	@Test
	public void TestUserRegistration() throws Exception{
		
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		   System.out.print("Si entra");
		  }	
		
		selenium.click("//a[contains(text(),'Regístrate')]");
		selenium.waitForPageToLoad("30000");
		selenium.isElementPresent("css=label.required");

		selenium.type("id=firstname", "Claire");
		selenium.type("id=lastname", "andBruceQA");
		selenium.type("id=email_address", "claireandbruceqa@gmail.com");
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
	
		
		 Helper.waitForElement(selenium, "//a[contains(text(),'Salir')]", "Not Found Page");
			
	}
	
	@After
	public void tearDown() throws Exception {
		
		selenium.click("//a[contains(text(),'Salir')]");
		selenium.stop();
	}
	

}
