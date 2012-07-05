package claireandbruce.com.test.account;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
/**
 * Testlink: Local CBT62  - Privalia CBT23
 * @author NEWSHORE
 *
 */
public class TestCorrectPasswordChangeSpacesNewPassAccount extends ClaireandbruceTestCase {

	@Test
	public void cbt23() throws Exception{
		
		Helper.log("\n*** CASO DE PRUEBA *** CBT62. CAMBIO CORRECTO DE CONTRASE�A - NUEVA CONTRASE�A CON ESPACIOS EN ELLA");
		
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		if(!selenium.getTitle().equals("Mi cuenta")){
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		}
		
		//Ingreso a Contrase�a y Bajas
		selenium.click("xpath=//li[3]/a/span");
		selenium.waitForPageToLoad("15000");
		
		Helper.log("Se ha ingresado a la interfaz 'Contrase�as y Bajas");
		selenium.type("id=current_password", password);
		selenium.type("id=password", "12 34 56");
		
		selenium.click("xpath=//form[@id='form-validate-pass']/div[2]/button");
		selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Se guard� la informaci�n de la cuenta.")){
			Helper.log("La nueva contrase�a ha sido cambiada con �xito");
		} else {
			Helper.log("La nueva contrase�a no se ha almacenado �xitosamente");
		}

		//Se ingresan los nuevos datos para que la contrase�a anterior sea recuperada
		selenium.type("id=current_password", "12 34 56");
		selenium.type("id=password", password);
		
		selenium.click("xpath=//form[@id='form-validate-pass']/div[2]/button");
		selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Se guard� la informaci�n de la cuenta.")){
			Helper.log("La contrase�a anterior ha sido recuperada con �xito");
		} else {
			Helper.log("La contrase�a anterior no ha sido recuperada �xitosamente");
		}
				
	}

}
