package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import com.thoughtworks.selenium.*;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT67_Test_Subscriptions_2Yes_TuCuenta extends ClaireandbruceTestCase{
	
	

	@Test
	public void CBT14() throws Exception {
		
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
		
		
		if(!((("on").equals(selenium.getValue("name=is_subscribed"))) && (("on").equals(selenium.getValue("name=activate")))))
		{
			selenium.click("xpath=//input[@name='is_subscribed']");//Esta suscrito
			selenium.click("xpath=//input[@name='activate']");//Esta Suscrito
			
			//-----------***************GUARDAR LOS CAMBIOS**************-------------------
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("30000");
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
		
		
		
		
		
		/*selenium.click("css=div.radiobuttons > p");
		//selenium.click("//input[@name='is_subscribed']");// Esta Suscrito
		//selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		
		
		
		selenium.click("xpath=(//input[@name='is_subscribed'])[2]");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("La suscripción ha sido eliminada."));
		assertTrue(selenium.isElementPresent("css=li.submenu-item-current > span"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Tu cuenta".equals(selenium.getText("css=li.menu-item-current > span"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		
		assertTrue(selenium.isElementPresent("//input[@name='is_subscribed']")); //Si esta Suscrito a las noticias de C+B
		assertTrue(selenium.isElementPresent("//input[@name='activate']"));//Si desearia recibir suscripciones de otras empresas asociadas
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");*/
		
		
		//*******************PARA DEJAR AL USUARIO SUSCRITO*************************
		//selenium.click("xpath=//input[@name='is_subscribed']");//Esta suscrito
		//selenium.click("xpath=//input[@name='activate']");//Esta Suscrito
		//selenium.click("//button[@type='submit']");
		//selenium.waitForPageToLoad("30000");
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
