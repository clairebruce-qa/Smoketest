package claireandbruce.com.test.navigationWeb;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class Test_FooterMiddleNavigation_AtencionAlCliente  extends ClaireandbruceTestCase{
	
	
	/*Caso de prueba encargado de verificar la correcta navegabilidad
	 *a trav�s de los items  del pie  de p�gina especificados para la
	 *secci�n Ayuda  (DE   COMPRAS,  ESPERANDO,  EN CASA, MI CUENTA). 
	 *El �xito  del proceso se evaluar� al verificar la visualizaci�n
	 *de  la  secci�n  correspondiente  a la  soluci�n de la primera 
	 *pregunta relacionada con el item seleccionado.*/
	
	
	
	@Test
	public void CBT91() throws Exception{
		
		selenium.deleteAllVisibleCookies();
		
		selenium.open("");
		
		
		int i=2;
		if(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[7]/div[2]/ul/li[1]/a")){
			selenium.click("xpath=html/body/div/div[4]/div/div[3]/div[7]/div[2]/ul/li[1]/a");
			Helper.waitForElement(selenium, "xpath=.//*[@id='question-category-block']/div["+i+"]/ul/li[2]/a", "Not present link page");
			
			//Se Retorna a la pagina Principal de Bienvenida
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
		}
		
		while(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[3]/div[7]/div[2]/ul/li["+i+"]/a")){
				
				
				//-----------------    SE DESPLIEGA LA INTERFAZ DEL LINK   ---------------------
				selenium.click("xpath=html/body/div/div[4]/div/div[3]/div[7]/div[2]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("30000");
				System.out.println("\n ESTE ES EL BENDITO TEXTO"+"xpath=html/body/div/div[4]/div/div[3]/div[7]/div[2]/ul/li["+i+"]/a");
				
				
				//--------------------- VERIFICACION DE LA INTERFAZ  -----------------------------
				Helper.waitForElement(selenium, "xpath=.//*[@id='question-category-block']/div["+i+"]/ul/li[2]/a", "Not present link page");
				
				//Se Retorna a la pagina Principal de Bienvenida
				Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
				i++;
				
			}
		}
		//Verificaci�n de la presencia de los enlaces en la pagina de bienvenida
		
		
		
		
	
	

}
