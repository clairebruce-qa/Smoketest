package claireandbruce.com.test.navigation;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/* Automatización creada el 18/04/2012
 * María Fernanda Rodríguez Vargas
 * Newshore-Armenia
 * 
 * Caso de prueba encargado de verificar la correcta navegabilidad a través 
 * de los items (After Work, Bohemian Chic, Denim Overload, Rocky Attitude, 
 * Romantic Countryside, Sailing In Saint Tropez, Working Girl) encontrados 
 * en el Header-Category.
 */
public class CBT47_Test_HeaderHomePageNavigation_Tendencias extends ClaireandbruceTestCase {
		
	@Test
	public void test_HeaderHomePageNavigation_Tendencias() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		Helper.log("AMBIENTE DE PRUEBA: "+selenium.getLocation()+"\n");
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}

		//Se ingresa al link de TENDENCIAS
		selenium.click("xpath=.//*[@id='nav']/li[6]/a/span/cufon/canvas");
		selenium.waitForPageToLoad("15000");
		Helper.log("Checking link 'TENDENCIAS'");
		
		String ubicacionActual = selenium.getLocation();
		if(selenium.getLocation().startsWith("Tendencias")){
			Helper.log("The link 'TENDENCIAS' load a page with content of all tendencies");
		} else {
			Helper.log("The link 'TENDENCIAS' does not load a page with content of all tendencies. Or name of page doesn't starts with 'Tendencias'");
		}
		//Se regresa a HomePage
		selenium.click("xpath=//img[@alt='Claire and Bruce']");
		selenium.waitForPageToLoad("25000");
		
		int literal=1;
		if(selenium.isElementPresent("xpath=.//*[@id='nav']/li[6]/ul/li["+literal+"]/a/span")){
				
			while(selenium.isElementPresent("xpath=.//*[@id='nav']/li[6]/ul/li["+literal+"]/a/span")){
				String texto=selenium.getText("xpath=.//*[@id='nav']/li[6]/ul/li["+literal+"]/a/span");
				selenium.click("xpath=.//*[@id='nav']/li[6]/ul/li["+literal+"]/a/span");
				Helper.log("Link "+texto+" present");
				selenium.waitForPageToLoad("25000");
				//Se verifica que se encuentre al menos un producto de la marca
				selenium.isTextPresent(texto);
				Helper.log("Verification Link "+texto+" in Header. OK");	
				//Se regresa a HomePage
				selenium.click("xpath=//img[@alt='Claire and Bruce']");
				selenium.waitForPageToLoad("25000");
				
				literal++;
			}
		}else {
			Helper.log("Link "+selenium.getText("xpath=.//*[@id='nav']/li[6]/ul/li["+literal+"]/a/span")+" not found in Header");
		}	
	}
}
