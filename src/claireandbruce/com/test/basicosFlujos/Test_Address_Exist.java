package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/* 
 * Esta clase verifica que exista al menos una direcci�n guardada por defecto, 
 * 
 * 
 * 
 * 
 * */
public class Test_Address_Exist extends ClaireandbruceTestCase {
	
	
	@Test
	public void CBT_Addres() throws Exception{
		
	//ok///
		
	selenium.deleteAllVisibleCookies();
	
	selenium.open("");

	selenium.waitForPageToLoad("15000");
	if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		selenium.click("//a[@id='overridelink']");
	}
	//int i =(int)(Math.random()*100);
	//El usuario no debe tener su sesi�n iniciada
	
	
	if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
		Claireandbruce.login(selenium, username, password);
	}
	else{
	
	Helper.log("Ambiente de prueba: "+selenium.getLocation());
/*
	
	//Ingresar a traves del bot�n 'TUS DIRECCIONES' �rea privada'
	if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
	} else {//Ingresar a trav�s del link 'Modificar o a�adir direcci�n'
		selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
	}
	
	selenium.waitForPageToLoad("30000");
	*/
	
	
	
	//------***** Verifica que exista al menos una direcci�n ****------\\
	
	if(selenium.isElementPresent("name=shipping_address_id")){
	
			selenium.click("name=shipping_address_id"); // Si encuantra la direcci�n la selecciona
		
	
			Helper.log("existe una direcci�n por defecto seleccionada");
	}
		else
		{
		
			Helper.log("Se agrego la direcci�n existente por defecto");
			Assert.fail("Error: no existe una direcci�n");
		}
		
	}
	
	
	}
	
	//	SE PONE EN COMENTARIO PARA CORRER EN EL FLUJO
	// 	PARA PRUEBAS UNITARIAS SE ACTIVA
	
	@After
	public void afterTest(){
		selenium.stop();
	}
	

}
