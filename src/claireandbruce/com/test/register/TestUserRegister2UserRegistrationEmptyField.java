package claireandbruce.com.test.register;

import static org.junit.Assert.*;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * Testlink: Local CBT3 - Privalia CBT52
 * @author NEWSHORE
 *
 */
public class TestUserRegister2UserRegistrationEmptyField extends ClaireandbruceTestCase{

	@Before
	public void setUp() throws Exception {
		Helper.log("Se inicia prueba de registro con datos vac�os");
		Helper.log("Se eliminan cookies de selenium");
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		Helper.log("Se carga p�gina "+ClaireandbruceUrl);
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		}	
		
		Helper.log("Clic en Reg�strate ubicado en la secci�n superior de la p�gina");
		selenium.click("//a[contains(text(),'Reg�strate')]");
		selenium.waitForPageToLoad("30000");
		selenium.isElementPresent("css=label.required");
		
	}

	@Test
	public void cbt52() throws Exception {
	
		Helper.log("Se hace clic en el bot�n 'SIGUE CON TU COMPRA' sin ingresar datos");
		selenium.click("id=registerSubmitButton");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			Helper.log("Se verifica mensaje de advertencia sobre el nombre del usuario (vac�o)");
			try { if (selenium.isElementPresent("id=advice-required-entry-firstname")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			Helper.log("Se verifica mensaje de advertencia sobre el apellido del usuario (vac�o)");
			try { if (selenium.isElementPresent("id=advice-required-entry-lastname")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			Helper.log("Se verifica mensaje de advertencia sobre el email del usuario (vac�o)");
			try { if (selenium.isElementPresent("id=advice-required-entry-email_address")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			Helper.log("Se verifica mensaje de advertencia sobre la contrase�a ingresada por el usuario (vac�o)");
			try { if (selenium.isElementPresent("id=advice-required-entry-password")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			Helper.log("Se verifica mensaje de advertencia sobre aceptaci�n de t�rminos (No seleccionado)");
			try { if (selenium.isElementPresent("id=advice-validate-terms-")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
