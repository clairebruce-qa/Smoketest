package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */
public class TestFooterMiddleNavigationMarcas extends ClaireandbruceTestCase {
	
	@Test
	public void CBT95() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(!selenium.isElementPresent("xpath=//div[5]/div/a")){
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
		}
		
		//Se ingresa a Marcas en el footer
		selenium.click("xpath=//div[5]/div/a");
		selenium.waitForPageToLoad("40000");
		assertEquals("Marcas - Mujer", selenium.getTitle());
		selenium.click("xpath=//img"); //Se regresa a home
		selenium.waitForPageToLoad("25000");	
		
		int literal=2;
		//Link de la primera marca (xpath= perteneciente a link en produccion y pre-produccion)
		if(selenium.isElementPresent("xpath=//div[5]/div[2]/ul/li/a")){
			
			//Ver todas las marcas
			selenium.click("xpath=//div[5]/div[2]/ul/li/a");
			selenium.waitForPageToLoad("35000");
			selenium.click("xpath=//img"); //Se regresa a home
			selenium.waitForPageToLoad("25000");	
			
			
			while(selenium.isElementPresent("xpath=//div[5]/div[2]/ul/li["+literal+"]/a")){
				String texto=selenium.getText("xpath=//div[5]/div[2]/ul/li["+literal+"]/a");
				selenium.click("xpath=//div[5]/div[2]/ul/li["+literal+"]/a");
				Helper.log("Link "+texto+" present");
				selenium.waitForPageToLoad("30000");
				//Se verifica que se encuentre al menos un producto de la marca
				assertEquals(texto.toUpperCase(), selenium.getText("xpath=//li/div[2]"));
				Helper.log("Link "+texto+" in Footer. OK");	
				//Se regresa a HomePage
				selenium.click("xpath=//img");
				selenium.waitForPageToLoad("30000");
				
				literal++;
			}
			//xpath encontrado en el ambiente de integracion
		} /*else if(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li/a")){
			
			String texto=selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li/a");
			selenium.click("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li/a");
			Helper.log("Link "+texto+" present");
			selenium.waitForPageToLoad("20000");
			//Se verifica que se encuentre al menos un producto de la marca
			selenium.isTextPresent(texto);
			Helper.log("Verification Link "+texto+" in Footer. OK");	
			//Se regresa a HomePage
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("20000");
			
			while(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li["+literal+"]/a")){
				texto=selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li["+literal+"]/a");
				selenium.click("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li["+literal+"]/a");
				Helper.log("Link "+texto+" present");
				selenium.waitForPageToLoad("20000");
				//Se verifica que se encuentre al menos un producto de la marca
				selenium.isTextPresent(texto);
				Helper.log("Verification Link "+texto+" in Footer. OK");	
				//Se regresa a HomePage
				selenium.click("xpath=//img']");
				selenium.waitForPageToLoad("20000");
				
				literal++;
			}
		}else {
			Helper.log("Link "+selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li["+literal+"]/a")+" not found in Footer");
			Helper.log("Link "+selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div[4]/div[2]/ul/li/a")+" not found in Footer");
		}*/
	}

}
