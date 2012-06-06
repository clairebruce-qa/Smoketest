package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**Este caso de prueba valida la funcionalidad del sistema frente al cambio de idioma
 * @author NEWSHORE
 * */

public class TestHomePageNavegability7NavigabilityMenuLanguage extends ClaireandbruceTestCase {

	@Test
	public void CBT42() throws Exception {
		
		
		//se despliega la pagina de claire and bruce en idioma español
		selenium.open("/es_es/");
		
		//se verifica que el campo de lenguaje sea el correcto en este caso ES
		selenium.click("css=strong.current.language-es_es");
		selenium.isTextPresent("ES");
		
		//Se Selecciona el Lenguaje Italiano
		selenium.click("id=div-2");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			//Verifica el cambio de idioma a IT
			try { if ("IT".equals(selenium.getText("css=#div-it_it > span"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		//Boton de Cambiar Idioma
		selenium.click("//div[@onclick='redirectWebsite()']");
		selenium.waitForPageToLoad("60000");
		//Verificacion que la pagina esta en idioma Italiano 
		selenium.isElementPresent("link=Registrati");
		selenium.isElementPresent("link=Accedi");
		
		selenium.click("css=strong.current.language-it_it");
		selenium.click("css=#div-1 > span.selectable > div.float-left.website-name");
		//Se desea cambiar el Idioma =ES
		selenium.isElementPresent("css=#div-es_es > span");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("ES")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		// Se redirecciona a la pagina principal de Claire&Bruce en Español
		selenium.click("//div[@onclick='redirectWebsite()']");
		selenium.waitForPageToLoad("30000");
		
		//Se verifica la correcta traduccion en el Home Page
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			
			try { if (selenium.isTextPresent("Regístrate")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Tu cuenta")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	
	}
}
