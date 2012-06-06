package claireandbruce.com.test.account;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/**
	 * Se verifica en el  sistema la edición de una dirección cuando
	 * se cambian  los  valores en los campos por vacío, el éxito de
	 * la prueba  se reflejará en la no aceptación de los campos por
	 * parte del  sistema y pedirá las correcciones del mismo.
	 * CBT16
	 * @author NEWSHORE
	 * */
public class TestUserAddresModify1EditShippingAddressUserwithEmptyFields extends ClaireandbruceTestCase{

		
	
	@Test
	public void CBT16() throws Exception{		
	
		//Despliega la página de Claireandbruce
		selenium.open("");
		//Ambiente de prueba
		
		Helper.log("Test in :"+selenium.getLocation());
		
		//-----------------------------------Autentica el Usuario----------------------------------
	
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.login(selenium, username, password);
		}
			
		if(!selenium.isElementPresent("xpath=//div[3]/li/a/span")){
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		} else {
			selenium.click("xpath=//div[3]/li/a/span");
			selenium.waitForPageToLoad("30000");
			selenium.click("css=span.edit");
			
			//Ingreso de datos vacíos
			selenium.type("xpath=(//input[@id='firstname'])[2]", "");
			selenium.click("xpath=(//input[@id='lastname'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-firstname"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			selenium.type("xpath=(//input[@id='lastname'])[2]", "");
			selenium.click("xpath=(//input[@id='street_1'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-lastname"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			selenium.type("xpath=(//input[@id='street_1'])[2]", "");
			selenium.click("xpath=(//input[@id='city'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-street_1"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			selenium.type("xpath=(//input[@id='city'])[2]", "");
			selenium.click("xpath=(//input[@id='zip'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-city"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			selenium.type("xpath=(//input[@id='zip'])[2]", "");
			selenium.click("xpath=(//input[@id='telephone'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-zip"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			selenium.type("xpath=(//input[@id='telephone'])[2]", "");
			selenium.click("xpath=(//div[@value=''])[2]");
			/*for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-validate-select-region_id_"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}*/
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-telephone"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			//assertTrue(selenium.isElementPresent("css=button.button.validation-passed"));
			selenium.click("xpath=(//button[@type='submit'])[2]");	
			
			//Se confirma que continúe mostrando los mensajes de advertencia
			assertTrue("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-firstname")));
			assertTrue("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-lastname")));
			assertTrue("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-street_1")));
			assertTrue("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-city")));
			assertTrue("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-zip")));
			assertTrue("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-telephone")));
				
		}
	}
}
