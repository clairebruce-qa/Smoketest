package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/* Este  informe se  realiza  con el  fin de  mostrar  y
 * verificar  el correcto desempeño   de la  función  de
 * la aplicación web para modificar en ella a un usuario
 * registrado ,  la eficacia  del  caso  de  prueba será 
 * comprobando   el éxito  de  la  operación al realizar
 * modificar los datos del usuario logueado en el sistema. */


public class CBT8_Test_User_Modify_1_User_Modify_Data_valid_Field extends ClaireandbruceTestCase{

	
	
	@Test
	public void CBT8() throws Exception{
		
	//Despliega la pagina de Claireandbruce
	selenium.open("");
		
			
	//-----------------------------------Autentica el Usuario----------------------------------
	if(!selenium.isTextPresent("Salir")){
		
			Claireandbruce.login(selenium, username, password);
		
		
			
		
	}

		
	
	//------------*************VERIFICA LINK DE TUS DATOS PERSONALES****************--------------------------
			assertTrue(selenium.isElementPresent("css=div.item.account-configuration"));
			selenium.click("css=div.item.account-configuration");
			selenium.waitForPageToLoad("30000");
			//------------la decision verifica que siempre se cambien los datos-------------------

			selenium.type("id=firstname", "Claire");
			selenium.type("id=lastname", "andBruceQA");
			selenium.type("//input[@id='email']", "claireandbruceqa@gmail.es");
			selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("//div[@value='27']");
			selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("xpath=(//div[@value='7'])[2]");
			selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("//div[@value='1985']");
			
			selenium.click("css=button.button");
			selenium.waitForPageToLoad("30000");
			selenium.isTextPresent("Se guardó la informacion de la cuenta.");
			selenium.type("//input[@id='email']", "claireandbruceqa@gmail.com");
			
	
		
			//------------la decision verifica que siempre se cambien los datos-------------------
			selenium.type("id=firstname", "ClaireandBruce");
			selenium.type("id=lastname", "QA");
			selenium.type("//input[@id='email']", "claireandbruceqa@gmail.com");
			selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("//div[@value='14']");
			selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("xpath=(//div[@value='8'])[2]");
			selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("//div[@value='1988']");
			selenium.click("css=button.button");
			selenium.waitForPageToLoad("30000");
			selenium.isTextPresent("Se guardó la informacion de la cuenta.");
	
	selenium.type("//input[@id='email']", "claireandbruceqa@gmail.com");
	selenium.click("css=button.button");
	selenium.waitForPageToLoad("30000");
	selenium.isTextPresent("Se guardó la informacion de la cuenta.");	  
	}
		
	///*****************OJO LOS DATOS DEL E-MAIL NO SE CAMBIAN********************************
	
	}

