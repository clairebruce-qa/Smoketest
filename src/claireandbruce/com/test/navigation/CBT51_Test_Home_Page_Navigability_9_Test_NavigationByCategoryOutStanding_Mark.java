package claireandbruce.com.test.navigation;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT51_Test_Home_Page_Navigability_9_Test_NavigationByCategoryOutStanding_Mark extends ClaireandbruceTestCase {
	@Test
	public void test_Home_Page_Navigability_9_Test_NavigationByCategoryOutStanding_Mark() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}
		
		if(!selenium.isElementPresent("xpath=//div[6]/ul/li/a/span")){
			selenium.click("xpath=//img[@alt='Claire and Bruce']");
			selenium.waitForPageToLoad("15000");
		}
		
		//Link de la primera marca
		if(selenium.isElementPresent("xpath=//div[6]/ul/li/a/span")){
			String texto=selenium.getText("xpath=//div[6]/ul/li/a/span");
			selenium.click("xpath=//div[6]/ul/li/a/span");
			Helper.log("Link "+texto+" present");			
			selenium.waitForPageToLoad("15000");
			//Se verifica que se encuentre al menos un producto de la marca
			selenium.isTextPresent(texto);
			Helper.log("Verification Link "+texto+" OK");	
			//Se regresa a HomePage
			selenium.click("xpath=//img[@alt='Claire and Bruce']");
			selenium.waitForPageToLoad("15000");
			
			int literal=2;
			while(selenium.isElementPresent("xpath=//div[6]/ul/li["+literal+"]/a/span")){
				texto=selenium.getText("xpath=//div[6]/ul/li["+literal+"]/a/span");
				selenium.click("xpath=//div[6]/ul/li["+literal+"]/a/span");
				Helper.log("Link "+texto+" present");
				selenium.waitForPageToLoad("20000");
				//Se verifica que se encuentre al menos un producto de la marca
				selenium.isTextPresent(texto);
				Helper.log("Verification Link "+texto+" OK");	
				//Se regresa a HomePage
				selenium.click("xpath=//img[@alt='Claire and Bruce']");
				selenium.waitForPageToLoad("20000");
				
				literal++;
			}
		}else{
			Helper.log("Link not found "+selenium.getText("xpath=//div[6]/ul/li/a/span"));
		}		
	}
}
