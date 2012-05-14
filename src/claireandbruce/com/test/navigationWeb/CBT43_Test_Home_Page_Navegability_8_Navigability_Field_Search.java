package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT43_Test_Home_Page_Navegability_8_Navigability_Field_Search extends ClaireandbruceTestCase {
	
	@Test
	public void CBT43() throws Exception{
		
		//Se desplega la ventana de navegacion
		selenium.open("/es_es/");
		
		//verifica que el campo de busqueda existe en C+B  y esta habilitado
		assertTrue(selenium.isElementPresent("id=search"));
		
		//Verifica que si el valor para el campo esta vacio no lo ejecute
		selenium.click("css=input.zoom-icon");
		assertTrue(!selenium.isElementPresent("css=span.price"));
		selenium.type("id=search", "&%$â€¢â€¢\"%///");
		selenium.click("css=input.zoom-icon");
		//String text=selenium.getText("//div[3]/div/p");
		//System.out.println(text);
		Helper.clickAndVerify(selenium, "css=input.zoom-icon", "La búsqueda no da ningún resultado.", "xpath=//div[3]/div/p");
		//selenium.waitForPageToLoad("30000");
		/*assertTrue(selenium.isElementPresent("css=span.breadcrumbs-present"));
		assertTrue(selenium.isTextPresent("La búqueda no da ningún resultado."));
		*/selenium.type("id=search", "123");
		selenium.click("css=input.zoom-icon");

		selenium.waitForPageToLoad("30000");
		
		selenium.click("css=div.breadcrumbs-page > ul");
		
		String texto=selenium.getText("css=span.price");
		Helper.clickAndVerify(selenium, "css=div.breadcrumbs-page > ul", texto, "css=span.price");
		
		//assertTrue(selenium.isElementPresent("css=span.price"));
		selenium.type("id=search", "SHORT");
		selenium.click("css=input.zoom-icon");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Inicio > Resultados de búsqueda para: 'SHORT'".equals(selenium.getText("css=div.breadcrumbs-page > ul"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		
		//Busqueda de productos que sean tipo camisa
		selenium.type("id=search", "Camisa");
		selenium.click("css=input.zoom-icon");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.breadcrumbs-page > ul");
		assertTrue(selenium.isTextPresent("Camisa"));
		
		
		//Busqueda para Cadenas no coherentes
		selenium.type("id=search", "RERRFSFES");
		selenium.click("css=input.zoom-icon");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Resultados de búsqueda para: 'RERRFSFES'".equals(selenium.getText("css=span.breadcrumbs-present"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("La búsqueda no da ningún resultado.".equals(selenium.getText("css=p.note-msg"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		
		selenium.type("id=search", "short");
		selenium.click("css=input.zoom-icon");
		selenium.waitForPageToLoad("30000");	
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Resultados de búsqueda para: 'short'".equals(selenium.getText("css=span.breadcrumbs-present"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		if (!(selenium.isTextPresent("Short")))
		{ 
			
			assertTrue(selenium.isElementPresent("css=p.note-msg"));
		}
		
		
		/*for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Resultados de búsqueda para: 'short'".equals(selenium.getText("css=span.breadcrumbs-present"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		
		

		

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Resultados de búsqueda para: '123'".equals(selenium.getText("css=span.breadcrumbs-present"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		*/
	}
	

}
