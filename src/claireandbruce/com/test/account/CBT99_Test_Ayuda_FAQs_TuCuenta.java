package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT99_Test_Ayuda_FAQs_TuCuenta extends ClaireandbruceTestCase{
	
	
	@Test
	public void CBT99() throws Exception
	{
		//Despliega la pagina de Claireandbruce
		selenium.open("");
		
		
		
		//-----------------------------------Autentica el Usuario----------------------------------
		if(!selenium.isTextPresent("Salir")){
			  Claireandbruce.login(selenium, username, password);
			  
		}
		
		if(!("Tu Cuenta").equals(selenium.getTitle())){
			  selenium.open("/es_es/customer/account/");
			  
		  }
		
		//--------------------Se Verifica el lin ks AYUDA/FAQ�s-------------------------------------
		assertTrue(selenium.isElementPresent("class=link"));
		selenium.click("class=link");
		
		//---------------------Se Valida la pagina de Ayuda---------------------------------
		Helper.waitForElement(selenium,"xpath=.//*[@id='questions']/a", "Not element found");
		
		
		
	}

}
