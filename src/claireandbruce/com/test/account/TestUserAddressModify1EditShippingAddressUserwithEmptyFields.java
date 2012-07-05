package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/**
	 * Se verifica en el  sistema la edici�n de una direcci�n cuando
	 * se cambian  los  valores en los campos por vac�o, el �xito de
	 * la prueba  se reflejar� en la no aceptaci�n de los campos por
	 * parte del  sistema y pedir� las correcciones del mismo.
	 * Testlink: Local CBT16 - Privalia CBT57
	 * @author NEWSHORE
	 * */
public class TestUserAddressModify1EditShippingAddressUserwithEmptyFields extends ClaireandbruceTestCase{

	@Test
	public void cbt57() throws Exception{		
	
		Helper.log("Se inicia prueba de modificaci�n de las direcciones de env�o por datos vac�os");
		//Despliega la p�gina de Claireandbruce
		selenium.open("");
		//Ambiente de prueba
		
		Helper.log("Test in :"+selenium.getLocation());
		
		//-----------------------------------Autentica el Usuario----------------------------------
	
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			LibCorrectLogonValidUserAccout.CBT55(selenium);
		}
			
		if(!selenium.isElementPresent("xpath=//div[3]/li/a/span")){
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		} else {
			Helper.log("Se hace clic en el link del men� lateral derecho 'Modificar o a�adir direcci�n'");
			selenium.click("xpath=//div[3]/li/a/span");
			selenium.waitForPageToLoad("30000");
			Helper.log("Se hace clic en 'Editar'");
			selenium.click("css=span.edit");
			
			//Ingreso de datos vac�os
			Helper.log("Se ingresa en el campo nombre un dato vac�o");
			selenium.type("xpath=(//input[@id='firstname'])[2]", "");
			selenium.click("xpath=(//input[@id='lastname'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				Helper.log("Se verifica el mensaje de advertencia 'Campo obligatorio.'");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-firstname"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Helper.log("Se ingresa en el campo apellido un dato vac�o");
			selenium.type("xpath=(//input[@id='lastname'])[2]", "");
			selenium.click("xpath=(//input[@id='street_1'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				Helper.log("Se verifica el mensaje de advertencia 'Campo obligatorio.'");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-lastname"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Helper.log("Se ingresa en el campo direcci�n un dato vac�o");
			selenium.type("xpath=(//input[@id='street_1'])[2]", "");
			selenium.click("xpath=(//input[@id='city'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				Helper.log("Se verifica el mensaje de advertencia 'Campo obligatorio.'");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-street_1"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Helper.log("Se ingresa en el campo Poblaci�n un dato vac�o");
			selenium.type("xpath=(//input[@id='city'])[2]", "");
			selenium.click("xpath=(//input[@id='zip'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				Helper.log("Se verifica el mensaje de advertencia 'Campo obligatorio.'");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-city"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Helper.log("Se ingresa en el campo C�digo Postal un dato vac�o");
			selenium.type("xpath=(//input[@id='zip'])[2]", "");
			selenium.click("xpath=(//input[@id='telephone'])[2]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				Helper.log("Se verifica el mensaje de advertencia 'Campo obligatorio.'");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-zip"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Helper.log("Se ingresa en el campo Tel�fono un dato vac�o");
			selenium.type("xpath=(//input[@id='telephone'])[2]", "");
			selenium.click("xpath=(//div[@value=''])[2]");
			/*for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-validate-select-region_id_"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}*/
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				Helper.log("Se verifica el mensaje de advertencia 'Campo obligatorio.'");
				try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-telephone"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			//assertTrue(selenium.isElementPresent("css=button.button.validation-passed"));
			Helper.log("Se hace clic en el bot�n 'GUARDAR'");
			selenium.click("xpath=(//button[@type='submit'])[2]");	
			
			//Se confirma que contin�e mostrando los mensajes de advertencia
			assertTrue("Mensaje de advertencia no visualizado en campo Nombre","Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-firstname")));
			assertTrue("Mensaje de advertencia no visualizado en campo Apellidos","Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-lastname")));
			assertTrue("Mensaje de advertencia no visualizado en campo Direcci�n","Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-street_1")));
			assertTrue("Mensaje de advertencia no visualizado en campo Poblaci�n","Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-city")));
			assertTrue("Mensaje de advertencia no visualizado en campo C�digo Postal","Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-zip")));
			assertTrue("Mensaje de advertencia no visualizado en campo Tel�fono contacto","Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-telephone")));
				
		}
	}
}
