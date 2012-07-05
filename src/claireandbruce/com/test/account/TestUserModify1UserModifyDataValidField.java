package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/** Este  informe se  realiza  con el  fin de  mostrar  y
 * verificar  el correcto desempe�o   de la  funci�n  de
 * la aplicaci�n web para modificar en ella a un usuario
 * registrado ,  la eficacia  del  caso  de  prueba ser� 
 * comprobando   el �xito  de  la  operaci�n al realizar
 * modificar los datos del usuario logueado en el sistema. 
 * 
 * Testlink: Local CBT8 - Privalia CBT54
 * @author NEWSHORE
 * */


public class TestUserModify1UserModifyDataValidField extends ClaireandbruceTestCase{

	
	@Test
	public void cbt54() throws Exception{		
		//Despliega la pagina de Claireandbruce
		Helper.log("Se inicia prueba sobre modificaci�n de datos personales");
		selenium.open("");
			
				
		//-----------------------------------Autentica el Usuario----------------------------------
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){		
				LibCorrectLogonValidUserAccout.CBT55(selenium);
		}
		
		//------------*************VERIFICA LINK DE TUS DATOS PERSONALES****************--------------------------
		assertTrue(selenium.isElementPresent("xpath=//div[2]/li/a/span"));
		selenium.click("xpath=//div[2]/li/a/span");
		selenium.waitForPageToLoad("30000");
		//------------la decision verifica que siempre se cambien los datos-------------------
	
		Helper.log("Se ingresan los datos de usuario");
		selenium.type("id=firstname", "Claire");
		selenium.type("id=lastname", "Bruce");
		selenium.type("//input[@id='email']", username);
		selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("//div[@value='27']");
		selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("xpath=(//div[@value='7'])[2]");
		selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("//div[@value='1985']");
		Helper.log("Se hace clic en el bot�n 'GUARDA TUS DATOS'");		
		selenium.click("css=button.button");
		selenium.waitForPageToLoad("30000");
		Helper.log("Se verifica que se guard� la informaci�n de la cuenta");
		assertTrue("Informaci�n no almacenada",selenium.isTextPresent("Se guard� la informaci�n de la cuenta."));
			
		//------------la decisi�n verifica que siempre se cambien los datos-------------------
		Helper.log("Se cambian nuevamente los datos");
		selenium.type("id=firstname", "Claire Bruce");
		selenium.type("id=lastname", "QA");
		selenium.type("//input[@id='email']", username);
		selenium.click("css=span.dob-day > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("//div[@value='3']");
		selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("xpath=(//div[@value='2'])[2]");
		selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
		selenium.click("//div[@value='1988']");
		Helper.log("Se hace clic en el bot�n 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		selenium.waitForPageToLoad("30000");
		Helper.log("Se verifica el texto 'Se guard� la informaci�n de la cuenta.'");
		assertTrue("Informaci�n no almacenada", selenium.isTextPresent("Se guard� la informaci�n de la cuenta."));
	
		selenium.type("//input[@id='email']", username);
		selenium.click("css=button.button");
		selenium.waitForPageToLoad("30000");
		assertTrue("Informaci�n no almacenada", selenium.isTextPresent("Se guard� la informaci�n de la cuenta."));	  
	}	
}