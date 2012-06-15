package claireandbruce.com.test.navigationWeb;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * 
 * @author NEWSHORE
 * CBT31
 */
public class TestHomePageNavigability1NavigabilityForLookNotLogin extends ClaireandbruceTestCase {

	@Test
	public void CBT31 () throws Exception{
		
		//Pruebas unitarias
		Helper.log("Se prueba la navegabilidad por los looks visibles en Homepage");
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		int look= 2;
		while(selenium.isElementPresent("xpath=//div["+look+"]/a/img")){
			Helper.log("Se ingresa al look");
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
			Helper.log("Se regresa a la Homepage");
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
			look++;
		}	
	}
}