package claireandbruce.com.test.navigationWeb;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT94_Test_FooterMiddleNavigation_Mujer extends ClaireandbruceTestCase{
	
	@Test
	public void CBT41() throws Exception{
		
		
		selenium.open("");
		int i=1;
		
		//Verificación de la presencia de los enlaces en la pagina de bienvenida
		while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/ul/li["+i+"]/a")){
		
			//Obtiene el texto de cada link para verificarlo en la ventana de despliegue
			String text= selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/ul/li["+i+"]/a");
			System.out.println("\n ESTE ES EL BENDITO TEXTO"+text);
			
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
				System.out.println("\n ESTE ES EL BENDITO TEXTO"+text);
				Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[2]/ul/li["+i+"]/a", text, "class=breadcrumbs-present");
				Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
				i++;
				
			}
	}

}
