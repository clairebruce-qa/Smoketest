package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertEquals;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 * CBT90
 */
public class TestNavigationByCategoryHeader extends ClaireandbruceTestCase {
		
	@Test
	public void CBT90() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		Helper.log("Ambiente de prueba: "+selenium.getLocation());
		
		int menu=1, literal=1;
		//Se recorre los menus que se probaran
		while(selenium.isElementPresent("xpath=.//*[@id='nav']/li["+menu+"]/a/span/cufon/canvas") && menu<=4){
			literal=1;
			String textoMenu="Ropa";
			
			selenium.click("xpath=.//*[@id='nav']/li["+menu+"]/a/span/cufon/canvas");			
			selenium.waitForPageToLoad("20000");
			
			
			//Se verifica texto en la miga de pan
			if(selenium.getTitle().startsWith("Ropa")) {
				textoMenu="Ropa";
			} else if(selenium.getTitle().startsWith("Zapatos")) {
				textoMenu="Zapatos";
			} else if(selenium.getTitle().startsWith("Bolsos")) {
				textoMenu ="Bolsos";
			} else if(selenium.getTitle().startsWith("Accesorios")) {
				textoMenu = "Accesorios";
			}
			Helper.log("Checking menu "+textoMenu);
			assertEquals(selenium.getText("class=breadcrumbs-present"), textoMenu);
			
			//Se recorre cada literal del menu
			while(selenium.isElementPresent("xpath=.//*[@id='nav']/li["+menu+"]/ul/li["+literal+"]/a/span")){
				//Click en el submenu
				String textoSubMenu =  selenium.getText("xpath=.//*[@id='nav']/li["+menu+"]/ul/li["+literal+"]/a/span");
				Helper.log("Checking submenu "+textoSubMenu);
				selenium.click("xpath=.//*[@id='nav']/li["+menu+"]/ul/li["+literal+"]/a/span");
				selenium.waitForPageToLoad("20000");
				//Se verifica texto en la miga de pan
				assertEquals(selenium.getText("class=breadcrumbs-present"), textoSubMenu);
				Helper.log("Check the bread crumbs "+textoSubMenu+". OK");
				selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+literal+"]/div/div/strong");
				Helper.log("Check - underlined link "+textoSubMenu+". OK");
				literal++;				
			}			
			menu++;
		}
	}
}
