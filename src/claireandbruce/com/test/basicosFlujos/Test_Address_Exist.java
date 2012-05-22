package claireandbruce.com.test.basicosFlujos;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/* 
 * Esta clase verifica que exista al menos una dirección guardada por defecto, 
 * 
 * 
 * 
 * 
 * */
public class Test_Address_Exist extends ClaireandbruceTestCase {
	
	public void CBT_Addres() throws Exception{
		
	//ok///
	selenium.open("");
	selenium.waitForPageToLoad("15000");
	int i =(int)(Math.random()*100);
	//El usuario no debe tener su sesión iniciada
	if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
		Claireandbruce.login(selenium, username, password);
	}
	
	
	Helper.log("Ambiente de prueba: "+selenium.getLocation());

	
	//Ingresar a traves del botón 'TUS DIRECCIONES' Área privada'
	if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
	} else {//Ingresar a través del link 'Modificar o añadir dirección'
		selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
	}
	
	selenium.waitForPageToLoad("30000");
	
	}
	

}
