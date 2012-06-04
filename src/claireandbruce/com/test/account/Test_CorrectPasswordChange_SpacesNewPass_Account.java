package claireandbruce.com.test.account;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;

public class Test_CorrectPasswordChange_SpacesNewPass_Account extends ClaireandbruceTestCase {

	@Test
	public void CBT62() throws Exception{
		
		Helper.log("\n*** CASO DE PRUEBA *** CBT62. CAMBIO CORRECTO DE CONTRASEÑA - NUEVA CONTRASEÑA CON ESPACIOS EN ELLA");
		
		Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		
		if(!selenium.getTitle().equals("Mi cuenta")){
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		}
		
		//Ingreso a Contraseña y Bajas
		selenium.click("xpath=//li[3]/a/span");
		selenium.waitForPageToLoad("15000");
		
		Helper.log("Se ha ingresado a la interfaz 'Contraseñas y Bajas");
		selenium.type("id=current_password", password);
		selenium.type("id=password", "12 34 56");
		
		selenium.click("xpath=//form[@id='form-validate-pass']/div[2]/button");
		selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Se guardó la información de la cuenta.")){
			Helper.log("La nueva contraseña ha sido cambiada con éxito");
		} else {
			Helper.log("La nueva contraseña no se ha almacenado éxitosamente");
		}

		//Se ingresan los nuevos datos para que la contraseña anterior sea recuperada
		selenium.type("id=current_password", "12 34 56");
		selenium.type("id=password", password);
		
		selenium.click("xpath=//form[@id='form-validate-pass']/div[2]/button");
		selenium.waitForPageToLoad("15000");
		if(selenium.isTextPresent("Se guardó la información de la cuenta.")){
			Helper.log("La contraseña anterior ha sido recuperada con éxito");
		} else {
			Helper.log("La contraseña anterior no ha sido recuperada éxitosamente");
		}
				
	}

}
