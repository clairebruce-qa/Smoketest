package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login extends ClaireandbruceTestCase {

	@Test
	public void CBT31 () throws Exception{
		
		//Pruebas unitarias
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		int look= 2;
		while(selenium.isElementPresent("xpath=//div["+look+"]/a/img")){
			selenium.click("xpath=//div["+look+"]/a/img");
			selenium.waitForPageToLoad("15000");
			String migaDePan = selenium.getText("css=span.breadcrumbs-present");
			String nombreLook = selenium.getTitle();
			if(migaDePan.equals(nombreLook)) {
				Helper.log("Look "+nombreLook+" presente");
			} else {
				Helper.log("El Look "+nombreLook+" no se encuentra presente");
			}
			
			//Volver a home
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
			look++;
		}	
	}
}