package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/** Este  informe se  realiza  con el  fin de  mostrar  y
 * verificar  el correcto desempe�o   de la  funci�n  de
 * la aplicaci�n web para modificar en ella a un usuario
 * registrado ,  la eficacia  del  caso  de  prueba ser� 
 * comprobando   el �xito  de  la  operaci�n al realizar
 * modificar los datos del usuario logueado en el sistema. 
 * 
 * CBT8
 * @author NEWSHORE
 * */


public class TestUserModify1UserModifyDataValidField extends ClaireandbruceTestCase{

	
	@Test
	public void CBT8() throws Exception{		
		//Despliega la pagina de Claireandbruce
		selenium.open("");
			
				
		//-----------------------------------Autentica el Usuario----------------------------------
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){		
				Claireandbruce.login(selenium, username, password);
		}
		
		//------------*************VERIFICA LINK DE TUS DATOS PERSONALES****************--------------------------
		assertTrue(selenium.isElementPresent("xpath=//div[2]/li/a/span"));
		selenium.click("xpath=//div[2]/li/a/span");
		selenium.waitForPageToLoad("30000");
		//------------la decision verifica que siempre se cambien los datos-------------------
	
		selenium.type("id=firstname", "Claire");
		selenium.type("id=lastname", "Bruce");
		selenium.type("//input[@id='email']", "claireandbruceqa@gmail.com");
		selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("//div[@value='27']");
		selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("xpath=(//div[@value='7'])[2]");
		selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("//div[@value='1985']");
				
		selenium.click("css=button.button");
		selenium.waitForPageToLoad("30000");
		selenium.isTextPresent("Se guard� la informacion de la cuenta.");
		selenium.type("//input[@id='email']", username);
			
		//------------la decisi�n verifica que siempre se cambien los datos-------------------
		selenium.type("id=firstname", "Claire Bruce");
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
		selenium.isTextPresent("Se guard� la informacion de la cuenta.");
	
		selenium.type("//input[@id='email']", username);
		selenium.click("css=button.button");
		selenium.waitForPageToLoad("30000");
		selenium.isTextPresent("Se guard� la informacion de la cuenta.");	  
	}	
}