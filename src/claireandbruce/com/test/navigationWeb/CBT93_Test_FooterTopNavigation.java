package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.Helper;
import basics.ClaireandbruceTestCase;

public class CBT93_Test_FooterTopNavigation extends ClaireandbruceTestCase {
	
	@Test
	public void CBT40M() throws Exception {
		
		
		//Validacion del Menu de Navegacion del Footer AYUDAS, Condiciones de Uso, Politicas de Privacidad
		selenium.open("/es_es/");
		assertTrue(selenium.isElementPresent("//div/a/cufon/canvas"));
		selenium.click("//div/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Inicio > help"));
		selenium.click("link=Inicio");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//div[2]/a/cufon/canvas"));
		selenium.click("//div[2]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Inicio > condiciones de uso"));
		selenium.click("link=Inicio");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//div[3]/a/cufon[2]/canvas"));
		selenium.click("//div[3]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Inicio > politicas de privacidad"));
		assertTrue(selenium.isElementPresent("//div[4]/a/cufon/canvas"));
		selenium.click("//div[4]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Inicio > About Us"));
		selenium.click("link=Inicio");
		selenium.waitForPageToLoad("30000");
	}
}
