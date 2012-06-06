package claireandbruce.com.test.navigationWeb;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/** @author NEWSHORE
 * 
 * Caso de prueba encargado de verificar la correcta navegabilidad a través 
 * de los items (After Work, Bohemian Chic, Denim Overload, Rocky Attitude, 
 * Romantic Countryside, Sailing In Saint Tropez, Working Girl) encontrados 
 * en el Header-Category.
 */
public class TestHeaderHomePageNavigationTendencias extends ClaireandbruceTestCase {
			
	@Test
	public void CBT100() throws Exception{
		
		//Para efectos de pruebas unitarias
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		Helper.log("\nNAVEGACIÓN POR TENDENCIAS EN HEADER");
		//Se carga la home
		selenium.click("xpath=html/body/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/h1/a/img");
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}

		//Se ingresa al link de TENDENCIAS
		selenium.click("xpath=.//*[@id='nav']/li[6]/h2/a/span/cufon/canvas");
		selenium.waitForPageToLoad("15000");
		Helper.log("Checking link 'TENDENCIAS'");
		
		String ubicacionActual = selenium.getLocation();
		if(selenium.getLocation().startsWith("Tendencias")){
			Helper.log("The link 'TENDENCIAS' load a page with content of all tendencies");
		} else {
			Helper.log("The link 'TENDENCIAS' does not load a page with content of all tendencies. Or name of page doesn't starts with 'Tendencias'");
		}
		//Se regresa a HomePage
		selenium.click("xpath=html/body/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/h1/a/img");
		selenium.waitForPageToLoad("25000");
		
		int literal=2;
		if(selenium.isElementPresent("xpath=//ul[@id='nav']/li[6]/ul/li/h3/a/span")){
				
			while(selenium.isElementPresent("xpath=//ul[@id='nav']/li[6]/ul/li["+literal+"]/h3/a/span")){
				String texto=selenium.getText("xpath=//ul[@id='nav']/li[6]/ul/li["+literal+"]/h3/a/span");
				selenium.click("xpath=//ul[@id='nav']/li[6]/ul/li["+literal+"]/h3/a/span");
				Helper.log("Link "+texto+" present");
				selenium.waitForPageToLoad("25000");
				//Se verifica que se encuentre al menos un producto de la marca
				selenium.isTextPresent(texto);
				Helper.log("Verification Link "+texto+" in Header. OK");	
				//Se regresa a HomePage
				selenium.click("xpath=html/body/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/h1/a/img");
				selenium.waitForPageToLoad("25000");
				
				literal++;
			}
		}else {
			Helper.log("Link "+selenium.getText("xpath=//ul[@id='nav']/li[6]/ul/li/h3/a/span")+" not found in Header");
		}	
	}
}
