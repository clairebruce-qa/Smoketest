package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 * CBT94
 */
public class TestFooterMiddleNavigationMujer extends ClaireandbruceTestCase{
	
	@Test
	public void CBT94() throws Exception{
		
		
		selenium.open("");
		int i=1;
		
		//Verificación de la presencia de los enlaces en la pagina de bienvenida
		assertTrue(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/ul/li["+i+"]/a"));
		while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/ul/li["+i+"]/a")){
		
			//Obtiene el texto de cada link para verificarlo en la ventana de despliegue
			String text= selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/ul/li["+i+"]/a");
			
			//Se Carga y verifica las interfaces de cada link 
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/ul/li["+i+"]/a", text, "class=breadcrumbs-present");
			
			//Se Retorna a la pagina Principal de Bienvenida
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
			i++;
			
		}
		
		 i=0;
			while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[2]/ul/li["+i+"]/a")){
			//Verificacion de los links del foother para mujer
				
				String text= selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[2]/ul/li["+i+"]/a");
				Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[2]/ul/li["+i+"]/a", text, "class=breadcrumbs-present");
				Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
				i++;
				
			}
	}

}
