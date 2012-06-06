package claireandbruce.com.test.account;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

public class CBT16_Test_User_Addres_Modify_1_Edit_Shipping_Address_User_with_Empty_Fields extends ClaireandbruceTestCase{

	/*
	 * Se verifica en el  sistema la edición de una dirección cuando
	 * se cambian  los  valores en los campos por vacío, el éxito de
	 * la prueba  se reflejará en la no aceptación de los campos por
	 * parte del  sistema y pedirá las correcciones del mismo.
	 * */	
	
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
			selenium.click("link=Tu cuenta");
			selenium.waitForPageToLoad("15000");
		} else {
			selenium.click("xpath=//div[3]/li/a/span");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=spanNewAddress");
			assertTrue(selenium.isElementPresent("css=button.button"));
			selenium.click("css=button.button");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-firstname"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-lastname"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-street_1"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-city"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-zip"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-validate-select-region_id_"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-telephone"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

		}
	}
}
