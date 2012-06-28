package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;

import com.thoughtworks.selenium.Selenium;

import lib.Helper;
import basics.ClaireandbruceTestCase;

/** 
 * Esta clase verifica que exista al menos una direcci�n guardada por defecto  
 * @author NEWSHORE
 * 
 * */
public class LibAddressExist extends ClaireandbruceTestCase {
	
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
	Helper.log(" ");
	
	Helper.log("Se verifica que se encuentre una direcci�n de env�o por defecto se�alada");
	if(!("Compra ahora").equals(selenium.getTitle())) {	
		Helper.log("Se busca m�todo de ingreso a la interfaz 'Compra ahora'");
		if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
			Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el bot�n 'C�MPRALO AHORA' del header");
			if(!selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				selenium.click("id=cartHeader");
			}
			selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
			Helper.log("Se hace clic en el bot�n 'C�MPRALO AHORA' del header");
		} else {
			Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el bot�n 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
			selenium.click("xpath=//div/div/div/a");
			Helper.log("Se hace clic en el bot�n 'COMPRA AHORA' ubicado en la parte superior de la p�gina");			
		}
		selenium.waitForPageToLoad("30000");
		Helper.log("Se presiona el bot�n 'CONTINUA' de la interfaz 'Shopping Cart'");
		selenium.click("xpath=(//button[@type='button'])[3]");
		selenium.waitForPageToLoad("20000");
	}
		
	//------***** Verifica que exista al menos una direcci�n ****------\\
	
	Helper.log("Se busca si la direcci�n se encuentra seleccionada");
		if(selenium.isElementPresent("name=shipping_address_id")){	
			Helper.log("Se ha encontrado una direcci�n creada, se selecciona �sta");
			selenium.click("name=shipping_address_id"); // Si encuentra la direcci�n la selecciona
			Helper.log("Se selecciona la direcci�n");
		}
		else{		
			Helper.log("No se posee una direcci�n existente por defecto");
			Assert.fail("Error: no existe una direcci�n");
		}	
		Helper.log("Se finaliza el proceso de verificaci�n de la direcci�n de env�o por defecto");
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
