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
		Helper.log("\n*** CASO DE PRUEBA *** CBT61. CAMBIO DE CONTRASEÑA CON CONTRASEÑA ACTUAL NO VÁLIDA");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		if(!selenium.getTitle().equals("Mi cuenta")){
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		}
		
		//Ingreso a Contraseña y Bajas
		selenium.click("xpath=//li[3]/a/span");
		selenium.waitForPageToLoad("15000");
		
		Helper.log("Se ha ingresado a la interfaz 'Contraseñas y Bajas");
		selenium.type("id=current_password", "12w3e4r4");
		selenium.type("id=password", "1234567");
		
		selenium.click("xpath=//form[@id='form-validate-pass']/div[2]/button");
		selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Contraseña actual inválida")){
			Helper.log("Caso de prueba éxitoso");
		} else {
			Helper.log("No se está informando al usuario sobre la contraseña acutal no válida");
		}
	}

}
