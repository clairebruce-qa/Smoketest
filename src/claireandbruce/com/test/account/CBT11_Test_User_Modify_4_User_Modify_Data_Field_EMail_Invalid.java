package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT11_Test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid extends ClaireandbruceTestCase {

	@Test
	public void test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid () throws Exception{
		Claireandbruce.login(selenium, username,password);
		
		//Click en el link "Tu cuenta" Pagina Tu cuenta
		Helper.clickAndVerify(selenium, "class=item account-configuration", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		
		//PASO 1. Testlink
		//Se ingresa en el campo email {@gmail.com}
		selenium.type("id=email", "@gmail.com");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		//PASO 2. Testlink
		//Se ingresa en el campo email {claireandbruce@gmail}
		selenium.type("id=email", "claireandbruce@gmail");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
	
		//PASO 3. Testlink
		//Se ingresa en el campo email {claireandBruce@.com}
		selenium.type("id=email", "claireandBruce@.com");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		//PASO 4. Testlink
		//Se ingresa en el campo email {claireandbrucegmail.com}
		selenium.type("id=email", "claireandbrucegmail.com");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
	}
}
