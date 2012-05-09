package claireandbruce.com.test.navigation;

import static org.junit.Assert.assertTrue;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT32_Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login extends ClaireandbruceTestCase {

	@Test
	public void test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login () throws Exception{
		
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		//Se ingresa al primer total look
		if(selenium.isElementPresent("xpath=//div/a/img")){
			//Se ingresa al look y se compara con el texto Compra el total look ubicado en la pagina
			selenium.click("xpath=//div/a/img");
			selenium.waitForPageToLoad("15000");
			if(selenium.isElementPresent("xpath=//*[@alt='/ES/']")){
				Helper.log("PAGINA NO DISPONIBLE");
				selenium.click("xpath=//div[3]/a/cufon/canvas");
			}else {				
				assertTrue(selenium.getText("id=total-look").equals("Compra el total look"));
				selenium.click("link=Inicio");
			}			
			selenium.waitForPageToLoad("10000");
		}
		
		//Se ingresa al segundo total look
		if(selenium.isElementPresent("xpath=//div[2]/a/img")){
			//Se ingresa al look y se compara con el texto Compra el total look ubicado en la pagina
			selenium.click("xpath=//div[2]/a/img");
			selenium.waitForPageToLoad("15000");
			if(selenium.isElementPresent("xpath=//*[@alt='/ES/']")){
				Helper.log("PAGINA NO DISPONIBLE");
				selenium.click("xpath=//div[3]/a/cufon/canvas");
			}else {				
				assertTrue(selenium.getText("id=total-look").equals("Compra el total look"));
				selenium.click("link=Inicio");
			}
			selenium.waitForPageToLoad("10000");
		}
		
		//Se ingresa al tercer total look
		if(selenium.isElementPresent("xpath=//div[3]/a/div/div")){
			//Se ingresa al look y se compara con el texto Compra el total look ubicado en la pagina
			selenium.click("xpath=//div[3]/a/div/div");
			selenium.waitForPageToLoad("15000");
			if(selenium.isElementPresent("xpath=//div[3]/a/div/div")){
				Helper.log("PAGINA NO DISPONIBLE");
				selenium.click("xpath=//div[3]/a/cufon/canvas");
			}else {				
				assertTrue(selenium.getText("id=total-look").equals("Compra el total look"));
				selenium.click("link=Inicio");
			}			
			selenium.waitForPageToLoad("10000");
		}
		
		//Se ingresa al cuarto total look
		if(selenium.isElementPresent("xpath=//div[4]/a/div")){
			//Se ingresa al look y se compara con el texto Compra el total look ubicado en la pagina
			selenium.click("xpath=//div[4]/a/div");
			selenium.waitForPageToLoad("15000");
			if(selenium.isElementPresent("xpath=//div[4]/a/div")){
				Helper.log("PAGINA NO DISPONIBLE");
				selenium.click("xpath=//div[3]/a/cufon/canvas");
			}else {				
				assertTrue(selenium.getText("id=total-look").equals("Compra el total look"));
				selenium.click("link=Inicio");
			}			
			selenium.waitForPageToLoad("10000");
		}
		
		if(!selenium.isElementPresent("xpath=//div/a/img") && !selenium.isElementPresent("xpath=//div[2]/a/img") &&
			!selenium.isElementPresent("xpath=//div[3]/a/div/div") && !selenium.isElementPresent("xpath=//div[4]/a/div")){
			Helper.log("NO SE ENCUENTRA NINGUN ENLACE A TOTAL LOOK POR IMAGENES EN HOMEPAGE");
		}
	}
}
