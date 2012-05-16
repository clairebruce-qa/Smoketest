package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import com.thoughtworks.selenium.*;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/*
 * Este Caso de Prueba verificará el correcto funcionamiento del  proceso
 * encargado de modificar las suscripciones que posee el usuario a través
 * de su cuenta en el portal. El éxito del proceso se evaluará al mostrar 
 * el mensaje "La suscripción ha sido guardada".
 * 
 * */
public class CBT67_Test_Subscriptions_2Yes_TuCuenta extends ClaireandbruceTestCase{
	
	

	@Test
	public void CBT67() throws Exception {
		
		//Despliega la pagina de Claireandbruce
		selenium.open("");
		
		
		
		//-----------------------------------Autentica el Usuario----------------------------------
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			  Claireandbruce.login(selenium, username, password);
			  
		  }
	
		//--------verifica que el link de TUS SUSCRIPCIONES ESTE HABILITADO------------
		assertTrue(selenium.isElementPresent("//div[2]/li[2]/a/span"));
		selenium.click("//div[2]/li[2]/a/span");
		selenium.waitForPageToLoad("30000");
		
		
		if(!selenium.isTextPresent("Tus suscripciones")){
			Helper.log("EL TEXTO ENCONTRADO ES EL SIGUIENTE"+selenium.getTitle());
		}
		
		//--------------Verifica que los botones esten habilitados-----------------
		assertTrue(selenium.isElementPresent("//input[@name='is_subscribed']")); //Si esta Suscrito a las noticias de C+B
		assertTrue(selenium.isElementPresent("//input[@name='activate']"));//Si desearia recibir suscripciones de otras empresas asociadas
		
		
		if(!((("on").equals(selenium.getValue("name=is_subscribed"))) && (("on").equals(selenium.getValue("name=activate")))))
		{
			selenium.click("xpath=//input[@name='is_subscribed']");//Esta suscrito
			selenium.click("xpath=//input[@name='activate']");//Esta Suscrito
			
			//-----------***************GUARDAR LOS CAMBIOS**************-------------------
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("60000");
			System.out.println(""+selenium.isTextPresent("La suscripción ha sido guardada."));
			assertTrue(selenium.isTextPresent("La suscripción ha sido guardada."));
		}
		else
		{
			selenium.click("xpath=(//input[@name='is_subscribed'])[2]");//No esta suscrito
			selenium.click("xpath=(//input[@name='activate'])[2]");//No esta Suscrito
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.isTextPresent("La suscripción ha sido eliminada."));
		}
		
		
		
		
		
		
	}

}
