package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba  verificará el  correcto funcionamiento   del proceso   encargado  de 
 * modificar  las  suscripciones  que posee  el usuario a través  de su cuenta en el portal. 
 * El éxito del proceso  se evaluará al mostrar el mensaje "La suscripción ha sido guardada".  
 * 
 * Testlink: Local CBT81 - Privalia CBT60
 * @author NEWSHORE
 * */

public class TestSubscriptionsYesNoAccount extends ClaireandbruceTestCase{
	
	@Test
	public void cbt60() throws Exception {
		
		//-----------------------------------Autentica el Usuario----------------------------------
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			  LibCorrectLogonValidUserAccout.CBT55(selenium);				  
		}
	
		if(!selenium.getTitle().equals("Mi cuenta")){
			selenium.waitForPageToLoad("5000");
			Helper.log("Se ingresa a link 'Mi cuenta'");
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("15000");
		}
		
		//--------verifica que el link de TUS SUSCRIPCIONES ESTE HABILITADO------------
		Helper.log("Se ingresa al link 'TUS SUSCRIPCIONES'");
		selenium.click("xpath=//div[2]/li[2]/a/span");
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isTextPresent("Tus suscripciones")){
			Helper.log("EL TEXTO ENCONTRADO ES EL SIGUIENTE"+selenium.getTitle());
		}
		
		//--------------Verifica que los botones esten habilitados-----------------
		assertTrue("Suscripción a noticias c+b",selenium.isElementPresent("//input[@name='is_subscribed']")); //Si esta Suscrito a las noticias de C+B
		assertTrue("Suscripción a otras empresas",selenium.isElementPresent("//input[@name='activate']"));//Si desearia recibir suscripciones de otras empresas asociadas
		
		/*
		 * 1. Click on [Si, quiero recibirlas] [Alertas promocionales]
		 * 2. Click on [No quiero] [E-mails de empresas y marcas]
		 * */
		if(!((("on").equals(selenium.getValue("name=is_subscribed"))) && (("on").equals(selenium.getValue("xpath=(//input[@name='activate'])[2]")))))
		{
			Helper.log("Se realiza la suscripción a las alertas promocionales");
			selenium.click("xpath=//input[@name='is_subscribed']");//Esta suscrito
			Helper.log("Se elimina la suscripción a los emails de empresas y marcas");
			selenium.click("xpath=(//input[@name='activate'])[2]");//No quiere suscribirse a los emails
			
			//-----------***************GUARDAR LOS CAMBIOS**************-------------------
			Helper.log("Se hace clic en el botón 'GUARDAR'");
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("30000");
			Helper.log("Se verifica el mensaje de confirmación de la suscripción");
			assertTrue(selenium.isTextPresent("La suscripción ha sido guardada."));
		}
		else
		{
			
			/*Se observa el mismo comportamiento al realizar la prueba con: 
			 *No quiero recibirlas {on} [ALERTAS PROMOCIONALES]
			 *Si, quiero {o} [E-mails de empresas y marcas que colaboran con C+B ]*/
			Helper.log("Se elimina la suscripción a alertas promocionales");
			selenium.click("xpath=(//input[@name='is_subscribed'])[2]");//No esta suscrito
			Helper.log("Se realiza la suscripción a otras empresas y marcas");
			selenium.click("xpath=//input[@name='activate']");//Esta Suscrito a los emails
			Helper.log("Se hace clic en el botón 'GUARDAR'");
			selenium.click("//button[@type='submit']");
			selenium.waitForPageToLoad("30000");
			Helper.log("Se verifica el mensaje de confirmación de la suscripción");
			assertTrue("Mensaje no visualizado",selenium.isTextPresent("La suscripción ha sido eliminada."));
		}
	
		Helper.log("Se realiza un logout de la cuenta");
		Claireandbruce.logout(selenium);
		selenium.stop();		
	}
}