package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**Caso de prueba encargado de verificar la correcta navegabilidad
	 *a través de los items  del pie  de página especificados para la
	 *sección Ayuda  (DE   COMPRAS,  ESPERANDO,  EN CASA, MI CUENTA). 
	 *El éxito  del proceso se evaluará al verificar la visualización
	 *de  la  sección  correspondiente  a la  solución de la primera 
	 *pregunta relacionada con el item seleccionado.
	 *
	 *@author NEWSHORE
	 **/
public class TestFooterMiddleNavigationAtencionAlCliente  extends ClaireandbruceTestCase{
	
	@Test
	public void CBT91() throws Exception{
		
		selenium.deleteAllVisibleCookies();
		Helper.log("Se inicia prueba de Navegación por footer para Atención al Cliente");
		selenium.open("");		
		
		if(selenium.isElementPresent("xpath=//div[6]/div[2]/ul/li/a")){
			Helper.log("Se ingresa a "+selenium.getText("xpath=//div[6]/div[2]/ul/li/a"));
			selenium.click("xpath=//div[6]/div[2]/ul/li/a");
			selenium.waitForPageToLoad("15000");
			assertTrue(selenium.isElementPresent("xpath=//div[@id='question-category-block']/div/ul/li/a"));
			//Se Retorna a la pagina Principal de Bienvenida
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
		}
		int literal=2;
		while(selenium.isElementPresent("xpath=//div[6]/div[2]/ul/li["+literal+"]/a")){

			//-----------------    SE DESPLIEGA LA INTERFAZ DEL LINK   ---------------------
			Helper.log("Se ingresa a "+selenium.getText("xpath=//div[6]/div[2]/ul/li["+literal+"]/a"));
			selenium.click("xpath=//div[6]/div[2]/ul/li["+literal+"]/a");
			selenium.waitForPageToLoad("30000");
				
			//--------------------- VERIFICACION DE LA INTERFAZ  -----------------------------
			selenium.waitForPageToLoad("15000");
			assertTrue(selenium.isElementPresent("xpath=//div[@id='question-category-block']/div["+literal+"]/ul/li/a"));
			
			//Se Retorna a la pagina Principal de Bienvenida
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
			literal++;
				
		}
		}
		//Verificación de la existencia de los enlaces en la página de bienvenida
		
}
