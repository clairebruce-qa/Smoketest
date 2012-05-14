package claireandbruce.com.test.account;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

public class CBT16_Test_User_Addres_Modify_1_Edit_Shipping_Address_User_with_Empty_Fields extends ClaireandbruceTestCase{

	/*
	 * Se verifica en el  sistema la edicion de una direccion cuando
	 * se cambian  los  valores en los campos por vacio, el exito de
	 * la prueba  se reflejara en la no aceptacion de los campos por
	 * parte del  sistema y pedira las correciones del mismo.
	 * */
	
	
	@Test
	public void CBT16() throws Exception{
		
		
	
	//Despliega la pagina de Claireandbruce
	selenium.open("");
	//Ambiente de prueba
	
	Helper.log("Test in :"+selenium.getLocation());
	
	//-----------------------------------Autentica el Usuario----------------------------------
	if(!selenium.isTextPresent("Salir")){
		  Claireandbruce.login(selenium, username, password);
		  
	  }
	
	
		assertTrue(selenium.isElementPresent("class=item my-address active"));
		selenium.click("class=item my-address active");
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
