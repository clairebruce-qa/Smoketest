package claireandbruce.com.test.navigation;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT43_Test_FooterMiddleNavigation_Tendencias extends ClaireandbruceTestCase {
		
	@Test
	public void test_FooterMiddleNavigation_Tendencias() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}
		
		if(!selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[5]/div[2]/ul/li[1]/a") || 
				!selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li/a")){
			selenium.click("xpath=//img[@alt='Claire and Bruce']");
			selenium.waitForPageToLoad("15000");
		}
		
		int literal=1;
		if(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[5]/div[2]/ul/li["+literal+"]/a")){
				
			while(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[5]/div[2]/ul/li["+literal+"]/a")){
				String texto=selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div[5]/div[2]/ul/li["+literal+"]/a");
				selenium.click("xpath=html/body/div/div[4]/div/div[3]/div[5]/div[2]/ul/li["+literal+"]/a");
				Helper.log("Link "+texto+" present");
				selenium.waitForPageToLoad("25000");
				//Se verifica que se encuentre al menos un producto de la marca
				selenium.isTextPresent(texto);
				Helper.log("Verification Link "+texto+" in Footer. OK");	
				//Se regresa a HomePage
				selenium.click("xpath=//img[@alt='Claire and Bruce']");
				selenium.waitForPageToLoad("25000");
				
				literal++;
			}
		}else {
			Helper.log("Link "+selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div[5]/div[2]/ul/li["+literal+"]/a")+" not found in Footer");
		}		
	}
}
