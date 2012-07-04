package claireandbruce.com.test.register;

import static org.junit.Assert.assertTrue;
import lib.Helper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * CBT4
 * @author NEWSHORE
 *
 */
public class TestUserRegister3UserRegistrationFieldEMailInvalid extends ClaireandbruceTestCase{

	@Before
	public void setUp() throws Exception {
		Helper.log("Se inicia prueba de formatos de email no válidos");
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		
		Helper.log("Prueba en:"+ClaireandbruceUrl);
	
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		   System.out.print("Si entra");
		  }	
		Helper.log("Se hace clic en 'Regístrate' ubicado en la sección superior de la página");
		selenium.click("//a[contains(text(),'Regístrate')]");
		selenium.waitForPageToLoad("30000");
		selenium.isElementPresent("css=label.required");
		
	}

	@Test
	public void CBT4() throws Exception {
	
		Helper.log("Se ingresan datos no válidos de email: @gmail.com");
		selenium.type("id=email_address", "@gmail.com");
		selenium.click("id=password");
		Helper.log("Se verifica mensaje de advertencia");
		assertTrue("Mensaje de advertencia no encontrado",selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		Helper.log("Se ingresan datos no válidos de email: claireandbruce@gmail");
		selenium.type("id=email_address", "claireandbruce@gmail");
		selenium.click("id=password");
		Helper.log("Se verifica mensaje de advertencia");
		assertTrue("Mensaje de advertencia no encontrado",selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		Helper.log("Se ingresan datos no válidos de email: claireandbrucegmail.com");
		selenium.type("id=email_address", "claireandbrucegmail.com");
		selenium.click("css=div.block-user-register");
		Helper.log("Se verifica mensaje de advertencia");
		assertTrue("Mensaje de advertencia no encontrado",selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		Helper.log("Se ingresan datos no válidos de email: claireandbruce@com");
		selenium.type("id=email_address", "claireandbruce@com");
		selenium.click("id=lastname");
		Helper.log("Se verifica mensaje de advertencia");
		assertTrue("Mensaje de advertencia no encontrado",selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		Helper.log("Se ingresan datos válidos de email: claireandbruce@gmail.com");
		selenium.type("id=email_address", "claireandbruce@gmail.com");
		selenium.click("id=password");
		Helper.log("Se verifica que no se encuentre visible el mensaje de advertencia");
		
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

