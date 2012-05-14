package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import com.thoughtworks.selenium.*;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT81_Test_Subscriptions_YesNo_TuCuenta extends ClaireandbruceTestCase{
	
	/*
	 *Este Caso de Prueba  verificará el  correcto
	 *funcionamiento   del proceso   encargado  de 
	 *modificar  las  suscripciones  que posee  el 
	 *usuario a través  de su cuenta en el portal. 
	 *El éxito del proceso  se evaluará al mostrar 
	 *el mensaje "La suscripción ha sido guardada".  
	 * 
	 * */

	@Test
	public void CBT28() throws Exception {
		
		//Despliega la pagina de Claireandbruce
		selenium.open("");
		
		
		
		//-----------------------------------Autentica el Usuario----------------------------------
		if(!selenium.isTextPresent("Salir")){
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
		
		/*
		 * 1. Click on [Si, quiero recibirlas] [Alertas promocionales]
		 * 2. Click on [No quiero] [E-mails de empresas y marcas]
		 * */
		if(!((("on").equals(selenium.getValue("name=is_subscribed"))) && (("on").equals(selenium.getValue("xpath=(//input[@name='activate'])[2]")))))
		{
			selenium.click("xpath=//input[@name='is_subscribed']");//Esta suscrito
			selenium.click("xpath=(//input[@name='activate'])[2]");//No quiere suscribirse a los emails
			
			//-----------***************GUARDAR LOS CAMBIOS**************-------------------
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("30000");
			System.out.println(""+selenium.isTextPresent("La suscripción ha sido guardada."));
			assertTrue(selenium.isTextPresent("La suscripción ha sido guardada."));
		}
		else
		{
			
			/*Se observa el mismo comportamiento al realizar la prueba con: 
			 *No quiero recibirlas {on} [ALERTAS PROMOCIONALES]
			 *Si, quiero {o} [E-mails de empresas y marcas que colaboran con C+B ]*/
			
			selenium.click("xpath=(//input[@name='is_subscribed'])[2]");//No esta suscrito
			selenium.click("xpath=//input[@name='activate']");//Esta Suscrito a los emails
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.isTextPresent("La suscripción ha sido eliminada."));
		}
		
		
		
	
		Claireandbruce.logout(selenium);
		selenium.stop();
		
		//-----------------------------------------------------------PARA ABRIR EL E-MAIL------------------------------------------------------------------------
		
		//selenium.type("xpath=(//input[@id='email'])[2]", "gmail.com");

		
		String  GmailUrl	=	"http://www.gmail.com";
		String seleniumUrl =	"localhost";
		String seleniumBrowser = System.getProperty("my.browser","*chrome");
		selenium = new DefaultSelenium(seleniumUrl, 4444, seleniumBrowser,GmailUrl );

		
		
		
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("500");
		selenium.setTimeout("100000");
		
		selenium.deleteAllVisibleCookies();
		
		selenium.open("");
		
		
		//--------------***** AUTENTICACION EN EL EMAIL  ****--------------
		selenium.type("xpath=.//*[@id='Email']", "ClaireandBruceQA");
		selenium.type("xpath=.//*[@id='Passwd']", "privaliaqa");
			
		Helper.clickAndVerify(selenium, "xpath=.//input[@id='signIn']", "CLAIRE+BRUCE", "xpath=.//*[@id=':mj']/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(text(),'Cerrar sesión')]");
		selenium.waitForPageToLoad("30000");
		
		//assertTrue(selenium.isTextPresent("CLAIRE+BRUCE"));
		
		selenium.stop();
		
		
	}

}
