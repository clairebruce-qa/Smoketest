package claireandbruce.com.test.account;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;

/**
 * CBT61
 * @author NEWSHORE
 *
 */
public class TestIncorrectPasswordChangeInvalidOldPassAccount extends ClaireandbruceTestCase {

	@Test
	public void CBT61() throws Exception {
		Helper.log("\n*** CASO DE PRUEBA *** CBT61. CAMBIO DE CONTRASE�A CON CONTRASE�A ACTUAL NO V�LIDA");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		if(!selenium.getTitle().equals("Mi cuenta")){
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		}
		
		//Ingreso a Contrase�a y Bajas
		selenium.click("xpath=//li[3]/a/span");
		selenium.waitForPageToLoad("15000");
		
		Helper.log("Se ha ingresado a la interfaz 'Contrase�as y Bajas");
		selenium.type("id=current_password", "12w3e4r4");
		selenium.type("id=password", "1234567");
		
		selenium.click("xpath=//form[@id='form-validate-pass']/div[2]/button");
		selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Contrase�a actual inv�lida")){
			Helper.log("Caso de prueba �xitoso");
		} else {
			Helper.log("No se est� informando al usuario sobre la contrase�a acutal no v�lida");
		}
	}

}
