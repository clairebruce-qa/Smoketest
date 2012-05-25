package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

/** 
 * Esta clase verifica que exista al menos una direcci�n guardada por defecto  
 * @author Yuliana Mar�a Saavedra Russ�
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
	//-----****** Verif�ca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
	
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
		
	//------***** Verifica que exista al menos una direcci�n ****------\\
	
		if(selenium.isElementPresent("name=shipping_address_id")){	
			selenium.click("name=shipping_address_id"); // Si encuentra la direcci�n la selecciona
			Helper.log("existe una direcci�n por defecto seleccionada");
		}
		else{		
			Helper.log("Se agrego la direcci�n existente por defecto");
			Assert.fail("Error: no existe una direcci�n");
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
