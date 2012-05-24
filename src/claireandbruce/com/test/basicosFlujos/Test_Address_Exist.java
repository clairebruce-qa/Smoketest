package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

/** 
 * Esta clase verifica que exista al menos una dirección guardada por defecto 
 * 
 * 
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
	
		//selenium.open(ClaireandbruceUrl);

		//if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			//CBT55_Test_CorrectLogon_ValidUser_TuCuenta.CBT55(selenium);// Se comenta para la prueba de flujo			
	//	}	
	
	//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
	
	if(!("Compra ahora").equals(selenium.getTitle()))
	{
		selenium.click("//a[contains(text(),'Compra ahora')]");
		
		selenium.waitForPageToLoad("20000");
		selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
		selenium.waitForPageToLoad("15000");		
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
