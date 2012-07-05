package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import lib.Helper;
import basics.ClaireandbruceTestCase;

/**
 * Caso de prueba encargado de verificar la correcta navegabilidad a través de los links
 * (AYUDA, CONDICIONES DE USO, POLÍTICAS DE PRIVACIDAD, QUIÉNES SOMOS) encontrados en el Footer.
 * 
 * @author NEWSHORE
 * Testlink: Local CBT93  - Privalia CBT22
 */


public class TestFooterTopNavigation extends ClaireandbruceTestCase {
	
	@Test
	public void cbt22() throws Exception {		
		
		//Validacion del Menu de Navegacion del Footer AYUDAS, Condiciones de Uso, Politicas de Privacidad y Sobre Nosotros
		Helper.log("Se inicia prueba de Navegación por Footer Top");
		selenium.open("/es_es/");
		assertTrue(selenium.isElementPresent("//div/a/cufon/canvas"));
		Helper.log("Se verifica el link para la ventana Ayuda");
		// Verifica link para Ventana Ayuda
		selenium.click("//div/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		if(selenium.isElementPresent("xpath=.//*[@id='question-category-block']/div[1]/ul/li[1]/a")){
			Assert.fail("No se encontró ventana de ayuda");
		}
		Helper.log("Se hace clic en el link de la ventana de bievenida");
		selenium.click("xpath=html/body/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/h1/a/img");// link de la ventana de bienvenida		
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("xpath=//div[2]/a/cufon/canvas")){
			Assert.fail("No se encontro link condiciones de uso");
		}
		
		// Verifica link para Condiciones de uso
		Helper.log("Se ingresa a 'Condiciones de uso'");
		selenium.click("xpath=//div[2]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		if(!selenium.isTextPresent("condiciones de uso"))
		{
			Assert.fail("No se encontro ventana de condiciones de uso");
		}
		
		
		// Se verifica link Políticas de Privacidad
		Helper.log("Se ingresa a 'Políticas de Privacidad'");
		selenium.click("link=Inicio");
		selenium.waitForPageToLoad("30000");
		if(!selenium.isElementPresent("xpath=//div[3]/a/cufon[2]/canvas")){
			Assert.fail("No se encuentra link de políticas de privacidad");
		}
		selenium.click("//div[3]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");		
		
		if(!selenium.isTextPresent("politicas de privacidad")) {
			Assert.fail("No se encontro ventana de políticas de privacidad");
		}		
		
		if(!selenium.isElementPresent("xpath=//div[4]/a/cufon/canvas")) {
			Assert.fail("No se encontro link 'Sobre Nosotros'");
		}
		
		// Verifica link Sobre Nosotros
		Helper.log("Se ingresa al link 'Sobre Nosotros'");
		selenium.click("//div[4]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		if(!selenium.isElementPresent("xpath=//div[4]/a/cufon/canvas"))
		{
			Assert.fail("No se encontró ventana de información Sobre Nosotros");
		}
		
		selenium.click("link=Inicio");
		selenium.waitForPageToLoad("30000");
	}
}
