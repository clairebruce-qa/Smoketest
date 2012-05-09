package claireandbruce.com.test.register;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT4_Test_User_Register_3_UserRegistration_Field_EMail_Invalid extends ClaireandbruceTestCase{

	@Before
	public void setUp() throws Exception {
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		
		Helper.log("Test in :"+selenium.getLocation());
	
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		   System.out.print("Si entra");
		  }	
		
		selenium.click("//a[contains(text(),'Regístrate')]");
		selenium.waitForPageToLoad("30000");
		selenium.isElementPresent("css=label.required");
		
	}

	@Test
	public void testEMailFieldsRegister() throws Exception {
	
		selenium.click("id=email_address");
		selenium.type("id=email_address", "@gmail.com");
		selenium.click("id=password");
		assertTrue(selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		selenium.type("id=email_address", "claireandbruce@gmail");
		selenium.click("id=password");
		assertTrue(selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		selenium.type("id=email_address", "claireandbrucegmail.com");
		selenium.click("css=div.block-user-register");
		assertTrue(selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		selenium.type("id=email_address", "claireandbruce@com");
		selenium.click("id=lastname");
		assertTrue(selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		selenium.type("id=email_address", "claireandbruce@gmail.com");
		selenium.click("id=password");

		
		if(selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.")){
			Helper.log("Error de Prueba");
		}
		else
		{
			Helper.log("Prueba Correcta");
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

