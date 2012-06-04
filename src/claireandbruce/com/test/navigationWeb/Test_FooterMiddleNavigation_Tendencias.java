package claireandbruce.com.test.navigationWeb;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class Test_FooterMiddleNavigation_Tendencias extends ClaireandbruceTestCase {
		
	@Test
	public void CBT96() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}
	
		
		if(!selenium.isElementPresent("xpath=//div[6]/div/a")){
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
		}
		
		int literal=2;
		if(selenium.isElementPresent("xpath=//div[6]/div/a")){
				
			//Se ingresa al link Tendencias en el footer middle
			selenium.click("xpath=//div[6]/div/a");
			selenium.waitForPageToLoad("15000");
			Helper.log("Ingreso al link Tendencias");
			selenium.click("xpath=//img"); //Se regresa a home
			selenium.waitForPageToLoad("15000");
			
			//Se ingrea a la primera tendencia con xpath diferente
			String tendencia = selenium.getText("xpath=//div[6]/div[2]/ul/li/a");
			selenium.click("xpath=//div[6]/div[2]/ul/li/a");
			Helper.log("Link "+tendencia+" presente");
			selenium.waitForPageToLoad("15000");
			selenium.isTextPresent(tendencia);
			Helper.log("Se encuentra en la tendencia "+tendencia);	
			selenium.click("xpath=//img"); //Se regresa a home
			selenium.waitForPageToLoad("15000");
			
			while(selenium.isElementPresent("xpath=//div[6]/div[2]/ul/li["+literal+"]/a")){
				tendencia = selenium.getText("xpath=//div[6]/div[2]/ul/li["+literal+"]/a");
				selenium.click("xpath=//div[6]/div[2]/ul/li["+literal+"]/a");
				Helper.log("Link "+tendencia+" presente");
				selenium.waitForPageToLoad("25000");
				//Se verifica que se encuentre la tendencia
				selenium.isTextPresent(tendencia);
				Helper.log("Se encuentra en la tendencia "+tendencia);	
				//Se regresa a HomePage
				selenium.click("xpath=//img");
				selenium.waitForPageToLoad("25000");
				
				literal++;
			}
		}else {
			Helper.log("Link "+selenium.getText("xpath=//div[6]/div[2]/ul/li["+literal+"]/a")+" no encontrado en el Footer");
		}		
	}
}
