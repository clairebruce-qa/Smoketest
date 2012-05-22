package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;

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
	//El usuario no debe tener su sesión iniciada
	
	
	if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
		Claireandbruce.login(selenium, username, password);
	}
	else{
	
	Helper.log("Ambiente de prueba: "+selenium.getLocation());
/*
	
	//Ingresar a traves del botón 'TUS DIRECCIONES' Área privada'
	if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
	} else {//Ingresar a través del link 'Modificar o añadir dirección'
		selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
	}
	
	selenium.waitForPageToLoad("30000");
	*/
	
	
	
	//------***** Verifica que exista al menos una dirección ****------\\
	
	if(selenium.isElementPresent("name=shipping_address_id")){
	
			selenium.click("name=shipping_address_id"); // Si encuantra la dirección la selecciona
		
	
			Helper.log("existe una dirección por defecto seleccionada");
	}
		else
		{
		
			Helper.log("Se agrego la dirección existente por defecto");
			Assert.fail("Error: no existe una dirección");
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
