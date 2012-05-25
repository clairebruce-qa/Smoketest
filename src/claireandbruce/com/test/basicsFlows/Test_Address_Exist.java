package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

/** 
 * Esta clase verifica que exista al menos una dirección guardada por defecto  
 * @author Yuliana María Saavedra Russí
 * 
 * */
public class Test_Address_Exist extends ClaireandbruceTestCase {
	
	/**
	 * 
	 */
	
	public static void CBT_Address(Selenium selenium) throws Exception{
		
/* ESTO SE PONE EN COMENTARIO PARA QUE CORRA EN EL FLUJO
		
	selenium.deleteAllVisibleCookies();
	
	
	selenium.waitForPageToLoad("15000");
	if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		selenium.click("//a[@id='overridelink']");
	}
*/
	//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
	
	if(!("Compra ahora").equals(selenium.getTitle())) {		
		if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
			selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
			selenium.waitForPageToLoad("30000");
		} else {
			selenium.click("xpath=//div/div/div/a");
			selenium.waitForPageToLoad("30000");
		}
		selenium.click("xpath=(//button[@type='button'])[3]");
		selenium.waitForPageToLoad("20000");
	}
		
	//------***** Verifica que exista al menos una dirección ****------\\
	
		if(selenium.isElementPresent("name=shipping_address_id")){	
			selenium.click("name=shipping_address_id"); // Si encuentra la dirección la selecciona
			Helper.log("existe una dirección por defecto seleccionada");
		}
		else{		
			Helper.log("Se agrego la dirección existente por defecto");
			Assert.fail("Error: no existe una dirección");
		}		
	}
	
	
	//	SE PONE EN COMENTARIO PARA CORRER EN EL FLUJO
	// 	PARA PRUEBAS UNITARIAS SE ACTIVA
	/*
	@After
	public void afterTest(){
		selenium.stop();
	}
	*/

}
